/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Person.Person;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;

/**
 *
 * @author Anshul
 */
public class Reports extends javax.swing.JPanel {

    /**
     * Creates new form report
     */
    public Reports() {
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Top 3 Customers with max booking");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 30));

        jScrollPane1.setForeground(new java.awt.Color(204, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "gender", "email"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 260, 100));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Top 3 Hotels with max booking");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 600, 30));

        jScrollPane2.setForeground(new java.awt.Color(204, 153, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "name", "gender", "email", "total bookings"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 100));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 153, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Low Performing Hotels");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 300, 30));

        jScrollPane3.setForeground(new java.awt.Color(204, 153, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "gender", "email"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 560, 100));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 153, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("New Customers");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 300, 30));

        jScrollPane4.setForeground(new java.awt.Color(204, 153, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "name", "gender", "email"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 270, 100));
    }// </editor-fold>//GEN-END:initComponents
    
    private void populateTable() {
        ArrayList<Person> customerList = new ArrayList(); 
        String query1 = "Select p.id, CONCAT(p.firstname, ' ', p.lastname) as name, p.gender, p.email, count(h.id) as totalBookings FROM person p inner join hotel_bookings h on p.id = h.userId group by p.id order by totalBookings desc limit 3";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query1); 
            
            ResultSet rs = ps.executeQuery();   
            
//        System.out.println("here------------"+rs.getInt("room_no"));
            while(rs.next()) {
                Person res = new Person(rs.getInt("id"), rs.getString("name"),
                rs.getString("gender"),rs.getString("email"), rs.getString("totalBookings"));
                customerList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        for(Person r : customerList) {
            Object[] row = new Object[5];
            row[0] = r.getId();
            row[1] = r.getFirstname();
            row[2] = r.getGender();
            row[3] = r.getEmail();
            row[4] = r.getLastname();
            
            model.addRow(row);
        }
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
