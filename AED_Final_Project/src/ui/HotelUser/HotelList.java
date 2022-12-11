/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.HotelUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hotel.Hotel;
import model.Hotel.Rooms;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;

/**
 *
 * @author Anshul
 */
public class HotelList extends javax.swing.JPanel {

    /**
     * Creates new form HotelList
     */
    HotelFrame hotelFrame;
    String city;
    Date checkin;
    Date checkout;
    int no_rooms;
    
    public HotelList(HotelFrame hotelFrame, String city, Date checkin, Date checkout, int no_rooms) {
        initComponents();
        this.hotelFrame = hotelFrame;
        this.city = city;
        this.checkin = checkin;
        this.checkout = checkout;
        this.no_rooms = no_rooms;
        searchHotel(city, checkin, checkout, no_rooms);
    }
    
    public HotelList(HotelFrame hotelFrame) {
        initComponents();
        this.hotelFrame = hotelFrame;
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
        sRooms = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sIn = new com.toedter.calendar.JDateChooser();
        sCity = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        sOut = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sRooms.setBackground(new java.awt.Color(255, 204, 204));
        sRooms.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sRooms.setForeground(new java.awt.Color(255, 255, 255));
        sRooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sRoomsActionPerformed(evt);
            }
        });
        jPanel1.add(sRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("No of Rooms");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Check-out");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        sIn.setBackground(new java.awt.Color(255, 204, 204));
        sIn.setForeground(new java.awt.Color(255, 204, 204));
        sIn.setToolTipText("");
        sIn.setDateFormatString("MM-dd-yyyy");
        jPanel1.add(sIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 110, -1));

        sCity.setBackground(new java.awt.Color(255, 204, 204));
        sCity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sCity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(sCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("←");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        sOut.setBackground(new java.awt.Color(255, 204, 204));
        sOut.setForeground(new java.awt.Color(255, 204, 204));
        sOut.setToolTipText("");
        sOut.setDateFormatString("MM-dd-yyyy");
        jPanel1.add(sOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 110, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Where");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Check-in");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Hotel", "Address", "City", "Zipcode", "Hotel Id"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 390, 330));

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 390, 30));

        jScrollPane1.setViewportView(jPanel3);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 510));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 440, 510));

        jLabel3.setText("Photo here");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void sRoomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sRoomsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sRoomsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.hotelFrame.switchPanel(new SearchHotel( this.hotelFrame));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();

        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String hotel = model.getValueAt(selectedRowIndex, 0).toString();
        String address = model.getValueAt(selectedRowIndex, 1).toString();
        //        String city = model.getValueAt(selectedRowIndex, 2).toString();
        String zipcode = model.getValueAt(selectedRowIndex, 3).toString();
        int hotelId = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());

        this.hotelFrame.switchPanel(new RoomSelect(this.hotelFrame, hotel, address, city, zipcode, hotelId, checkin, checkout, no_rooms));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchHotel(String city,Date checkin,Date checkout,int no_rooms) {
        System.out.println("here------"+  city + checkin + checkout + no_rooms);
        
        sCity.setText(city);
        sIn.setDate(checkin);
        sOut.setDate(checkout);
        sRooms.setText(String.valueOf(no_rooms));
        
        ArrayList<Hotel> hotelList = new ArrayList(); 
        String query = "Select id, hotel, address, city, zipcode from hotel where city like CONCAT('%', ?, '%')";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            
            ps.setString(1,city);
            
            ResultSet rs = ps.executeQuery();   
            
        System.out.println("here------------"+rs);
            while(rs.next()) {
                Hotel res = new Hotel(rs.getInt("id"), rs.getString("hotel"), rs.getString("address"), 
                rs.getString("city"), rs.getString("zipcode"));
                hotelList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(Hotel h : hotelList) {
            Object[] row = new Object[5];
            row[0] = h.getHotel();
            row[1] = h.getAddress();
            row[2] = h.getCity();
            row[3] = h.getZipcode();
            row[4] = h.getId();
            
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sCity;
    private com.toedter.calendar.JDateChooser sIn;
    private com.toedter.calendar.JDateChooser sOut;
    private javax.swing.JTextField sRooms;
    // End of variables declaration//GEN-END:variables
}
