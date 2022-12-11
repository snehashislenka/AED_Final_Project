/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

/**
 *
 * @author Anshul
 */
public class Orders {
    private int id;
    private int userId;
    private int restrauntId;
    private Float orderTotal;
    private String status;
    private String user;
    private String restraunt;
    private int flightId;
    private int hotelId;

    public Orders(int id, int userId, int restrauntId, float orderTotal, String status, String user, String restraunt) {
        this.id = id;
        this.userId = userId;
        this.restrauntId = restrauntId;
        this.orderTotal = orderTotal;
        this.status = status;
        this.user = user;
        this.restraunt = restraunt;
    }
    
    public Orders(int id, int userId, int restrauntId, float orderTotal, String status, String user, String restraunt, 
            int flightId, int hotelId) {
        this.id = id;
        this.userId = userId;
        this.restrauntId = restrauntId;
        this.orderTotal = orderTotal;
        this.status = status;
        this.user = user;
        this.restraunt = restraunt;
        this.flightId = flightId;
        this.hotelId = hotelId;
    }

    public Orders(String restraunt, int id, float orderTotal) {
            this.id = id;
       this.restraunt = restraunt;
          this.orderTotal = orderTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(int restrauntId) {
        this.restrauntId = restrauntId;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(String restraunt) {
        this.restraunt = restraunt;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
    
    
}
