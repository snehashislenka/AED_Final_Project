/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.CarRental;

/**
 *
 * @author slenk
 */
public class CarRentalBookings {
    int bookingId;
    int rentalId;
    int personId;
    String bookingDate;
    double price;
    String bookingStatus;

    public CarRentalBookings(int bookingId, int rentalId, int personId, String bookingDate,
            double price, String bookingStatus) {
        this.bookingId = bookingId;
        this.rentalId = rentalId;
        this.personId = personId;
        this.bookingDate = bookingDate;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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
