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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import model.Flight.Flight;
import model.Person.Person;

/**
 *
 * @author slenk
 */
public class MySQLUtil {
    public static void main(String[] args) {
        Connection conn = connectMySQL();
        getAllPerson(conn);
    }
    
    public static Connection connectMySQL() {
        Connection conn = null;
        String USER_NAME = "root";
        String PASSWORD = "ParjitaMunshi461998@";
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
    
    public static void getAllPerson(Connection conn) {
        
        String query = "SELECT * FROM person";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                System.out.println("ID: " + rs.getString(1) + " " + rs.getString(2));
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addPerson(Connection conn, Person person) {
        String query = "INSERT INTO person (id, first_name, last_name, email, gender, password, role)"
        + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, person.getId());
            ps.setString(2, person.getFirstname());
            ps.setString(3, person.getLastname());
            ps.setString(4, person.getEmail());
            ps.setString(5, person.getGender());
            ps.setString(6, person.getPassword());
            System.out.println(person.getRole().toString());
            ps.setString(7, person.getRole().toString());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
        Flight SQL Operations
    */
    
//    public static void addFlight(Connection conn, Flight flight) {
//        
//        System.out.println("addFlight sql called");
//        
//        String query = "INSERT INTO flight (flightId, totalFlightDuration, totalMiles, "
//                + "departingTimeStamp, arrivalTimeStamp, departureAirport, departureTerminal, "
//                + "arrivalAirport, arrivalTerminal, flightCompanyCode, flightCompanyName, "
//                + "flightType, seats, departingCity, arrivalCity, price)"
//        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try {
//            
//            PreparedStatement ps = conn.prepareStatement(query);
//            
//            ps.setInt(1, flight.getFlightId());
//            ps.setString(2, flight.getTotalFlightDuration());
//            ps.setInt(3, flight.getTotalMiles());
//            ps.setString(4, flight.getDepartingTimeStamp());
//            ps.setString(5, flight.getArrivalTimeStamp());
//            ps.setString(6, flight.getDepartureAirport());
//            ps.setString(7, flight.getDepartureTerminal());
//            ps.setString(8, flight.getArrivalAirport());
//            ps.setString(9, flight.getArrivalTerminal());
//            ps.setString(10, flight.getFlightCompanyCode());
//            ps.setString(11, flight.getFlightCompanyName());
//            ps.setString(12, flight.getFlightType());
//            ps.setInt(13, flight.getSeats());
//            ps.setString(14, flight.getDepartingCity());
//            ps.setString(15, flight.getArrivalCity());
//            ps.setDouble(16, flight.getPrice());
//            
//            ps.execute();
//            
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
