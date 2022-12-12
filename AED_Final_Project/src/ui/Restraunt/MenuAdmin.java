/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.Restraunt;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hotel.Hotel;
import model.Restraunt.MenuItems;
import mysql.util.MySQLUtil;

/**
 *
 * @author Anshul
 */
public class MenuAdmin extends javax.swing.JPanel {

    /**
     * Creates new form MenuAdmin
     */
    public MenuAdmin() {
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        crDesc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        crItem = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        crPrice = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        upDesc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        upItem = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        upPrice = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        crRes = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 320, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Restraunt", "Item", "Price", "Desc", "Id"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 580, 170));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 600, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 600, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Create");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 600, 30));

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 110, 30));
        add(crDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 30));

        jLabel15.setText("Desc");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        jLabel16.setText("Price");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 20));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 10));
        add(crItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 200, 30));

        jLabel19.setText("Item");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));
        add(crPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 200, 30));

        jButton8.setText("Update");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 150, 30));
        add(upDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 200, 30));

        jLabel17.setText("Desc");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 20));

        jLabel18.setText("Restraunt");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 20));
        add(upItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 200, 30));

        jLabel20.setText("Item");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, 20));
        add(upPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 200, 30));

        jButton7.setText("Submit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 150, 30));

        jButton9.setText("View");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 110, 30));

        jLabel21.setText("Price");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, -1, 20));

        crRes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Popeyes", "Panera Bread", "Dominos", "Subwaya" }));
        add(crRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 200, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        delete
            int selectedRowIndex = jTable1.getSelectedRow();

            if(selectedRowIndex < 0) {
                JOptionPane.showMessageDialog(this,"Please select a row to view.");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            
            int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());

            MySQLUtil.deleteMenu(id);
            JOptionPane.showMessageDialog(this,"Record deleted Successfully!");

            upItem.setText("");
            upPrice.setText("");
            upDesc.setText("");

            populateTable();
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
//        update
        if(upItem.getText().isEmpty() || upPrice.getText().isEmpty() ||
                upDesc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inputs should not be Empty");
            return;
        }
        
        String item = upItem.getText();
        float price = Float.parseFloat(upPrice.getText());
        String desc = upDesc.getText();
        
        int selectedRowIndex = jTable1.getSelectedRow();
         
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }
          
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        int id = Integer.parseInt(model.getValueAt(selectedRowIndex, 4).toString());
        
        MySQLUtil.updateMenu(id, item, price, desc);
        
        upItem.setText("");
        upPrice.setText("");
        upDesc.setText("");
        
        populateTable();

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//        insert
        if(crItem.getText().isEmpty() || crPrice.getText().isEmpty() || crDesc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inputs should not be Empty");
            return;
        }
          
        String item = crItem.getText();
        float price = Float.parseFloat(crPrice.getText());
        String desc = crDesc.getText();
        String restraunt = crRes.getSelectedItem().toString();
        
        int resId = 1;
        if(restraunt.equals("Popeyes")) resId = 1;
        if(restraunt.equals("Panera Bread")) resId = 2;
        if(restraunt.equals("Dominos")) resId = 3;
        if(restraunt.equals("Subway")) resId = 4;
        
        MenuItems m = new MenuItems();
        
        m.setItem(item);
        m.setPrice(price);
        m.setDesc(desc);
        m.setRestrauntId(resId);
        m.setRestraunt(restraunt);
        
        MySQLUtil.addMenu(item, price, desc, resId, restraunt);
        
        JOptionPane.showMessageDialog(this, "Record created successfully!");
        
        crItem.setText("");
        crPrice.setText("");
        crDesc.setText("");
     
        populateTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
//        view
        int selectedRowIndex = jTable1.getSelectedRow();
         
        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }
          
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String item = model.getValueAt(selectedRowIndex, 1).toString();
        String price = model.getValueAt(selectedRowIndex, 2).toString();
        String desc = model.getValueAt(selectedRowIndex, 3).toString();
        
        upItem.setText(item);
        upPrice.setText(price);
        upDesc.setText(desc);
    }//GEN-LAST:event_jButton9ActionPerformed
    
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        ArrayList<MenuItems> allMenu = MySQLUtil.getAllMenu();
        
        for(MenuItems m : allMenu) {
            Object[] row = new Object[5];
            row[0] = m.getRestraunt();
            row[1] = m.getItem();
            row[2] = m.getPrice();
            row[3] = m.getDesc();
            row[4] = m.getId();
            
            model.addRow(row);
        }
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField crDesc;
    private javax.swing.JTextField crItem;
    private javax.swing.JTextField crPrice;
    private javax.swing.JComboBox<String> crRes;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField upDesc;
    private javax.swing.JTextField upItem;
    private javax.swing.JTextField upPrice;
    // End of variables declaration//GEN-END:variables
}
