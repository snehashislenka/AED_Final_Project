/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.city;

/**
 *
 * @author parjita
 */
public class City {
    private int CityID;
    private String CityName;
    private int NetworkID;

    public int getNetworkID() {
        return NetworkID;
    }

    public void setNetworkID(int NetworkID) {
        this.NetworkID = NetworkID;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int CityID) {
        this.CityID = CityID;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public City(int CityID, String CityName,int NetworkID) {
        this.CityID = CityID;
        this.CityName = CityName;
        this.NetworkID = NetworkID;
    }
    
    
}
