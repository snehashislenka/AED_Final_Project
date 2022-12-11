/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.RestrauntUser;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Restraunt.MenuItems;
import model.Restraunt.OrderItems;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;
import ui.Hotel.HotelFrame;
import ui.Hotel.OrderHotelFood;
import ui.flightAdminDashboard.FlightAdminDashboard;
import ui.flightAdminDashboard.OrderFlightFood;

/**
 *
 * @author Anshul
 */
public class Checkout extends javax.swing.JPanel {

    /**
     * Creates new form Checkout
     */
    RestrauntFrame restrauntFrame;
    FlightAdminDashboard flightAdminDashboard;
    HotelFrame hotelFrame;
    String city;
    String restraunt; 
    String address;
    String zipcode;
    int restrauntId;
    float totalPrice = 0;
    float totalQuantity = 0;
    int tax = 20;
    float totalPay = 0;
    int extraId;
    String extraType;
    ArrayList<OrderItems> cartItems;
    
    public Checkout(RestrauntFrame restrauntFrame, String city, String restraunt, 
            String address, String zipcode, int restrauntId, ArrayList<OrderItems> cartItems) {
        initComponents();
        this.restrauntFrame = restrauntFrame;
         this.city = city;
        this.restraunt =restraunt;
        this.address = address;
        this.zipcode =zipcode;
        this.restrauntId =restrauntId;
        this.cartItems = cartItems;
        
        sCity.setText(city);
        sAddress.setText(address);
        sRestraunt.setText(restraunt);
//        sZipcode.setText(zipcode);

        populateTable();
    }
    
      public Checkout(FlightAdminDashboard flightAdminDashboard, String city, String restraunt, 
            String address, String zipcode, int restrauntId, ArrayList<OrderItems> cartItems, int extraId, String extraType) {
        initComponents();
        this.flightAdminDashboard = flightAdminDashboard;
         this.city = city;
        this.restraunt =restraunt;
        this.address = address;
        this.zipcode =zipcode;
        this.restrauntId =restrauntId;
        this.cartItems = cartItems;
        this.extraId = extraId;
        this.extraType = extraType;
        this.jButton2.setVisible(false);
        
        sCity.setText(city);
        sAddress.setText(address);
        sRestraunt.setText(restraunt);
//        sZipcode.setText(zipcode);

        populateTable();
    }
      
      public Checkout(HotelFrame hotelFrame, String city, String restraunt, 
            String address, String zipcode, int restrauntId, ArrayList<OrderItems> cartItems, int extraId, String extraType) {
        initComponents();
        this.hotelFrame = hotelFrame;
         this.city = city;
        this.restraunt =restraunt;
        this.address = address;
        this.zipcode =zipcode;
        this.restrauntId =restrauntId;
        this.cartItems = cartItems;
        this.extraId = extraId;
        this.extraType = extraType;
        this.jButton2.setVisible(false);
        
        sCity.setText(city);
        sAddress.setText(address);
        sRestraunt.setText(restraunt);
//        sZipcode.setText(zipcode);

        populateTable();
    }
     
