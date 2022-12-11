package model.Hotel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Anshul
 */
public class Hotel {
    private int id;
    private String hotel;
    private String address;
    private String city;
    private String zipcode;

    public Hotel() {
        
    }
    
    public Hotel(int id, String hotel, String address, String city, String zipcode) {
        this.id = id;
        this.hotel = hotel;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Hotel(int id, String hotel, String address) {
        this.id = id;
        this.hotel = hotel;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
//    @Override
//    public String toString() {
//        return hotel;
//    }
}

