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
import javax.swing.table.DefaultTableModel;
//import model.Flight.Flight;
//import model.Flight.Flight;
import model.Person.Person;
import model.policy.Policy;
import model.bus.Bus;
import model.enterprise.Enterprise;
import model.network.Network;

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
    
//    public static void addFlight(Connection conn, Flight flight) {
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
            
        } catch (Exception e) {
        }
        
        return busSearchList;
    }
    
    public static void addpolicydetails(String PolicyName,int PolicySumAssurance,int PolicyPremium,int PolicyTenure,String PolicyDate){
         String query = "INSERT INTO insurance_policy (Policyname,SumAssurance,Premium,Tenure,Date)"
        + " values (?, ?, ?, ?, ?)";
         try {
            Connection conn = MySQLUtil.connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            
            ps.setString(1, PolicyName);
            ps.setInt(2, PolicySumAssurance);
            ps.setInt(3, PolicyPremium);
            ps.setInt(4, PolicyTenure);
            ps.setString(5, PolicyDate);
                       
            ps.execute();            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<Policy> viewpolicydetails(){
           String query = "SELECT * FROM insurance_policy";
           ArrayList<Policy> policyList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Policy policy = new Policy(rs.getInt("id"),
                        rs.getString("Policyname"),rs.getInt("Sumassurance"),
                        rs.getInt("premium"),rs.getInt("Tenure"),rs.getString("Date"));
                policyList.add(policy);
             }           
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return policyList;
    
    }
    
    public static void deletepolicy(int policyID){
          String query = "delete from insurance_policy where id = ?";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,policyID);
            ps.execute();
            conn.close();
          } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Policy searchpolicybyID(int policyID){
          String query = "SELECT * FROM insurance_policy where id = ?";
          Policy policy = null;
         try {          
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, policyID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
               policy = new Policy(rs.getInt("id"),rs.getString("Policyname"),rs.getInt("Sumassurance"),rs.getInt("premium"),rs.getInt("Tenure"),rs.getString("Date"));
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
         return policy;
    }
    
    public static void updatepolicy(String PolicyName,int PolicySumAssurance,int PolicyPremium,int PolicyTenure,String PolicyDate){
        String query = "UPDATE insurance_policy SET PolicyName=?, PolicySumAssurance=?, PolicyPremium=?, "
                + "PolicyTenure=?, PolicyDate=?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, PolicyName);
            ps.setInt(2, PolicySumAssurance);
            ps.setInt(3, PolicyPremium);
            ps.setInt(4, PolicyTenure);
            ps.setString(5, PolicyDate);            
            ps.execute();
                        
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void addenterprisedetails(String EnterpriseName , 
              String FirstName ,String LastName ,String Gender,String Role,String Email,String Password){
         String queryperson = "INSERT INTO person(firstname,lastname,gender,role,email,password)" + "Values (? ,? ,? ,? ,? ,? )";
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
            while(rs.next()) {
              personId = rs.getInt("id");
            }
            
            if(personId == 0) Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, "Person not found!");
            
            enterpriseInsert.setString(1, EnterpriseName);
            enterpriseInsert.setInt(2, personId);
            enterpriseInsert.execute();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public static ArrayList<Enterprise> viewenterprisedetails(){
           String query = "select e.adminId, e.name, p.email from enterprise e inner join person p on e.adminId = p.id";
           ArrayList<Enterprise> enterpriseList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);           
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Enterprise enterprise = new Enterprise(rs.getInt("adminId"),rs.getString("name"),rs.getString("email"));
                enterpriseList.add(enterprise);
             }           
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enterpriseList;
    
    }
        public static void deleteenterprise(int AdminID){
          String query = "delete from enterprise where adminId = ?";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,AdminID);
            ps.execute();
            conn.close();
          } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public static void updateenterprisedetail(String EnterpriseName,int AdminID){
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
        public static void addenetworkdetails(String NetworkName){
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
       public static ArrayList<Network> viewnetworkdetails(){
           String query = "select * from network";
           ArrayList<Network> networkList = new ArrayList<>();
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);           
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Network network = new Network(rs.getString("name"),rs.getInt("networkId"));
                networkList.add(network);
             }           
            
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return networkList;
    
    }
        public static void deletenetwork(int networkID){
          String query = "delete from network where networkId = ?";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,networkID);
            ps.execute();
            conn.close();
          } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public static void updatenetworkdetail(String NetworkName,int NetworkID){
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

    
}
