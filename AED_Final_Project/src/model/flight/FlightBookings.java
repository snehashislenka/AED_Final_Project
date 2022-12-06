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
public class FlightBookings {
    private static int counter = 1555;
    private int flightId;
    private String bookingId;
    private String flightName;
    private String flightSeat;
    private String flightSeatColumn;
    private int flightSeatRow;
    private String departingCity;
    private String arrivalCity;
    private double price;
    private Date departingTimeStamp;
    private Date arrivalTimeStamp;

    public FlightBookings(int flightId, String flightName, String flightSeat, 
            String flightSeatColumn, int flightSeatRow, String departingCity, 
            String arrivalCity, double price, Date departingTimeStamp, Date arrivalTimeStamp) {
        this.bookingId = "FL-" + ++counter;
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightSeatColumn = flightSeatColumn;
        this.flightSeatRow = flightSeatRow;
        this.flightSeat = "FL-" + flightSeatColumn + flightSeatRow;
        this.departingCity = departingCity;
        this.arrivalCity = arrivalCity;
        this.price = price;
        this.departingTimeStamp = departingTimeStamp;
        this.arrivalTimeStamp = arrivalTimeStamp;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightSeat() {
        return flightSeat;
    }

    public void setFlightSeat(String flightSeat) {
        this.flightSeat = flightSeat;
    }

    public String getFlightSeatColumn() {
        return flightSeatColumn;
    }

    public void setFlightSeatColumn(String flightSeatColumn) {
        this.flightSeatColumn = flightSeatColumn;
    }

    public int getFlightSeatRow() {
        return flightSeatRow;
    }

    public void setFlightSeatRow(int flightSeatRow) {
        this.flightSeatRow = flightSeatRow;
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

    public Date getDepartingTimeStamp() {
        return departingTimeStamp;
    }

    public void setDepartingTimeStamp(Date departingTimeStamp) {
        this.departingTimeStamp = departingTimeStamp;
    }

    public Date getArrivalTimeStamp() {
        return arrivalTimeStamp;
    }

    public void setArrivalTimeStamp(Date arrivalTimeStamp) {
        this.arrivalTimeStamp = arrivalTimeStamp;
    }
    
}
