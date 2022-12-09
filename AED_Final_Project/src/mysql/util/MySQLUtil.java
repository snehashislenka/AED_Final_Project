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
import model.Flight.Flight;
import model.Hotel.HotelBookings;
import model.Hotel.Rooms;
import model.Person.Person;
import model.Restraunt.MenuItems;
import model.Restraunt.OrderItems;
import model.Restraunt.Orders;
import model.Restraunt.Restraunt;
import model.bus.Bus;

/**
 *
 * @author slenk
 */
public class MySQLUtil {
//    public static void main(String[] args) {
//        Connection conn = connectMySQL();
//        getAllPerson();
//    }
    
    /*
        Get MySQL Connection
    */
    
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
    
    public static void getAllPerson() {
        String query = "SELECT * FROM person";
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
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
    
    public static ArrayList<Restraunt> getAllRestraunt() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Restraunt> restrauntList = new ArrayList();
        
        String query = "SELECT * FROM restraunt";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("---------" + rs);
                    
            while(rs.next()) {
                Restraunt res = new Restraunt(rs.getInt("id"), rs.getString("restraunt"),rs.getString("address"), rs.getString("city"), rs.getString("zipcode"));
                restrauntList.add(res);
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restrauntList;
    }
    
    public static void addRestraunt(Restraunt restraunt) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "INSERT INTO restraunt (restraunt, address, city, zipcode)"
        + " values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, restraunt.getRestraunt());
            ps.setString(2, restraunt.getAddress());
            ps.setString(3, restraunt.getCity());
            ps.setString(4, restraunt.getZipcode());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateRestraunt(Restraunt restraunt) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "UPDATE restraunt SET restraunt = ?, address = ?, city = ?, zipcode = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, restraunt.getRestraunt());
            ps.setString(2, restraunt.getAddress());
            ps.setString(3, restraunt.getCity());
            ps.setString(4, restraunt.getZipcode());
            ps.setInt(5, restraunt.getId());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteRestraunt(Restraunt restraunt) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "DELETE FROM restraunt WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, restraunt.getId());
            
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
    
    public static ArrayList<Hotel> getAllHotel() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Hotel> hotelList = new ArrayList();
        
        String query = "SELECT * FROM hotel";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                Hotel res = new Hotel(rs.getInt("id"), rs.getString("hotel"), 
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("zipcode"));

                hotelList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotelList;
    }
    
    public static void addHotel(Hotel hotel) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "INSERT INTO hotel (hotel, address, city, zipcode)"
        + " values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hotel.getHotel());
            ps.setString(2, hotel.getAddress());
            ps.setString(3, hotel.getCity());
            ps.setString(4, hotel.getZipcode());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateHotel(Hotel hotel) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "UPDATE hotel SET hotel = ?, address = ?, city = ?, zipcode = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, hotel.getHotel());
            ps.setString(2, hotel.getAddress());
            ps.setString(3, hotel.getCity());
            ps.setString(4, hotel.getZipcode());
            ps.setInt(5, hotel.getId());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteHotel(Hotel hotel) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "DELETE FROM hotel WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, hotel.getId());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<HotelBookings> getHotelBookings() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<HotelBookings> bookingList = new ArrayList();
        
        String query = "SELECT h.*, CONCAT(p.firstname, \" \", p.lastname) as user FROM hotel_bookings h INNER JOIN person p ON h.userId = p.id";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                HotelBookings res = new HotelBookings(rs.getInt("id"), rs.getInt("hotelId"),
                        rs.getInt("room_no"),  rs.getInt("userId"),
                 rs.getDate("from"), rs.getDate("to"), rs.getInt("no_of_rooms"),
                 rs.getString("status"), rs.getString("user"));

