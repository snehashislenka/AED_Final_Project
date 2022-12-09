/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Hotel;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Hotel.Hotel;
import model.Hotel.HotelBookings;
import mysql.util.MySQLUtil;

/**
 *
 * @author Anshul
 */
public class HotelBookingCrud extends javax.swing.JPanel {

    /**
     * Creates new form BookingAdmin
     */
    public HotelBookingCrud() {
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room No", "Customer", "from", "to", "No of Rooms"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 580, 350));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bookings");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 600, 30));

        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 150, 30));
        add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 200, 30));

        jLabel19.setText("Room No");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 20));

        jLabel20.setText("Status");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Booked", "Checked-in", "Checked-out", "Cancelled" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 200, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

     private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        HotelBookings hotelBookings = new HotelBookings();
        
        ArrayList<HotelBookings> allBookings = MySQLUtil.getHotelBookings(hotelBookings);
        
        for(HotelBookings b : allBookings) {
            Object[] row = new Object[6];
            row[0] = b.getRoom_no();
            row[1] = b.getUser();
            row[2] = b.getFrom();
            row[3] = b.getTo();
            row[4] = b.getNo_of_rooms();
            row[5] = b.getPrice();
            
            model.addRow(row);
        }
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField12;
    // End of variables declaration//GEN-END:variables
}
