/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.userdashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;

/**
 *
 * @author slenk
 */
public class MyFlightBookings extends javax.swing.JFrame {

    /**
     * Creates new form MyFlightBookings
     */
    
    public MyFlightBookings() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        populateTable();
    }
    
    public void populateTable() {
        int personId = MySQLUtil.getPersonSession().getId();
        String query = "select fb.bookingId, f.flightCompanyName, f.departingCity, f.departingTimeStamp, f.departureAirport,\n" +
"f.departureTerminal, f.arrivalCity, f.arrivalTimeStamp, f.arrivalAirport, f.arrivalTerminal,\n" +
"fb.flightSeat, fb.price, fb.booking_status\n" +
"from flight_bookings fb inner join flight f on f.flightId =\n" +
" fb.flightId inner join person p on p.id = fb.personId where fb.personId=?";
        
        DefaultTableModel model = (DefaultTableModel) tableMyFlightBookings.getModel();
        model.setRowCount(0);
        
        try {
            Connection conn = connectMySQL();
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, personId);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                Object[] row = new Object[13];
                row[0] = rs.getString("bookingId");
                row[1] = rs.getString("flightCompanyName");
                row[2] = rs.getString("departingCity");
                row[3] = rs.getString("departingTimeStamp");
                row[4] = rs.getString("departureAirport");
                row[5] = rs.getString("departureTerminal");
                row[6] = rs.getString("arrivalCity");
                row[7] = rs.getString("arrivalTimeStamp");
                row[8] = rs.getString("arrivalAirport");
                row[9] = rs.getString("arrivalTerminal");
                row[10] = rs.getString("flightSeat");
                row[11] = rs.getString("price");
                row[12] = rs.getString("booking_status");
                model.addRow(row);
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, "Issue with "
                    + "get flights query!", ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMyFlightBookings = new javax.swing.JTable();
        btnCheckin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("My Flight Bookings");

        tableMyFlightBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Flight Name", "Departing City", "Dept Time", "Dept Airport", "Dept Terminal", "Arrival City", "Arrival Time", "Arrival Airport", "Arrival Terminal", "Seats", "Price", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMyFlightBookings);

        btnCheckin.setText("Check In");
        btnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckinActionPerformed(evt);
            }
        });

        jButton2.setText("Insurance Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(562, 562, 562)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCheckin, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckinActionPerformed
        int selectedRow = tableMyFlightBookings.getSelectedRow();
        
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a booking!");
            return;
        }
        
        int selectedBookingId = Integer.parseInt(tableMyFlightBookings.getModel()
                .getValueAt(selectedRow, 0).toString());
        
        String selectedStatus = tableMyFlightBookings.getModel()
                .getValueAt(selectedRow, 12).toString();
        
        if(selectedStatus.equals("CHECKED_IN")) {
            JOptionPane.showMessageDialog(this, "You are already checked in!");
        }
        
        MySQLUtil.updateFlightBookingStatus(selectedBookingId, "CHECKED_IN");
        
        populateTable();
    }//GEN-LAST:event_btnCheckinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyFlightBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyFlightBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyFlightBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyFlightBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFlightBookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMyFlightBookings;
    // End of variables declaration//GEN-END:variables
}