                bookingList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookingList;
    }
    
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
    
    public static ArrayList<Rooms> getAllRooms() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Rooms> roomList = new ArrayList();
        
        String query = "SELECT * FROM rooms";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                Rooms res = new Rooms(rs.getInt("room_no"), rs.getInt("hotelId"),
                        rs.getString("hotel"),
                        rs.getString("type"),
                        rs.getString("descr"),
                        rs.getFloat("price"),
                        rs.getString("status"));
                

                roomList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roomList;
    }
    
    public static void addRooms(Rooms rooms) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "INSERT INTO rooms"
        + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, rooms.getRoom_no());
            ps.setInt(2, rooms.getHotelId());
            ps.setString(3, rooms.getType());
            ps.setString(4, rooms.getDesc());
            ps.setFloat(5, rooms.getPrice());
            ps.setString(6, rooms.getStatus());
            ps.setString(7, rooms.getHotel());
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteRooms(int room, int hotelId) {
        String query = "DELETE FROM rooms WHERE room_no = ? and hotelId = ?";
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
            
            ps.setInt(1, room);
            ps.setInt(2, hotelId);
            
            ps1.execute();
            ps.execute();
            ps2.execute();
                                    
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void updateRooms(Rooms room) {
            Connection conn = MySQLUtil.connectMySQL();
        
        String query = "update rooms set type = ?, descr = ?, price = ?, status = ? where room_no = ? and hotelId = ?";
        try {
            System.out.println("------"+ room.getHotelId());
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, room.getType());
            ps.setString(2, room.getDesc());
            ps.setFloat(3, room.getPrice());
            ps.setString(4, room.getStatus());
            ps.setInt(5, room.getRoom_no());
            ps.setInt(6, room.getHotelId());
            
            ps.execute();
            conn.close();
                     
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Update issue", ex);
        }
        
    }
     
      public static ArrayList<MenuItems> getAllMenu() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<MenuItems> menuList = new ArrayList();
        
        String query = "SELECT * FROM menu_items";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                MenuItems res = new MenuItems(rs.getInt("id"), rs.getInt("restrauntId"),
                        rs.getString("item"),
                        rs.getFloat("price"),
                        rs.getString("descr"),
                            rs.getString("restraunt"));
                

                menuList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menuList;
    }
    
    public static void addMenu(String item,float price,String descr,int resId,String restraunt) {
        Connection conn = MySQLUtil.connectMySQL();
        
        String query = "INSERT INTO menu_items (restrauntId, item, price, descr, restraunt)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, resId);
            ps.setString(5,restraunt);
            ps.setString(2,item);
            ps.setFloat(3, price);
            ps.setString(4,descr);
            
            ps.execute();
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deleteMenu(int menuId) {
        String query = "DELETE FROM menu_items WHERE id = ?";
        try {
            Connection conn = MySQLUtil.connectMySQL();
            
            PreparedStatement ps1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");
            
            ps.setInt(1, menuId);
            
            ps1.execute();
            ps.execute();
            ps2.execute();
                                    
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void updateMenu(int id, String item, float price, String descr) {
            Connection conn = MySQLUtil.connectMySQL();
        
        String query = "update menu_items set item = ?, price = ?, descr = ? where id = ?";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, item);
            ps.setFloat(2, price);
            ps.setString(3, descr);
            ps.setInt(4, id);
            
            ps.execute();
            conn.close();
                     
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Update issue", ex);
        }
        
    }
     
    public static ArrayList<Orders> getAllOrders() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Orders> ordersList = new ArrayList();
        
        String query = "SELECT * FROM orders";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                Orders res = new Orders(rs.getInt("id"), rs.getInt("userId"),
                        rs.getInt("restrauntId"),
                        rs.getFloat("orderTotal"),
                        rs.getString("status"),
                        rs.getString("user"),
                        rs.getString("restraunt"));
                
                ordersList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordersList;
    }
    
    public static ArrayList<OrderItems> getAllOrderItems(int orderId) {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<OrderItems> orderItemList = new ArrayList();
        
        String query = "SELECT * FROM order_items where orderId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
         
            while(rs.next()) {
                OrderItems res = new OrderItems(rs.getString("item"),
                        rs.getFloat("price"),
                        rs.getInt("quantity"));
                
                orderItemList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderItemList;
    }
    
    public static void updateOrder(int id, String status) {
            Connection conn = MySQLUtil.connectMySQL();
        
        String query = "update orders set status = ? where id = ?";
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, status);
            ps.setInt(2, id);
            
            ps.execute();
            conn.close();
                     
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Update issue", ex);
        }
        
    }
     
     
}
