/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.bus;

/**
 *
 * @author slenk
 */
public class Bus {
    private int busId;
    private String busTotalDuration;
    private int totalMiles;
    private String departingTimestamp;
    private String arrivalTimestamp;
    private String departureBusStation;
    private String departureBusTerminal;
    private String arrivalBusStation;
    private String arrivalBusTerminal;
    private String busCompanyName;
    private int seats;
    private Double price;
    private String departingCity;
    private String arrivalCity;

    public Bus(int busId, String busTotalDuration, int totalMiles, String departingTimestamp, String arrivalTimestamp, String departureBusStation, String departureBusTerminal, String arrivalBusStation, String arrivalBusTerminal, String busCompanyName, int seats, Double price, String departingCity, String arrivalCity) {
        this.busId = busId;
        this.busTotalDuration = busTotalDuration;
        this.totalMiles = totalMiles;
        this.departingTimestamp = departingTimestamp;
        this.arrivalTimestamp = arrivalTimestamp;
        this.departureBusStation = departureBusStation;
        this.departureBusTerminal = departureBusTerminal;
        this.arrivalBusStation = arrivalBusStation;
        this.arrivalBusTerminal = arrivalBusTerminal;
        this.busCompanyName = busCompanyName;
        this.seats = seats;
        this.price = price;
        this.departingCity = departingCity;
        this.arrivalCity = arrivalCity;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getBusTotalDuration() {
        return busTotalDuration;
    }

    public void setBusTotalDuration(String busTotalDuration) {
        this.busTotalDuration = busTotalDuration;
    }

    public int getTotalMiles() {
        return totalMiles;
    }

    public void setTotalMiles(int totalMiles) {
        this.totalMiles = totalMiles;
    }

    public String getDepartingTimestamp() {
        return departingTimestamp;
    }

    public void setDepartingTimestamp(String departingTimestamp) {
        this.departingTimestamp = departingTimestamp;
    }

    public String getArrivalTimestamp() {
        return arrivalTimestamp;
    }

    public void setArrivalTimestamp(String arrivalTimestamp) {
        this.arrivalTimestamp = arrivalTimestamp;
    }

    public String getDepartureBusStation() {
        return departureBusStation;
    }

    public void setDepartureBusStation(String departureBusStation) {
        this.departureBusStation = departureBusStation;
    }

    public String getDepartureBusTerminal() {
        return departureBusTerminal;
    }

    public void setDepartureBusTerminal(String departureBusTerminal) {
        this.departureBusTerminal = departureBusTerminal;
    }

    public String getArrivalBusStation() {
        return arrivalBusStation;
    }

    public void setArrivalBusStation(String arrivalBusStation) {
        this.arrivalBusStation = arrivalBusStation;
    }

    public String getArrivalBusTerminal() {
        return arrivalBusTerminal;
    }

    public void setArrivalBusTerminal(String arrivalBusTerminal) {
        this.arrivalBusTerminal = arrivalBusTerminal;
    }

    public String getBusCompanyName() {
        return busCompanyName;
    }

    public void setBusCompanyName(String busCompanyName) {
        this.busCompanyName = busCompanyName;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDepartingCity() {
        return departingCity;
    }

    public void setDepartingCity(String departingCity) {
        this.departingCity = departingCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }
    
    
}
