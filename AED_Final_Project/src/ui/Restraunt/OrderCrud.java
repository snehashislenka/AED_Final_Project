/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Restraunt;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Restraunt.MenuItems;
import model.Restraunt.OrderItems;
import model.Restraunt.Orders;
import mysql.util.MySQLUtil;

/**
 *
 * @author Anshul
 */
public class OrderCrud extends javax.swing.JPanel {

    /**
     * Creates new form OrderCrud
     */
    public OrderCrud() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        upStatus = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order Id", "User", "Restraunt", "Total", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 580, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Order Info:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 600, 30));

        jLabel20.setText("Status");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 20));

        jButton1.setText("View Order Info");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 150, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 600, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Price", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 580, 180));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Orders");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 600, 30));

        upStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDERED", "COOKING", "COOKED", "SERVING", "SERVED" }));
        add(upStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 160, 30));

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        order info
         int selectedRowIndex = jTable1.getSelectedRow();
         
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }
          
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int orderId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        
        populateOrderTable(orderId);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        update
        String status = upStatus.getSelectedItem().toString();
        
        int selectedRowIndex = jTable1.getSelectedRow();
         
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }
          
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        
        MySQLUtil.updateOrder(id, status);
        
        upStatus.setSelectedItem("ORDERED");
        
        populateTable();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        ArrayList<Orders> allOrders = MySQLUtil.getAllOrders();
        
        for(Orders o : allOrders) {
            Object[] row = new Object[5];
            row[0] = o.getId();
            row[1] = o.getUser();
            row[2] = o.getRestraunt();
            row[3] = o.getOrderTotal();
            row[4] = o.getStatus();
            
            model.addRow(row);
        }
    }  
    
    private void populateOrderTable(int orderId){
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        
        ArrayList<OrderItems> allOrderItems = MySQLUtil.getAllOrderItems(orderId);
        
        for(OrderItems o : allOrderItems) {
            Object[] row = new Object[3];
            row[0] = o.getItem();
            row[1] = o.getTotal();
            row[2] = o.getQuantity();
            
            model.addRow(row);
        }
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> upStatus;
    // End of variables declaration//GEN-END:variables
}
