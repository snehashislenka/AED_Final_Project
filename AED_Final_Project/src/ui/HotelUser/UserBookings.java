/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.HotelUser;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Hotel.HotelBookings;
import model.Person.Person;
import model.Restraunt.TableBookings;
import mysql.util.MySQLUtil;

/**
 *
 * @author Anshul
 */
public class UserBookings extends javax.swing.JPanel {

    /**
     * Creates new form UserBookings
     */
    HotelFrame hotelFrame;
    public UserBookings(HotelFrame hotelFrame) {
        initComponents();
        this.hotelFrame = hotelFrame;
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

        jPanel7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 204, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("MY BOOKINGS");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 16, 580, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("←");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hotel", "Room No", "Check-in", "Check-out"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 560, 220));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 560, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          this.hotelFrame.switchPanel(new SearchHotel(this.hotelFrame));
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        int userId;
        Person person = MySQLUtil.getPersonSession();
        userId = person.getId();
        System.out.println("userid: -----"+ userId);
        
        
        
        ArrayList<HotelBookings> allUserBookings = MySQLUtil.getAllUserBookings(userId);
        
        for(HotelBookings u : allUserBookings) {
            Object[] row = new Object[4];
            row[0] = u.getHotel();
            row[1] = u.getRoom_no();
            row[2] = u.getFrom();
            row[3] = u.getTo();
            
            model.addRow(row);
        }
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
