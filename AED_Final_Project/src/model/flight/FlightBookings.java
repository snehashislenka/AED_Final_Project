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
    private int flightId;
    private int bookingId;
    private int personId;
    private String flightSeat;
    private double price;
    private String bookingStatus;

    public FlightBookings(int flightId, int bookingId, int personId, String flightSeat, 
            double price, String bookingStatus) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.personId = personId;
        this.flightSeat = flightSeat;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightSeat() {
        return flightSeat;
    }

    public void setFlightSeat(String flightSeat) {
        this.flightSeat = flightSeat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    
    
    
}
