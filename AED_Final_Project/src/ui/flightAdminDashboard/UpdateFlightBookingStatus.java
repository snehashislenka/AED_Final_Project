/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.flightAdminDashboard;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Flight.FlightBookings;
import model.Person.Person;
import mysql.util.MySQLUtil;
import model.Flight.Flight;

/**
 *
 * @author slenk
 */
public class UpdateFlightBookingStatus extends javax.swing.JPanel {

    /**
     * Creates new form UpdateFlightBookingStatus
     */
    
    private String selectedStatus;
    private int selectedBookingId;
    
    
    public UpdateFlightBookingStatus() {
        initComponents();
        
        String[] statusArr = {"SELECT A STATUS", "BOOKED", 
            "CANCELLED", "CHECKED_IN"}; 
        flightBookingStatusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(statusArr));
        
        populateTable();

    }
    
    public void populateTable() {
        ArrayList<FlightBookings> flightBookingsList = 
                MySQLUtil.getAllFlightBookings();
        
        DefaultTableModel model = (DefaultTableModel) 
                tableFlightBookingDetails.getModel();
        
        model.setRowCount(0);
        
        for(FlightBookings bookings: flightBookingsList) {
            
            Person person = MySQLUtil.getPerson(bookings.getPersonId());
            
            Object[] row = new Object[6];
            
            row[0] = bookings.getBookingId();
            row[1] = bookings.getFlightId();
            row[2] = person.getFirstname() + " " + 
                    person.getLastname();
            row[3] = bookings.getFlightSeat();
            row[4] = bookings.getPrice();
            row[5] = bookings.getBookingStatus();
            
            model.addRow(row);
        }
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
        tableFlightBookingDetails = new javax.swing.JTable();
        flightBookingStatusCombo = new javax.swing.JComboBox<>();
        btnUpdateStatus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        tableFlightBookingDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Booking ID", "Flight ID", "Person Name", "Seat", "Price", "Status"
            }
        ));
        tableFlightBookingDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFlightBookingDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableFlightBookingDetails);

        flightBookingStatusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        flightBookingStatusCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightBookingStatusComboActionPerformed(evt);
            }
        });

        btnUpdateStatus.setText("Update Status");
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Flight Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(flightBookingStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdateStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightBookingStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnUpdateStatus, flightBookingStatusCombo});

    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed
        
        if(tableFlightBookingDetails.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row!");
            return;
        }
        
        System.out.println(this.selectedBookingId + " " 
        + this.selectedStatus);
        
        MySQLUtil.updateFlightBookingStatus(this.selectedBookingId, 
                this.selectedStatus);
        
        populateTable();
    }//GEN-LAST:event_btnUpdateStatusActionPerformed

    private void tableFlightBookingDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFlightBookingDetailsMouseClicked
        int selectedRow = tableFlightBookingDetails.getSelectedRow();
        
        this.selectedBookingId = Integer.parseInt(tableFlightBookingDetails.getValueAt(
                selectedRow, 0).toString());
        
    }//GEN-LAST:event_tableFlightBookingDetailsMouseClicked

    private void flightBookingStatusComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightBookingStatusComboActionPerformed
        String status = String.valueOf(flightBookingStatusCombo.getSelectedItem());
       
        System.out.println(status + this.selectedBookingId);
        
        if(status.equals("SELECT A STATUS")) {
            this.selectedStatus = "";
        } else {
            this.selectedStatus = status;
        }
    }//GEN-LAST:event_flightBookingStatusComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JComboBox<String> flightBookingStatusCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFlightBookingDetails;
    // End of variables declaration//GEN-END:variables
}
