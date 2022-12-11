/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

/**
 *
 * @author Anshul
 */
public class Restraunt {
    private int id;
    private String restraunt;
    private String address;
    private String city;
    private String zipcode;
    
    public Restraunt() {
    
    }

    public Restraunt(int id, String restraunt, String address, String city, String zipcode) {
        this.id = id;
        this.restraunt = restraunt;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Restraunt(int id, String restraunt, String address) {
        this.id = id;
        this.restraunt = restraunt;
        this.address = address;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(String restraunt) {
        this.restraunt = restraunt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
}
