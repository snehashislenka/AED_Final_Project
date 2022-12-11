/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.RestrauntUser;

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
import model.Restraunt.Restraunt;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;

/**
 *
 * @author Anshul
 */
public class RestrauntMenu extends javax.swing.JPanel {

    /**
     * Creates new form RestrauntMenu
     */
    RestrauntFrame restrauntFrame;
    String city;
    String restraunt; 
    String address;
    String zipcode;
    int restrauntId;
    String item;
    float price;
    String desc;
    int itemId;
    int quantity;
    ArrayList<OrderItems> cartItems = new ArrayList(); 
    
    public RestrauntMenu(RestrauntFrame restrauntFrame, String city, String restraunt, 
            String address, String zipcode, int restrauntId) {
        initComponents();
        this.restrauntFrame = restrauntFrame;
        this.city = city;
        this.restraunt =restraunt;
        this.address = address;
        this.zipcode =zipcode;
        this.restrauntId =restrauntId;
        
        sCity.setText(city);
        sAddress.setText(address);
        sRestraunt.setText(restraunt);
        sZipcode.setText(zipcode);
        
        populateTable();
    }
     
    public RestrauntMenu(RestrauntFrame restrauntFrame) {
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        sQuantity = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        sTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sItem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        sRestraunt = new javax.swing.JLabel();
        sAddress = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sZipcode = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sCity = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 580, 50));

        jButton3.setBackground(new java.awt.Color(255, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("CART");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 50));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setText("←");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Price", "Desc", "Id"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 150));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 30, 210));

        jLabel3.setText("Total");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, 30));

        jButton1.setText("Add to Cart");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 120, 30));

        sQuantity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        sQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sQuantityActionPerformed(evt);
            }
        });
        jPanel2.add(sQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 200, 30));

        jButton2.setText("Select");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 100, 30));

        sTotal.setEnabled(false);
        jPanel2.add(sTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 200, 30));

        jLabel4.setText("Quantity");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, 30));

        sItem.setEnabled(false);
        jPanel2.add(sItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 200, 30));

        jLabel6.setText("Item");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        jScrollPane1.setViewportView(jPanel2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 600, 230));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Photo");
        jLabel2.setToolTipText("");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 160));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 230, -1));

        sRestraunt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sRestraunt.setText("Restraunt Name");
        add(sRestraunt, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 250, 30));

        sAddress.setText("Restraunt Address");
        add(sAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 300, -1));

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("Restraunt Rating: 4/5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        sZipcode.setText("Restraunt City");
        add(sZipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 0, 102));
        jPanel6.setForeground(new java.awt.Color(255, 0, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ORDER");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 70, 280, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Photo");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 60));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 280, 100));

        jPanel7.setBackground(new java.awt.Color(255, 0, 102));
        jPanel7.setForeground(new java.awt.Color(255, 0, 102));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("BOOK TABLE");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 70, 280, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Photo");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 100, 60));

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, 100));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 580, 10));

        sCity.setText("Restraunt City");
        add(sCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
//        cart btn
        int size = cartItems.size();
        if(size <= 0) {
            JOptionPane.showMessageDialog(this,"Please add something to cart!");
            return;
        }
        this.restrauntFrame.switchPanel(new Checkout(this.restrauntFrame, city, restraunt, address, zipcode, restrauntId, cartItems));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        this.restrauntFrame.switchPanel(new TableBooking(this.restrauntFrame, city, restraunt, address, zipcode, restrauntId));
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.restrauntFrame.switchPanel(new TableBooking(this.restrauntFrame, city, restraunt, address, zipcode, restrauntId));
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.restrauntFrame.switchPanel(new TableBooking(this.restrauntFrame, city, restraunt, address, zipcode, restrauntId));
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.restrauntFrame.switchPanel(new RestrauntSearch(this.restrauntFrame));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int selectedRowIndex = jTable1.getSelectedRow();

        if(selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this,"Please select a row to view.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        item = model.getValueAt(selectedRowIndex, 0).toString();
        sItem.setText(item);
        price = Float.parseFloat(model.getValueAt(selectedRowIndex, 1).toString());
        sTotal.setText(String.valueOf(price));
        
        desc = model.getValueAt(selectedRowIndex, 2).toString();
        itemId = Integer.parseInt(model.getValueAt(selectedRowIndex, 3).toString());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:\
        if(itemId <= 0) {
            JOptionPane.showMessageDialog(this,"Select an item first!"); 
            return;
        } 
        
        int size = cartItems.size();
        System.out.println("size cartItems"+ size);
        int matched = 0;
        if(size > 0) {
            for(OrderItems i : cartItems) {
                System.out.println("now item id = "+ i.getItemId() + itemId);
                if(i.getItemId() == itemId) {
                    matched = matched + 1;
                    System.out.println("matched here" + matched);
                    
                    int totalQuantity = Integer.parseInt(sQuantity.getSelectedItem().toString()) + i.getQuantity();
                    i.setQuantity(totalQuantity);
                    
                    float totalPrice = price * totalQuantity;
                    i.setTotal(totalPrice);
                }
            }
        } 
        
        if(matched == 0) {
            System.out.println("did not match here");
            quantity = Integer.parseInt(sQuantity.getSelectedItem().toString());
            float totalPrice = price * quantity;
            OrderItems cart = new OrderItems(itemId, item, totalPrice, quantity);
            cartItems.add(cart);
            System.out.println("cartItems------" +cartItems);
        }
        
        JOptionPane.showMessageDialog(this,"Item added to cart!");
           
        sItem.setText("");
        sQuantity.setSelectedItem("1");
        sTotal.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sQuantityActionPerformed
        // TODO add your handling code here:
        quantity = Integer.parseInt(sQuantity.getSelectedItem().toString());
        float totalPrice = price * quantity;
        sTotal.setText(String.valueOf(totalPrice));
    }//GEN-LAST:event_sQuantityActionPerformed

    private void populateTable() {
        ArrayList<MenuItems> itemList = new ArrayList(); 
        String query = "Select id, item, price, descr from menu_items where restrauntId = ?";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            
            ps.setInt(1,restrauntId);
            
            ResultSet rs = ps.executeQuery();   
            
        System.out.println("here------------"+rs);
            while(rs.next()) {
                MenuItems res = new MenuItems(rs.getInt("id"), rs.getString("item"), rs.getFloat("price"), 
                rs.getString("descr"));
                itemList.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for(MenuItems h : itemList) {
            Object[] row = new Object[5];
            row[0] = h.getItem();
            row[1] = h.getPrice();
            row[2] = h.getDesc();
            row[3] = h.getId();
            
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sAddress;
    private javax.swing.JLabel sCity;
    private javax.swing.JTextField sItem;
    private javax.swing.JComboBox<String> sQuantity;
    private javax.swing.JLabel sRestraunt;
    private javax.swing.JTextField sTotal;
    private javax.swing.JLabel sZipcode;
    // End of variables declaration//GEN-END:variables
}
