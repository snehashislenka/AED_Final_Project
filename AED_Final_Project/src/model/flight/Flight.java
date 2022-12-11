/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Flight;

import java.util.Date;

/**
 *
 * @author slenk
 */
public class Flight {
//    private static int counter = 9000;
    private int flightId;
    private String totalFlightDuration;
    private int totalMiles;
    private String departingTimeStamp;
    private String arrivalTimeStamp;
    private String departureAirport;
    private String departureTerminal;
    private String arrivalAirport;
    private String arrivalTerminal;
    private String flightCompanyCode;
    private String flightCompanyName; 
    private String flightType;
    private int seats;
    private String departingCity;
    private String arrivalCity;
    private double price;

    public Flight(int flightId, String totalFlightDuration, int totalMiles,
            String departingTimeStamp, String arrivalTimeStamp, String departureAirport,
            String departureTerminal, String arrivalAirport, String arrivalTerminal,
            String flightCompanyCode, String flightCompanyName, String flightType, int seats,
            String departingCity, String arrivalCity, double price) {
        this.flightId = flightId;
        this.totalFlightDuration = totalFlightDuration;
        this.totalMiles = totalMiles;
        this.departingTimeStamp = departingTimeStamp;
        this.arrivalTimeStamp = arrivalTimeStamp;
        this.departureAirport = departureAirport;
        this.departureTerminal = departureTerminal;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTerminal = arrivalTerminal;
        this.flightCompanyCode = flightCompanyCode;
        this.flightCompanyName = flightCompanyName;
        this.flightType = flightType;
        this.seats = seats;
        this.departingCity = departingCity;
        this.arrivalCity = arrivalCity;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getTotalFlightDuration() {
        return totalFlightDuration;
    }

    public void setTotalFlightDuration(String totalFlightDuration) {
        this.totalFlightDuration = totalFlightDuration;
    }

    public int getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(int totalMiles) {
        this.totalMiles = totalMiles;
    }

    public String getDepartingTimeStamp() {
        return departingTimeStamp;
    }

    public void setDepartingTimeStamp(String departingTimeStamp) {
        this.departingTimeStamp = departingTimeStamp;
    }

    public String getArrivalTimeStamp() {
        return arrivalTimeStamp;
    }

    public void setArrivalTimeStamp(String arrivalTimeStamp) {
        this.arrivalTimeStamp = arrivalTimeStamp;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureTerminal() {
        return departureTerminal;
    }

    public void setDepartureTerminal(String departureTerminal) {
        this.departureTerminal = departureTerminal;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(String arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public String getFlightCompanyCode() {
        return flightCompanyCode;
    }

    public void setFlightCompanyCode(String flightCompanyCode) {
        this.flightCompanyCode = flightCompanyCode;
    }

    public String getFlightCompanyName() {
        return flightCompanyName;
    }

    public void setFlightCompanyName(String flightCompanyName) {
        this.flightCompanyName = flightCompanyName;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDepartingCity() {
        return departingCity;
    }

    public void setDepartingCity(String departingCity) {
        this.departingCity = departingCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    

}
