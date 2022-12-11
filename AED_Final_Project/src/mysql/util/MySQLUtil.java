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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import model.Flight.Flight;
//import model.Flight.Flight;
import model.Person.Person;
import model.policy.Policy;
import model.CarRental.CarRental;
import model.CarRental.CarRentalBookings;

import model.Hotel.Hotel;
import model.Flight.Flight;
import model.Flight.FlightBookings;
import model.Hotel.HotelBookings;
import model.Hotel.Rooms;
import model.Person.Person;
import model.Restraunt.MenuItems;
import model.Restraunt.OrderItems;
import model.Restraunt.Orders;
import model.Restraunt.Restraunt;
import model.Restraunt.TableBookings;
import model.Restraunt.Tables;
import model.booking.PolicyBooking;
import model.bus.Bus;

import model.bus.BusBookings;

import model.catgeory.Category;
import model.city.City;

import model.enterprise.Enterprise;
import model.network.Network;
import policystatus.Policystatus;

/**
 *
 * @author slenk
 */
public class MySQLUtil {
    // public static void main(String[] args) {
    // Connection conn = connectMySQL();
    // getAllPerson();
    // }

    /*
     * Get MySQL Connection
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

    public static void getAllPerson() {
        String query = "SELECT * FROM person";
        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
//                System.out.println("ID: " + rs.getString(1) + " " + rs.getString(2));
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /* Get person with email id */
    public static Person getPerson(String email) {
        String query = "SELECT * FROM person WHERE email=?";
        Person person = null;
        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

    /* Get person with person id */
    public static Person getPerson(int id) {
        String query = "SELECT * FROM person WHERE id=?";
        Person person = null;
        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

        String query = "INSERT INTO person (firstname, lastname, email, gender, password, role)"
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

    public static ArrayList<Person> getFlightAndBusAdmin() {
        String query = "select * from person where role in ('FLIGHT_ADMIN', 'BUS_ADMIN')";

        ArrayList<Person> personList = new ArrayList<>();

        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person person = new Person(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("gender"),
                        rs.getString("role"), rs.getString("email"),
                        rs.getString("password"));

                personList.add(person);
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personList;
    }
    
    public static ArrayList<Person> getCarRentalAdmin() {
        String query = "select * from person where role in ('CAR_RENTAL_ADMIN')";

        ArrayList<Person> personList = new ArrayList<>();

        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Person person = new Person(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("gender"),
                        rs.getString("role"), rs.getString("email"),
                        rs.getString("password"));

                personList.add(person);
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personList;
    }

    public static ArrayList<Restraunt> getAllRestraunt() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Restraunt> restrauntList = new ArrayList();

        String query = "SELECT * FROM restraunt";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Restraunt res = new Restraunt(rs.getInt("id"), rs.getString("restraunt"), rs.getString("address"),
                        rs.getString("city"), rs.getString("zipcode"));
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
     * Person Session Operations
     */

    public static void savePersonSession(int id, String role) {
        String query = "INSERT INTO person_session (id, role) VALUES (?, ?)";
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

            while (rs.next()) {
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
     * Flight SQL Operations
     */

    public static void addFlight(Connection conn, String totalFlightDuration, int totalMiles, 
            String departingTimestamp, String arrivalTimestamp, String departureAirport, String departureTerminal, 
                String arrivalAirport, String arrivalTerminal, String flightCompanyCode, String flightCompanyName, 
                String flightType, int seats, String departingCity, String arrivalCity, Double price) {

        String query = "INSERT INTO flight ( totalFlightDuration, totalMiles, "
                + "departingTimeStamp, arrivalTimeStamp, departureAirport, departureTerminal, "
                + "arrivalAirport, arrivalTerminal, flightCompanyCode, flightCompanyName, "
                + "flightType, seats, departingCity, arrivalCity, price)"

                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = conn.prepareStatement(query);

            
            ps.setString(1, totalFlightDuration);
            ps.setInt(2, totalMiles);
            ps.setString(3, departingTimestamp);
            ps.setString(4, arrivalTimestamp);
            ps.setString(5, departureAirport);
            ps.setString(6, departureTerminal);
            ps.setString(7, arrivalAirport);
            ps.setString(8, arrivalTerminal);
            ps.setString(9, flightCompanyCode);
            ps.setString(10, flightCompanyName);
            ps.setString(11, flightType);
            ps.setInt(12, seats);
            ps.setString(13, departingCity);
            ps.setString(14, arrivalCity);
            ps.setDouble(15, price);

            ps.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     * Book Flight
     */

    public static void addFlightBooking(int flightId, int personId, String seats,
            Double price, String bookingStatus) {

        String query = "INSERT INTO flight_bookings (flightId, personId, flightSeat, price, booking_status)"
                + " VALUES(?, ?, ?, ?, ?)";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, flightId);
            ps.setInt(2, personId);
            ps.setString(3, seats);
            ps.setDouble(4, price);
            ps.setString(5, bookingStatus);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Not able to"
                    + "insert into flight bookings table!", ex);
        }

    }
    
    public static ArrayList<FlightBookings> getAllFlightBookings() {

        ArrayList<FlightBookings> flightBookingsList = new ArrayList<>();

        String query = "SELECT * FROM flight_bookings";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FlightBookings flightBooking = new FlightBookings(rs.getInt("flightId"),
                        rs.getInt("bookingId"), rs.getInt("personId"),
                        rs.getString("flightSeat"),
                        rs.getDouble("price"), rs.getString("booking_status"));

                flightBookingsList.add(flightBooking);

            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Not able to"
                    + "insert into flight bookings table!", ex);
        }

        return flightBookingsList;
    }

