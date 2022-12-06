/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.flights;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Flight.Flight;
import mysql.util.MySQLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author slenk
 */
public class FlightUtils {
    
    public static ArrayList<Flight> getListOfFlightSearch(String departureCity, String arrivalCity,
            String departureDate, int passenger) throws IOException,
            InterruptedException, ParserConfigurationException, SAXException {
        
        System.out.println("flight utils called!");
        
        ArrayList<Flight> flightSearchList = new ArrayList<>();
        
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://timetable-lookup.p.rapidapi.com/"
                        + "TimeTable/" + departureCity + "/" + arrivalCity +
                        "/" + departureDate +"/?Connection=NONSTOP"))
		.header("X-RapidAPI-Key", "79357b13e8mshbbb17379ff07c75p1a3f34jsn845570293c89")
		.header("X-RapidAPI-Host", "timetable-lookup.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, 
                HttpResponse.BodyHandlers.ofString());
        
        String str = response.body().toString();
        System.out.println(str);
        str = str.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
        
//        System.out.println("Response" + str);
        
        StringReader strReader = new StringReader(response.toString());
        
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(new InputSource(new StringReader(response.body().toString())));
                
        NodeList errNodes = doc.getElementsByTagName("FlightLegDetails");       
        
        int nodes = 0;
        while(nodes < errNodes.getLength()) {
            Element flightLegEle = (Element)errNodes.item(nodes);
            String totalFlightTime = flightLegEle.getAttribute("JourneyDuration");
            int totalMiles = Integer.parseInt(flightLegEle.getAttribute("LegDistance"));
            String departureTimestamp = flightLegEle.getAttribute("DepartureDateTime");
            String arrivalTimeStamp = flightLegEle.getAttribute("ArrivalDateTime");
            
            System.out.println(totalFlightTime + " " + totalMiles
                    + " " + departureTimestamp + " " + arrivalTimeStamp);
            
            Element err = (Element)errNodes.item(nodes);
            Element ele = (Element)err.getElementsByTagName("DepartureAirport").item(0);
            String departureAirport = ele.getAttribute("FLSLocationName");
            String departureTerminal = ele.getAttribute("Terminal");
            ele = (Element)err.getElementsByTagName("ArrivalAirport").item(0);
            String arrivalAirport = ele.getAttribute("FLSLocationName");
            String arrivalTerminal = ele.getAttribute("Terminal");
            ele = (Element)err.getElementsByTagName("MarketingAirline").item(0);
            String companyCode = ele.getAttribute("Code");
            String companyName = ele.getAttribute("CompanyShortName");
            ele = (Element)err.getElementsByTagName("Equipment").item(0);
            String flightType = ele.getAttribute("AirEquipType");
            System.out.println(departureAirport + " " + departureTerminal + " " +
                    arrivalAirport + " " + arrivalTerminal + " " + companyCode + " " + companyName
            + " " + flightType);
            
            Flight flightDetails = new Flight(totalFlightTime, totalMiles,
                    departureTimestamp, arrivalTimeStamp,
                    departureAirport, departureTerminal, arrivalAirport, 
                    arrivalTerminal, companyCode, companyName,
                    flightType, 60, departureCity, arrivalCity, 500);
            
            try {
                MySQLUtil.addFlight(MySQLUtil.connectMySQL(), flightDetails);
            } catch (Exception e) {
                System.out.println(e);
            }
            
            flightSearchList.add(flightDetails);
            
            nodes++;
        }
        
        return flightSearchList;
    }
}
