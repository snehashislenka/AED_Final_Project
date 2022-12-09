package model.network;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parjita
 */
public class Network {
    private String NetworkName;
    private int NetworkID;

    public Network(String NetworkName) {
        this.NetworkName = NetworkName;
    }

    public String getNetworkName() {
        return NetworkName;
    }

    public void setNetworkName(String NetworkName) {
        this.NetworkName = NetworkName;
    }

    public int getNetworkID() {
        return NetworkID;
    }

    public void setNetworkID(int NetworkID) {
        this.NetworkID = NetworkID;
    }

    public Network(String NetworkName, int NetworkID) {
        this.NetworkName = NetworkName;
        this.NetworkID = NetworkID;
    }
    
}
