/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.CarRental;

/**
 *
 * @author slenk
 */
public class CarRental {
    
    private int rentalId;
    private String pickupLocation;
    private Double ratePerHour;
    private String mileage;
    private String fuelType;
    private int seats;
    private String carType;
    private String carCompany;
    private String carModel;

    public CarRental(int rentalId, String pickupLocation, Double ratePerHour, String mileage, String fuelType, int seats, String carType, String carCompany, String carModel) {
        this.rentalId = rentalId;
        this.pickupLocation = pickupLocation;
        this.ratePerHour = ratePerHour;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.seats = seats;
        this.carType = carType;
        this.carCompany = carCompany;
        this.carModel = carModel;
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarCompany() {
        return carCompany;
    }

    public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    
    
}
