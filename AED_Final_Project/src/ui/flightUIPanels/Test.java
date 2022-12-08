/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.flightUIPanels;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



/**
 *
 * @author slenk
 */
public class Test {
    public static void main(String[] args) {
        String str = "PT6H38M";
        System.out.println(str.substring(0, str.length() - 1));
        StringBuilder stb = new StringBuilder(str);
//        stb.replace(0, 11, "");
        stb.replace(0, 2, "");
        System.out.println(str);
        System.out.println(stb.toString());
        
        String timestamp = "2022-12-19T05:55:00";
        System.out.println(timestamp.substring(11));
        int month = 0;
        String day = "";
        String year = "";
        stb = new StringBuilder(timestamp);
        year = stb.substring(0, 4);
        month = Integer.parseInt(stb.substring(5, 7));
        day = stb.substring(8, 10);
        
        String[] monthNames = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"};
        
        System.out.println(day + " " + monthNames[--month] + ", " + year);
        
        String flightDuration = new StringBuilder(str).substring(2);
        System.out.println(flightDuration);
    }
}
