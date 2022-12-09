/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysql.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.CarRental.CarRental;
import model.Flight.Flight;
import model.Person.Person;
import model.bus.Bus;

/**
 *
 * @author slenk
 */
public class MySQLUtil {
    public static void main(String[] args) {
        Connection conn = connectMySQL();
        getAllPerson(conn);
    }
    
    /*
        Get MySQL Connection
    */
    
    public static Connection connectMySQL() {
        Connection conn = null;
        String USER_NAME = "root";
        String PASSWORD = "1234";
        String CONNECTION_URL = "jdbc:mysql://localhost:3306/travel_management_system";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;    
    }
    
    /*
        All Person related CRUD DB operations
    */
    
    public static void getAllPerson(Connection conn) {
        
        String query = "SELECT * FROM person";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                System.out.println("ID: " + rs.getString(1) + " " + rs.getString(2));
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Get person with email id*/
    public static Person getPerson(String email) {
        String query = "SELECT * FROM person WHERE email=?";
        Person person = null;
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, email);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                person = new Person(rs.getInt("id"), 
                        rs.getString("firstname"), 
                        rs.getString("lastname"), 
                        rs.getString("gender"), rs.getString("role"),
                        rs.getString("email"), rs.getString("password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }
    
    /* Get person with person id*/
    public static Person getPerson(int id) {
        String query = "SELECT * FROM person WHERE id=?";
        Person person = null;
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                person = new Person(rs.getInt("id"), 
                        rs.getString("firstname"), 
                        rs.getString("lastname"), 
                        rs.getString("gender"), rs.getString("role"),
                        rs.getString("email"), rs.getString("password"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }
    
    public static void addPerson(Connection conn, String firstname, String lastname, String gender,
            String role, String email, String password) {
        String query = "INSERT INTO person (first_name, last_name, email, gender, password, role)"
        + " values (?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, password);
            ps.setString(6, role);
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*
        Person Session Operations
    */
    
    public static void savePersonSession(int id, String role) {
        String query = "INSERT INTO person_sesssion (id, role) VALUES (?, ?)";
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, id);
            ps.setString(2, role);
            
            ps.execute();             
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Person getPersonSession() {
        String query = "SELECT * FROM person_session";
        Person person = null;
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            int personId = 0;
            
            while(rs.next()) {
                personId = rs.getInt("id");
            }
            
            person = MySQLUtil.getPerson(personId);
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return person;
    }
    
    public static void removePersonSession() {
        String query = "DELETE FROM person_session";

        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        Flight SQL Operations
    */
    
    public static void addFlight(Connection conn, Flight flight) {
        
        String query = "INSERT INTO flight (flightId, totalFlightDuration, totalMiles, "
                + "departingTimeStamp, arrivalTimeStamp, departureAirport, departureTerminal, "
                + "arrivalAirport, arrivalTerminal, flightCompanyCode, flightCompanyName, "
                + "flightType, seats, departingCity, arrivalCity, price)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, flight.getFlightId());
            ps.setString(2, flight.getTotalFlightDuration());
            ps.setInt(3, flight.getTotalMiles());
            ps.setString(4, flight.getDepartingTimeStamp());
            ps.setString(5, flight.getArrivalTimeStamp());
            ps.setString(6, flight.getDepartureAirport());
            ps.setString(7, flight.getDepartureTerminal());
            ps.setString(8, flight.getArrivalAirport());
            ps.setString(9, flight.getArrivalTerminal());
            ps.setString(10, flight.getFlightCompanyCode());
            ps.setString(11, flight.getFlightCompanyName());
            ps.setString(12, flight.getFlightType());
            ps.setInt(13, flight.getSeats());
            ps.setString(14, flight.getDepartingCity());
            ps.setString(15, flight.getArrivalCity());
            ps.setDouble(16, flight.getPrice());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        Bus SQL Operations
    */
    
    public static void addBusDetails(String departureCity, String arrivalCity, String departureTime,
            String arrivalTime, String departureBusTerminal, String arrivalBusTerminal, String departureBusStation,
                String arrivalBusStation, String busCompanyName, int seats,
                Double price, int totalMiles, String totalDuration) {
        
        String query = "INSERT INTO bus (busTotalDuration, totalMiles, "
                + "departingTimeStamp, arrivalTimeStamp, departureBusStation, departureBusTerminal, "
                + "arrivalBusStation, arrivalBusTerminal, busCompanyName, "
                + "seats, price, departingCity, arrivalCity)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, totalDuration);
            ps.setInt(2, totalMiles);
            ps.setString(3, departureTime);
            ps.setString(4, arrivalTime);
            ps.setString(5, departureBusStation);
            ps.setString(6, departureBusTerminal);
            ps.setString(7, arrivalBusStation);
            ps.setString(8, arrivalBusTerminal);
            ps.setString(9, busCompanyName);
            ps.setInt(10, seats);
            ps.setDouble(11, price);
            ps.setString(12, departureCity);
            ps.setString(13, arrivalCity);
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        Get all bus details
    */
    
    public static ArrayList<Bus> getAllBusDetails() {
        ArrayList<Bus> busList = new ArrayList<>();
        
        String query = "SELECT * FROM bus";
        try {
            
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
                        
            while(rs.next()) {
                Bus bus = new Bus(rs.getInt("busId"), rs.getString("busTotalDuration"), 
                        rs.getInt("totalMiles"), rs.getString("departingTimestamp"),
                        rs.getString("arrivalTimestamp"), 
                        rs.getString("departureBusStation"), 
                        rs.getString("departureBusTerminal"), 
                        rs.getString("arrivalBusStation"), 
                        rs.getString("arrivalBusTerminal"), 
                        rs.getString("busCompanyName"), rs.getInt("seats"), 
                        rs.getDouble("price"), 
                        rs.getString("departingCity"), 
                rs.getString("arrivalCity"));
                busList.add(bus);
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return busList;
    }
    
    public static Bus getBusById(int busId) {
        Bus bus = null;
        String query = "SELECT * FROM bus WHERE busId = ?";
        try {
            
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, busId);
            
            ResultSet rs = ps.executeQuery();
                        
            while(rs.next()) {
                bus = new Bus(rs.getInt("busId"), rs.getString("busTotalDuration"), 
                        rs.getInt("totalMiles"), rs.getString("departingTimestamp"),
                        rs.getString("arrivalTimestamp"), 
                        rs.getString("departureBusStation"), 
                        rs.getString("departureBusTerminal"), 
                        rs.getString("arrivalBusStation"), 
                        rs.getString("arrivalBusTerminal"), 
                        rs.getString("busCompanyName"), rs.getInt("seats"), 
                        rs.getDouble("price"), 
                        rs.getString("departingCity"), 
                rs.getString("arrivalCity"));

            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bus;
    }
    
    public static void updateBusDetails(String totalDuration, int totalMiles, String departureTime,
            String arrivalTime, String departureBusStation, String departureBusTerminal,
            String arrivalBusStation, String arrivalBusTerminal, String busCompanyName, int seats,
            Double price, String departureCity, String arrivalCity, int busId) {
        
        String query = "UPDATE bus SET busTotalDuration=?, totalMiles=?, departingTimestamp=?, "
                + "arrivalTimestamp=?, departureBusStation=?, departureBusTerminal=?,"
                + "arrivalBusStation=?, arrivalBusTerminal=?, busCompanyName=?, seats=?,"
                + "price=?, departingCity=?, arrivalCity=? WHERE busId=?";
        try {
            
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, totalDuration);
            ps.setInt(2, totalMiles);
            ps.setString(3, departureTime);
            ps.setString(4, arrivalTime);
            ps.setString(5, departureBusStation);
            ps.setString(6, departureBusTerminal);
            ps.setString(7, arrivalBusStation);
            ps.setString(8, arrivalBusTerminal);
            ps.setString(9, busCompanyName);
            ps.setInt(10, seats);
            ps.setDouble(11, price);
            ps.setString(12, departureCity);
            ps.setString(13, arrivalCity);
            ps.setInt(14, busId);
            
            ps.execute();
                        
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void deleteBusDetails(int busId) {
        String query = "DELETE FROM bus WHERE busId = ?";
        try {
            
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, busId);
            
            ps.execute();
                                    
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Bus search MySQL util */
    public static ArrayList<Bus> getListOfBusSearch(String departingCity, 
            String arrivalCity) {
        ArrayList<Bus> busSearchList = new ArrayList<>();
        
        String query = "SELECT * FROM bus WHERE departingCity=? and "
                + "arrivalCity=?";
        
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, departingCity);
            ps.setString(2, arrivalCity);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Bus bus = new Bus(rs.getInt("busId"), rs.getString("busTotalDuration"), 
                        rs.getInt("totalMiles"), rs.getString("departingTimestamp"),
                        rs.getString("arrivalTimestamp"), 
                        rs.getString("departureBusStation"), 
                        rs.getString("departureBusTerminal"), 
                        rs.getString("arrivalBusStation"), 
                        rs.getString("arrivalBusTerminal"), 
                        rs.getString("busCompanyName"), rs.getInt("seats"), 
                        rs.getDouble("price"), 
                        rs.getString("departingCity"), 
                rs.getString("arrivalCity"));
                
                busSearchList.add(bus);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return busSearchList;
    }
    
    
    /*
        Car rentals MySQL utils
    */
    
    public static void addCarRentalDetails(String pickupLocation, int seats, Double ratePerHour,
            String carCompanyName, String mileage, String modelName, String fuelType, 
            String carType) {
        
        String query = "INSERT INTO car_rentals (pickupLocation, ratePerHour, mileage, fuelType,"
                + "seats, carType, carCompany, carModel) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, pickupLocation);
            ps.setDouble(2, ratePerHour);
            ps.setString(3, mileage);
            ps.setString(4, fuelType);
            ps.setInt(5, seats);
            ps.setString(6, carType);
            ps.setString(7, carCompanyName);
            ps.setString(8, modelName);
            
            ps.execute();
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static ArrayList<CarRental> getAllCarRentalDetails() {
        
        ArrayList<CarRental> carRentalsList = new ArrayList<>();
        
        String query = "SELECT * FROM car_rentals";
        
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                CarRental carRental = new CarRental(rs.getInt("rentalId"), 
                        rs.getString("pickupLocation"), rs.getDouble("ratePerHour"), 
                        rs.getString("mileage"), rs.getString("fuelType"), 
                        rs.getInt("seats"), rs.getString("carType"), 
                        rs.getString("carCompany"), rs.getString("carModel"));
                
                carRentalsList.add(carRental);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return carRentalsList;
        
    }
    
    public static void updateCarRentalDetails(int rentalId, String pickupLocation, int seats, Double ratePerHour, 
            String mileage, String fuelType, String carCompany, String modelName,
            String carType) {
        
        String query = "UPDATE car_rentals SET pickupLocation=?, ratePerHour=?, mileage=?, "
                + "fuelType=?, seats=?, carType=?,"
                + "carCompany=?, carModel=? WHERE rentalId=?";
              
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pickupLocation);
            ps.setDouble(2, ratePerHour);
            ps.setString(3, mileage);
            ps.setString(4, fuelType);
            ps.setInt(5, seats);
            ps.setString(6, carType);
            ps.setString(7, carCompany);
            ps.setString(8, modelName);
            ps.setInt(9, rentalId);
            
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        Search car rentals by location
    */
    
    public static ArrayList<CarRental> searchCarRentalsByPickupLocation(String pickupLocation) {
        
        String query = "SELECT * FROM car_rentals where pickupLocation=?";
        
        ArrayList<CarRental> carRentalList = new ArrayList<>();
        
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pickupLocation);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                CarRental carRental = new CarRental(rs.getInt("rentalId"), 
                        rs.getString("pickupLocation"), rs.getDouble("ratePerHour"), 
                        rs.getString("mileage"), rs.getString("fuelType"), 
                        rs.getInt("seats"), rs.getString("carType"), 
                        rs.getString("carCompany"), rs.getString("carModel"));
                
                carRentalList.add(carRental);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return carRentalList;
        
    }
}
