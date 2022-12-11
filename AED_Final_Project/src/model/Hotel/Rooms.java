/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Hotel;

/**
 *
 * @author Anshul
 */
public class Rooms {
    private int room_no;
    private int hotelId;
    private String hotel;
    private String type;
    private String desc;
    private float price;
    private String status;

    public Rooms() {
        
    }
    
    public Rooms(int room_no) {
        this.room_no = room_no;
    }

    public Rooms(int room_no, int hotelId, String hotel, String type, String desc, float price, String status) {
        this.room_no = room_no;
        this.hotelId = hotelId;
        this.hotel = hotel;
        this.type = type;
        this.desc = desc;
        this.price = price;
        this.status = status;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }
    
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}