    public static void updateFlightBookingStatus(int bookingId, String status) {
        String query = "UPDATE flight_bookings SET booking_status=? where bookingId = ?";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, bookingId);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Not able to"
                    + "update the flight booking status table!", ex);
        }

    }
    
    public static void updateFlightBookingInsuranceStatus(int policyId, String insuranceStatus, int personId) {
        String query = "UPDATE flight_bookings SET policyId=?, insuranceStatus=? where personId = ?";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, policyId);
            ps.setString(2, insuranceStatus);
            ps.setInt(3, personId);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Not able to"
                    + "update the flight booking status table!", ex);
        }

    }
    
    public static void updateCarBookingInsuranceStatus(int policyId, String insuranceStatus, int personId) {
        String query = "UPDATE car_rentals_bookings SET policyId=?, insuranceStatus=? where personId = ?";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, policyId);
            ps.setString(2, insuranceStatus);
            ps.setInt(3, personId);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Not able to"
                    + "update the car rentals booking status table!", ex);
        }

    }
    
    
    
    public static ArrayList<Flight> getAllActiveFlights() {
        String query = "select * from flight_bookings fb inner join flight f on f.flightId = fb.flightId "
                + "where fb.booking_status <> 'CANCELLED'";

        ArrayList<Flight> flightList = new ArrayList<>();

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flightId"),
                        rs.getString("totalFlightDuration"),
                        rs.getInt("totalMiles"),
                        rs.getString("departingTimeStamp"),
                        rs.getString("arrivalTimeStamp"),
                        rs.getString("departureAirport"),
                        rs.getString("departureTerminal"),
                        rs.getString("arrivalAirport"),
                        rs.getString("arrivalTerminal"),
                        rs.getString("flightCompanyCode"),
                        rs.getString("flightCompanyName"),
                        rs.getString("flightType"),
                        rs.getInt("seats"), rs.getString("departingCity"),
                        rs.getString("arrivalCity"), rs.getDouble("price"));

                flightList.add(flight);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with "
                    + "get all active flights query!", ex);
        }

        return flightList;
    }

    public static ArrayList<Flight> getAllCanceledFlights() {
        String query = "select * from flight_bookings fb inner join flight f on f.flightId = fb.flightId "
                + "where fb.booking_status = 'CANCELLED'";

        ArrayList<Flight> flightList = new ArrayList<>();

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flightId"),
                        rs.getString("totalFlightDuration"),
                        rs.getInt("totalMiles"),
                        rs.getString("departingTimeStamp"),
                        rs.getString("arrivalTimeStamp"),
                        rs.getString("departureAirport"),
                        rs.getString("departureTerminal"),
                        rs.getString("arrivalAirport"),
                        rs.getString("arrivalTerminal"),
                        rs.getString("flightCompanyCode"),
                        rs.getString("flightCompanyName"),
                        rs.getString("flightType"),
                        rs.getInt("seats"), rs.getString("departingCity"),
                        rs.getString("arrivalCity"), rs.getDouble("price"));

                flightList.add(flight);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with "
                    + "get all active flights query!", ex);
        }

        return flightList;
    }
    
    
    public static ArrayList<Flight> getAllFlightData() {
        String query = "select * from flight";

        ArrayList<Flight> flightList = new ArrayList<>();

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Flight flight = new Flight(rs.getInt("flightId"), rs.getString("totalFlightDuration"),
                        rs.getInt("totalMiles"),
                        rs.getString("departingTimeStamp"),
                        rs.getString("arrivalTimeStamp"),
                        rs.getString("departureAirport"),
                        rs.getString("departureTerminal"),
                        rs.getString("arrivalAirport"),
                        rs.getString("arrivalTerminal"),
                        rs.getString("flightCompanyCode"),
                        rs.getString("flightCompanyName"),
                        rs.getString("flightType"),
                        rs.getInt("seats"), rs.getString("departingCity"),
                        rs.getString("arrivalCity"), rs.getDouble("price"));

                flightList.add(flight);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with "
                    + "get all active flights query!", ex);
        }

        return flightList;
    }
    
    public static ArrayList<Flight> getAllFlightDataByDate(String departureDate) {    
        
        ArrayList<Flight> flightList = MySQLUtil.getAllFlightData();
        
        ArrayList<Flight> flightSearchList = new ArrayList<>();
        
        String[] mmArr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            int mm = 0;
            System.out.println(departureDate.substring(4, 7));
            for(int i=0; i<mmArr.length; i++) {
                if(mmArr[i].equals(departureDate.substring(4, 7))) {
                    mm = ++i;
                }
            }
            
            String dd = departureDate.substring(8, 10);
            String yyyy = departureDate.substring(24, 28);
//            System.out.println(yyyy+"-"+mm+"-"+dd);
        
        String formattedDate = yyyy+"-"+mm+"-"+dd;
        
        
        
        for(Flight flight: flightList) {
            if(flight.getDepartingTimeStamp().substring(0, 10)
                    .equals(formattedDate)) {
                flightSearchList.add(flight);
            }
        }

//        try {
//            Connection conn = connectMySQL();
//
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, departureDate);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Flight flight = new Flight(rs.getInt("flightId"), rs.getString("totalFlightDuration"),
//                        rs.getInt("totalMiles"),
//                        rs.getString("departingTimeStamp"),
//                        rs.getString("arrivalTimeStamp"),
//                        rs.getString("departureAirport"),
//                        rs.getString("departureTerminal"),
//                        rs.getString("arrivalAirport"),
//                        rs.getString("arrivalTerminal"),
//                        rs.getString("flightCompanyCode"),
//                        rs.getString("flightCompanyName"),
//                        rs.getString("flightType"),
//                        rs.getInt("seats"), rs.getString("departingCity"),
//                        rs.getString("arrivalCity"), rs.getDouble("price"));
//
//                flightList.add(flight);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with "
//                    + "get all active flights query!", ex);
//        }

        return flightSearchList;
    }

    public static ArrayList<Hotel> getAllHotel() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Hotel> hotelList = new ArrayList();

        String query = "SELECT * FROM hotel";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

            while (rs.next()) {
                HotelBookings res = new HotelBookings(rs.getInt("id"), rs.getInt("hotelId"),
                        rs.getInt("room_no"), rs.getInt("userId"),
                        rs.getDate("fromDate"), rs.getDate("toDate"), rs.getInt("no_of_rooms"),
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

            while (rs.next()) {
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

    public static ArrayList<BusBookings> getAllBusBookings() {
        ArrayList<BusBookings> busBookingsList = new ArrayList<>();

        String query = "SELECT * FROM bus_bookings";
        try {

            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BusBookings busBooking = new BusBookings(rs.getInt("bookingId"),
                        rs.getInt("busId"),
                        rs.getInt("personId"),
                        rs.getString("bookingDate"),
                        rs.getDouble("price"),
                        rs.getString("seat"),
                        rs.getString("booking_status"));
                busBookingsList.add(busBooking);
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return busBookingsList;
    }

    public static void updateBusBookingStatus(int bookingId, String status) {
        String query = "UPDATE bus_bookings SET booking_status = ? "
                + "WHERE bookingId = ?";
        try {

            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, bookingId);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with updating"
                    + " bus booking!", ex);
        }
    }

    public static Bus getBusById(int busId) {
        Bus bus = null;
        String query = "SELECT * FROM bus WHERE busId = ?";
        try {

            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, busId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

            while (rs.next()) {
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

    public static void addBusBooking(int busId, int personId, String bookingDate,
            String seats, double price, String bookingStatus, int remainingSeats) {

        String query = "INSERT INTO bus_bookings (busId, personId, bookingDate, price, seat, booking_status)"
                + " VALUES(?, ?, ?, ?, ?, ?)";

        String updateBusSeatsQuery = "UPDATE bus "
                + "SET seats=? where busId=?";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, busId);
            ps.setInt(2, personId);
            ps.setString(3, bookingDate);
            ps.setDouble(4, price);
            ps.setString(5, seats);
            ps.setString(6, bookingStatus);

            ps.execute();

            PreparedStatement ps2 = conn.prepareStatement(updateBusSeatsQuery);
            ps2.setInt(1, remainingSeats);
            ps2.setInt(2, busId);

            ps2.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Insertion error!", ex);
        }
    }

    /*
     * Car rentals MySQL utils
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

    public static ArrayList<Rooms> getAllRooms() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Rooms> roomList = new ArrayList();

        String query = "SELECT * FROM rooms";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

    public static ArrayList<CarRental> getAllCarRentalDetails() {

        ArrayList<CarRental> carRentalsList = new ArrayList<>();

        String query = "SELECT * FROM car_rentals";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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
     * Search car rentals by location
     */

    public static ArrayList<CarRental> searchCarRentalsByPickupLocation(String pickupLocation) {

        String query = "SELECT * FROM car_rentals where pickupLocation=?";

        ArrayList<CarRental> carRentalList = new ArrayList<>();

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, pickupLocation);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
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

    public static void addCarRentalBooking(int rentalId, int personId,
            String bookingDate, Double price, String bookingStatus) {

        String query = "INSERT INTO car_rentals_bookings (rentalId, personId, "
                + "bookingDate, price, bookingStatus) values(?,?,?,?,?)";

        try {

            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, rentalId);
            ps.setInt(2, personId);
            ps.setString(3, bookingDate);
            ps.setDouble(4, price);
            ps.setString(5, bookingStatus);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ArrayList<CarRentalBookings> getCarRentalBookings() {
        String query = "SELECT * FROM car_rentals_bookings";

        ArrayList<CarRentalBookings> carRentalBookings = new ArrayList<>();

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CarRentalBookings carRentalBooking = new CarRentalBookings(rs.getInt("bookingId"),
                        rs.getInt("rentalId"),
                        rs.getInt("personId"), rs.getString("bookingDate"), rs.getDouble("price"),
                        rs.getString("bookingStatus"));

                carRentalBookings.add(carRentalBooking);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return carRentalBookings;
    }

    public static void updateCarBookingStatus(int bookingId, String bookingStatus) {
        String query = "UPDATE car_rentals_bookings SET bookingStatus=? "
                + "where bookingId=?";

        try {
            Connection conn = connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, bookingStatus);
            ps.setInt(2, bookingId);

            ps.execute();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public static void addpolicydetails(String PolicyName,int PolicySumAssurance,int PolicyPremium,int PolicyTenure,String PolicyDate){
//         String query = "INSERT INTO insurance_policy (Policyname,SumAssurance,Premium,Tenure,Date)"
//        + " values (?, ?, ?, ?, ?)";
//         try {

    // policy crud operations
    public static void addpolicydetails(String PolicyName, String CategoryName, int PolicySumAssurance,
            int PolicyPremium, int PolicyTenure, String PolicyDate) {
        String query = "INSERT INTO insurance_policy (Policyname,categoryname,SumAssurance,Premium,Tenure,Date)"
                + " values (?, ?, ?, ?, ?, ?)";
        try {

            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, PolicyName);
            ps.setString(2, CategoryName);
            ps.setInt(3, PolicySumAssurance);
            ps.setInt(4, PolicyPremium);
            ps.setInt(5, PolicyTenure);
            ps.setString(6, PolicyDate);

            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateRooms(Rooms room) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "update rooms set type = ?, descr = ?, price = ?, status = ? where room_no = ? and hotelId = ?";
        try {
            System.out.println("------" + room.getHotelId());

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

            while (rs.next()) {
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

    public static void addMenu(String item, float price, String descr, int resId, String restraunt) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO menu_items (restrauntId, item, price, descr, restraunt)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, resId);
            ps.setString(5, restraunt);
            ps.setString(2, item);
            ps.setFloat(3, price);
            ps.setString(4, descr);

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

            while (rs.next()) {
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

            while (rs.next()) {
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

    public static ArrayList<Tables> getAllTables() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<Tables> tableList = new ArrayList();

        String query = "SELECT * FROM tables";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tables res = new Tables(rs.getInt("table_no"), rs.getString("status"),
                        rs.getInt("restrauntId"),
                        rs.getString("restraunt"));

                tableList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableList;
    }

    public static void addTables(int table, String status, int resId, String restraunt) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO tables (table_no, status, restrauntId, restraunt)"
                + " values (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, table);
            ps.setString(2, status);
            ps.setInt(3, resId);
            ps.setString(4, restraunt);

            ps.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteTables(int table, int resId) {
        String query = "DELETE FROM tables WHERE table_no = ? and restrauntId = ?";
        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");

            ps.setInt(1, table);
            ps.setInt(2, resId);

            ps1.execute();
            ps.execute();
            ps2.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Policy> viewpolicydetails() {
        String query = "SELECT * FROM insurance_policy";
        ArrayList<Policy> policyList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Policy policy = new Policy(rs.getInt("id"), rs.getString("Policyname"), rs.getString("categoryname"),
                        rs.getInt("Sumassurance"), rs.getInt("premium"), rs.getInt("Tenure"), rs.getString("Date"));
                policyList.add(policy);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return policyList;

    }

    public static void deletepolicy(int policyID) {
        String query = "delete from insurance_policy where id = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, policyID);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatepolicydetail(String PolicyName, int PolicySumAssurance, int PolicyPremium,
            int PolicyTenure, String PolicyDate, int PolicyId) {
        String query = "UPDATE insurance_policy SET PolicyName=?, Sumassurance=?, Premium=?,Tenure=?, Date=? where id=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, PolicyName);
            ps.setInt(2, PolicySumAssurance);
            ps.setInt(3, PolicyPremium);
            ps.setInt(4, PolicyTenure);
            ps.setString(5, PolicyDate);
            ps.setInt(6, PolicyId);
            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Policy getPolicyById(int policyId) {
        Policy policy = null;
        String query = "SELECT * FROM insurance_policy WHERE id = ?";
        try {

            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, policyId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                policy = new Policy(rs.getInt("id"),
                        rs.getString("Policyname"),
                        rs.getString("categoryname"),
                        rs.getInt("Sumassurance"),
                        rs.getInt("Premium"),
                        rs.getInt("Tenure"),
                        rs.getString("Date"));

            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return policy;
    }

    public static ArrayList<Category> getallcategory() {
        String query = "select * from insurance_category";
        ArrayList<Category> CategoryList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("categoryname"),
                        rs.getString("categorydate"));
                CategoryList.add(category);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CategoryList;
    }

    // category crud operations
    public static void addcategorydetails(String CategoryName, String CategoryDate) {
        String queryperson = "INSERT INTO insurance_category(categoryname,categorydate)" + "Values (?,?)";

        try {
            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement ps = conn.prepareStatement(queryperson);

            ps.setString(1, CategoryName);
            ps.setString(2, CategoryDate);
            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateTables(int table, String status, int resId) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "update tables set status = ? where restrauntId = ? and table_no = ?";
        try {

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, status);
            ps.setInt(2, resId);
            ps.setInt(3, table);

            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Update issue", ex);
        }
    }

    public static ArrayList<TableBookings> getAllTableBookings() {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<TableBookings> tableBookingList = new ArrayList();

        String query = "SELECT * FROM table_bookings";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TableBookings res = new TableBookings(rs.getInt("id"), rs.getInt("restrauntId"),
                        rs.getInt("table_no"),
                        rs.getString("restraunt"),
                        rs.getString("status"),
                        rs.getDate("fromDate"));

                tableBookingList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableBookingList;
    }

    public static void updateTableBooking(int id, String status) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "update table_bookings set status = ? where id = ?";
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

    public static void addTableBookings(int table, String status, String dates, int resId, String restraunt) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO table_bookings (table_no, status, fromDate, restrauntId, restraunt)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, table);
            ps.setString(2, status);
            ps.setString(3, dates);
            ps.setInt(4, resId);
            ps.setString(5, restraunt);

            ps.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Category> viewcategorydetails() {
        String query = "select * from insurance_category";
        ArrayList<Category> categoryList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Category category = new Category(rs.getInt("id"), rs.getString("categoryname"),
                        rs.getString("categorydate"));
                categoryList.add(category);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoryList;

    }

    public static void deletecatgeory(int categoryID) {
        String query = "delete from insurance_category where id = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, categoryID);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatecategorydetail(String categoryName, int categoryID) {
        String query = "UPDATE insurance_category SET categoryname=? WHERE id=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, categoryName);
            ps.setInt(2, categoryID);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // enyterprise crud operations

    public static void addenterprisedetails(String EnterpriseName,
            String FirstName, String LastName, String Gender, String Role, String Email, String Password) {
        String queryperson = "INSERT INTO person(firstname,lastname,gender,role,email,password)"
                + "Values (? ,? ,? ,? ,? ,? )";
        String querypersonid = "select id from person order by id desc limit 1";
        String query = "INSERT INTO enterprise (name, adminId)" + " values (?, ?)";

        try {
            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement personInsert = conn.prepareStatement(queryperson);
            PreparedStatement fetchPersonId = conn.prepareStatement(querypersonid);
            PreparedStatement enterpriseInsert = conn.prepareStatement(query);

            personInsert.setString(1, FirstName);
            personInsert.setString(2, LastName);
            personInsert.setString(3, Gender);
            personInsert.setString(4, Role);
            personInsert.setString(5, Email);
            personInsert.setString(6, Password);
            personInsert.execute();

            ResultSet rs = fetchPersonId.executeQuery();
            int personId = 0;
            while (rs.next()) {
                personId = rs.getInt("id");
            }

            if (personId == 0)
                Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, "Person not found!");

            enterpriseInsert.setString(1, EnterpriseName);
            enterpriseInsert.setInt(2, personId);
            enterpriseInsert.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteTableBookings(int id) {
        String query = "DELETE FROM table_bookings WHERE id = ?";
        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement ps1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0");
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 1");

            ps.setInt(1, id);

            ps1.execute();
            ps.execute();
            ps2.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<HotelBookings> getAllUserBookings(int userId) {
        Connection conn = MySQLUtil.connectMySQL();
        ArrayList<HotelBookings> userBookingList = new ArrayList();

        String query = "SELECT h.hotel, hb.room_no, hb.from, hb.to FROM hotel_bookings as hb inner join hotel h on h.id = hb.hotelId where userId = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HotelBookings res = new HotelBookings(rs.getString("hotel"), rs.getInt("room_no"),
                        rs.getDate("from"), rs.getDate("to"));

                userBookingList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userBookingList;
    }

    public static void bookHotel(int hotelId, int room_no, int userId, Date from,
            Date to, int no_of_rooms, String status) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO hotel_bookings (hotelId, room_no, userId, fromDate, toDate, no_of_rooms, status)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            java.sql.Date fromDate = new java.sql.Date(from.getTime());
            java.sql.Date toDate = new java.sql.Date(to.getTime());
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, hotelId);
            ps.setInt(2, room_no);
            ps.setInt(3, userId);
            ps.setDate(4, fromDate);
            ps.setDate(5, toDate);
            ps.setInt(6, no_of_rooms);
            ps.setString(7, status);

            ps.execute();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createOrder(int userId, int restrauntId, float orderTotal, String status, String user,
            String restraunt, int tax) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO orders (userId, restrauntId, orderTotal, "
                + "status, user, restraunt, tax)"
                + " values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, restrauntId);
            ps.setFloat(3, orderTotal);
            ps.setString(4, status);
            ps.setString(5, user);
            ps.setString(6, restraunt);
            ps.setInt(7, tax);

            ps.execute();
            System.out.println("order created here");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createOrderItem(int orderId, int itemId, String item, float total,
            int quantity) {
        Connection conn = MySQLUtil.connectMySQL();

        String query = "INSERT INTO order_items (orderId, itemId, item, total, quantity)"
                + " values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderId);
            ps.setInt(2, itemId);
            ps.setString(3, item);
            ps.setFloat(4, total);
            ps.setInt(5, quantity);

            ps.execute();

            System.out.println("order items created --");
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Enterprise> viewenterprisedetails() {
        String query = "select e.adminId, e.name, p.email from enterprise e inner join person p on e.adminId = p.id";
        ArrayList<Enterprise> enterpriseList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Enterprise enterprise = new Enterprise(rs.getInt("adminId"), rs.getString("name"),
                        rs.getString("email"));
                enterpriseList.add(enterprise);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enterpriseList;

    }

    public static void deleteenterprise(int AdminID) {
        String query = "delete from enterprise where adminId = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, AdminID);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updateenterprisedetail(String EnterpriseName, int AdminID) {
        String query = "UPDATE enterprise SET name=? WHERE adminId=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, EnterpriseName);
            ps.setInt(2, AdminID);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // network crud operations
    public static void addenetworkdetails(String NetworkName) {
        String queryperson = "INSERT INTO network(name)" + "Values (?)";

        try {
            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement ps = conn.prepareStatement(queryperson);

            ps.setString(1, NetworkName);
            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Network> viewnetworkdetails() {
        String query = "select * from network";
        ArrayList<Network> networkList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Network network = new Network(rs.getString("name"), rs.getInt("networkId"));
                networkList.add(network);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return networkList;

    }

    public static void deletenetwork(int networkID) {
        String query = "delete from network where networkId = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, networkID);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatenetworkdetail(String NetworkName, int NetworkID) {
        String query = "UPDATE network SET name=? WHERE networkId=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, NetworkName);
            ps.setInt(2, NetworkID);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<Network> getallNetwork() {
        String query = "select * from Network";
        ArrayList<Network> NetworkList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Network network = new Network(rs.getString("name"), rs.getInt("networkId"));
                NetworkList.add(network);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NetworkList;
    }

    // city crud operations

    public static void addecitydetails(String CityName, int networkId) {
        String queryperson = "INSERT INTO city(name,networkId)" + "Values (?,?)";

        try {
            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement ps = conn.prepareStatement(queryperson);

            ps.setString(1, CityName);
            ps.setInt(2, networkId);
            ps.execute();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<City> viewcitydetails() {
        String query = "select * from city";
        ArrayList<City> cityList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                City city = new City(rs.getInt("cityId"), rs.getString("name"), rs.getInt("networkId"));
                cityList.add(city);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cityList;

    }

    public static void deletecity(int cityID) {
        String query = "delete from city where cityId = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, cityID);
            ps.execute();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void updatecitydetail(String cityName, int cityID) {
        String query = "UPDATE city SET name=? WHERE cityId=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, cityName);
            ps.setInt(2, cityID);

            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // policybooking crud
    public static void addpolicybookingdetails(int policyId, int personId, String AppliedDate, String Status) {

        String querybooking = "insert into insurance_policybooking("
                + "policyid, personid, applieddate,status)" + "values(?, ?, ?,?) ";

        try {
            Connection conn = MySQLUtil.connectMySQL();

            PreparedStatement importbooking = conn.prepareStatement(querybooking);

            importbooking.setInt(1, policyId);
            importbooking.setInt(2, personId);
            importbooking.setString(3, AppliedDate);
            importbooking.setString(4, Status);
            importbooking.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<PolicyBooking> viewpolicybookingdetails() {
        String query = "select * from insurance_policy p"
                + " inner join insurance_policybooking b on p.id = b.policyid";
        ArrayList<PolicyBooking> BookingList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PolicyBooking booking = new PolicyBooking(rs.getInt("bookingid"), rs.getInt("policyid"),
                        rs.getInt("personid"), rs.getString("Policyname"), rs.getString("applieddate"),
                        rs.getString("status"));
                BookingList.add(booking);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return BookingList;

    }

    public static ArrayList<Policystatus> viewpolicystatusdetails() {
        String query = "select * from (select * from insurance_policy p inner join " +
                "insurance_policybooking b on p.id = b.policyid) a inner join person" +
                " on person.id = a.personid";
        ArrayList<Policystatus> PolicystatusList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Policystatus status = new Policystatus(rs.getInt("personid"),
                        rs.getString("firstname"), rs.getInt("policyid"),
                        rs.getString("Policyname"), rs.getString("categoryname"),
                        rs.getInt("Sumassurance"), rs.getInt("Premium"), rs.getInt("Tenure"),
                        rs.getString("applieddate"), rs.getString("status"));
                PolicystatusList.add(status);
            }

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PolicystatusList;

    }

    public static void updatepolicybookingdetail(String Status, int personId) {
        String query = "UPDATE insurance_policybooking SET status=? WHERE personid=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, Status);
            ps.setInt(2, personId);
            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void rejectpolicybookingdetail(String Status, int personId) {
        String query = "UPDATE insurance_policybooking SET status=? WHERE personid=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, Status);
            ps.setInt(2, personId);
            ps.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
