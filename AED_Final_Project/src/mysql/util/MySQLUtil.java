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
import model.Hotel.Hotel;
import model.Person.Person;
import model.Restraunt.Restraunt;

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
        String PASSWORD = "root";
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
    
    public static void getAllRestraunt(Connection conn) {
        ArrayList<Hotel> list = new ArrayList();
        
        String query = "SELECT * FROM restraunt";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("---------" + rs);
            if(rs.next()) {
                System.out.println("ID: " + rs.getString(1) + " " + rs.getString(2));
            }
            
//            for(i = 0; i < rs.length; i++){  
//                Hotel hotel;
//                hotel = new Hotel(rs[i].id, "hotel", "city", "address", "zipcode");
//
//                list.add(hotel);
//            }
                    
//            return list;
//            
//            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addRestraunt(Connection conn, Restraunt restraunt) {
        String query = "INSERT INTO restraunt (id, first_name, last_name, email, gender, password, role)"
        + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, restraunt.getId());
            ps.setString(2, restraunt.getRestraunt());
            ps.setString(3, restraunt.getCity());
            ps.setString(4, restraunt.getAddress());
            ps.setString(5, restraunt.getZipcode());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getAllHotel(Connection conn) {
        
        String query = "SELECT * FROM hotel";
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
    
    public static void addHotel(Connection conn, Hotel hotel) {
        String query = "INSERT INTO hotel (id, first_name, last_name, email, gender, password, role)"
        + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, hotel.getId());
              ps.setString(2, hotel.getHotel());
            ps.setString(3, hotel.getCity());
            ps.setString(4, hotel.getAddress());
            ps.setString(5, hotel.getZipcode());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
