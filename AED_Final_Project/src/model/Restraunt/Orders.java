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

    public Orders(int id, int userId, int restrauntId, float orderTotal, String status, String user, String restraunt) {
        this.id = id;
        this.userId = userId;
        this.restrauntId = restrauntId;
        this.orderTotal = orderTotal;
        this.status = status;
        this.user = user;
        this.restraunt = restraunt;
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
    
    
}