    public Checkout(RestrauntFrame restrauntFrame) {
        initComponents();
        this.restrauntFrame = restrauntFrame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sRestraunt = new javax.swing.JLabel();
        sCity = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        sAddress = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        sPay = new javax.swing.JLabel();
        sQuantity = new javax.swing.JLabel();
        sTotal = new javax.swing.JLabel();
        sTax = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {

                ImageIcon im = new ImageIcon("D:\\My NEU Assignments\\AED Final Project\\git\\AED_Final_Project\\AED_Final_Project\\src\\assets\\dashboard-bg.jpg");

                Image i = im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width,
                    this.getSize().height, this);
            }
        };
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHECKOUT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 50));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("←");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("RESTRAUNT INFO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Restraunt Photo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, 100));

        sRestraunt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sRestraunt.setText("Restraunt Name");
        jPanel2.add(sRestraunt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 190, -1));

        sCity.setText("restraunt address");
        jPanel2.add(sCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 190, 30));

        jLabel6.setBackground(new java.awt.Color(153, 204, 255));
        jLabel6.setForeground(new java.awt.Color(255, 204, 204));
        jLabel6.setText("Restraunt Rating: 4/5");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, 10));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ITEM ID", "ITEM", "PRICE", "QUANTITY"
            }
        ));
        jTable1.setToolTipText("");
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 330, 340));

        sAddress.setText("restraunt address");
        jPanel2.add(sAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, 30));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 510));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("PRICE SUMMARY");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 20));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 200, 10));

        jLabel8.setText("Tax");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel9.setText("Total Quantity");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Total Payable");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, 10));

        jLabel13.setText("Price");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        sPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sPay.setText("2000");
        jPanel3.add(sPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, -1, -1));

        sQuantity.setText("8");
        jPanel3.add(sQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        sTotal.setText("1600");
        jPanel3.add(sTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        sTax.setText("20");
        jPanel3.add(sTax, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 220, 200));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 220, 250));

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("ORDER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 220, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.restrauntFrame.switchPanel(new RestrauntSearch(this.restrauntFrame));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        order here
        int userId = 1;
        String username = "";
        String status = "ORDERED";
        int orderId = 0;
        
        String query = "select CONCAT(firstname, \" \", lastname) as user from person where id = ?";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            ps.setInt(1, userId);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                username = rs.getString("user");
            }
         } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(extraId > 0) {
            int flightId = 0;
            int hotelId = 0;
            if(extraType.equals("flight")) flightId = extraId;
            if(extraType.equals("hotel")) hotelId = extraId;
            if(flightId > 0) {
                MySQLUtil.createFlightOrder(userId, restrauntId, totalPay, status, username, restraunt, tax, flightId); 
            } else {
                MySQLUtil.createHotelOrder(userId, restrauntId, totalPay, status, username, restraunt, tax, hotelId); 
            }
        } else {
            MySQLUtil.createOrder(userId, restrauntId, totalPay, status, username, restraunt, tax);         
        }
        
//        get order id
        
        String queryOrderId = "select id from orders order by id desc limit 1";
        try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(queryOrderId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                orderId = rs.getInt("id");
            }
            System.out.println("order created here --" + orderId);
         } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

//        create order item
        for(OrderItems item : cartItems) {
            System.out.println("creating order items here --" + orderId);
            MySQLUtil.createOrderItem(orderId, item.getItemId(), item.getItem(),
                    item.getTotal(), item.getQuantity());
        }
        
        JOptionPane.showMessageDialog(this,"Order created Successfully!");
        if(extraId > 0 && extraType.equals("flight")) { 
            this.flightAdminDashboard.switchPanel(new OrderFlightFood(this.flightAdminDashboard));  
        }
        else if(extraId > 0 && extraType.equals("hotel")) {
            this.hotelFrame.switchPanel(new OrderHotelFood(this.hotelFrame));  
        }
        else {
            this.restrauntFrame.switchPanel(new RestrauntSearch(this.restrauntFrame));         
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void populateTable() { 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
//        ArrayList<OrderItems> cartItems = new cartItems();
        for(OrderItems item : cartItems) {
            Object[] row = new Object[5];
            totalPrice = totalPrice + item.getTotal();
            totalQuantity = totalQuantity + item.getQuantity();
            totalPay = totalPrice + tax;
            sTotal.setText(String.valueOf(totalPrice));
            sQuantity.setText(String.valueOf(totalQuantity));
            sPay.setText(String.valueOf(totalPay));
            sTax.setText(String.valueOf(tax));
            
            System.out.println("items-----"+ item);
            row[0] = item.getItemId();
            row[1] = item.getItem();
            row[2] = item.getTotal();
            row[3] = item.getQuantity();
            
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sAddress;
    private javax.swing.JLabel sCity;
    private javax.swing.JLabel sPay;
    private javax.swing.JLabel sQuantity;
    private javax.swing.JLabel sRestraunt;
    private javax.swing.JLabel sTax;
    private javax.swing.JLabel sTotal;
    // End of variables declaration//GEN-END:variables
}
