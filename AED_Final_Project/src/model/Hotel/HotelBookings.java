/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Hotel;

import java.util.Date;

/**
 *
 * @author Anshul
 */
public class HotelBookings {
    public HotelBookings(){
        
    }
    
    public HotelBookings(int id, int hotelId, int room_no, int userId, Date from, Date to, int no_of_rooms, String status, String user) {
        this.id = id;
        this.hotelId = hotelId;
        this.room_no = room_no;
        this.userId = userId;
        this.from = from;
        this.to = to;
        this.no_of_rooms = no_of_rooms;
        this.status = status;
        this.user = user;
    }
    
    private int id;
    private int hotelId;
    private int room_no;
    private int userId;
    private Date from;
    private Date to;
    private int no_of_rooms;
    private String status;
    private float price;
    private int tax;
    private String user;
    private String hotel;

    public HotelBookings(String hotel, int room_no, java.sql.Date from, java.sql.Date to) {
        this.hotel = hotel;
        this.room_no = room_no;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
    
    
}
