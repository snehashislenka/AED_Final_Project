/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.InsuranceManagment;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.booking.PolicyBooking;
import mysql.util.MySQLUtil;
import policystatus.Policystatus;

/**
 *
 * @author parjita
 */
public class CutomerAppliedPolicies extends javax.swing.JPanel {

    /**
     * Creates new form CutomerAppliedPolicies
     */
    InsuranceAdmin_Dashboard dashboardpanel;
   
    public CutomerAppliedPolicies(InsuranceAdmin_Dashboard dashboardpanel) {
        initComponents();
        this.dashboardpanel = dashboardpanel;
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
        AvailablePoliciesTable = new javax.swing.JTable();
        Approvedbtn = new javax.swing.JButton();
        rejectbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        AvailablePoliciesTable.setForeground(new java.awt.Color(0, 204, 255));
        AvailablePoliciesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Person ID", "Person Name", "Policy ID", "Policy Name", "Category", "Sum Assurance", "Premium", "Tenure", "Application Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(AvailablePoliciesTable);

        Approvedbtn.setBackground(new java.awt.Color(0, 204, 255));
        Approvedbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Approvedbtn.setForeground(new java.awt.Color(255, 255, 255));
        Approvedbtn.setText("Approved");
        Approvedbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        Approvedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApprovedbtnActionPerformed(evt);
            }
        });

        rejectbtn.setBackground(new java.awt.Color(0, 204, 255));
        rejectbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rejectbtn.setForeground(new java.awt.Color(255, 255, 255));
        rejectbtn.setText("Reject");
        rejectbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        rejectbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customers Policy Verification");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Approvedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(rejectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Approvedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ApprovedbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApprovedbtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = AvailablePoliciesTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) AvailablePoliciesTable.getModel();
        int selectedpersonId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        
        JOptionPane.showMessageDialog(this,"Person Policy Approved");
        String Status = "Approved";
               
        MySQLUtil.updatepolicybookingdetail(Status, selectedpersonId);
        populateTable();
    }//GEN-LAST:event_ApprovedbtnActionPerformed

    private void rejectbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectbtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = AvailablePoliciesTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) AvailablePoliciesTable.getModel();
        int selectedId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        
        JOptionPane.showMessageDialog(this,"Person Policy Rejected");
        String Status = "REJECTED";
               
        MySQLUtil.rejectpolicybookingdetail(Status, selectedId);
        populateTable();
    }//GEN-LAST:event_rejectbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Approvedbtn;
    private javax.swing.JTable AvailablePoliciesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rejectbtn;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
       DefaultTableModel model = (DefaultTableModel) AvailablePoliciesTable.getModel();
       model.setRowCount(0);
       ArrayList<Policystatus> PolicystatusList = MySQLUtil.viewpolicystatusdetails();
       for(Policystatus p : PolicystatusList ){
        Object[] row = new Object[10];
               row[0] = p.getPersonID();
               row[1] = p.getPersonName();
               row[2] = p.getPolicyID();
               row[3] = p.getPolicyName();
               row[4] = p.getCategory();
               row[5] = p.getSumassurance();
               row[6] = p.getPremium();
               row[7] = p.getTenure();
               row[8] = p.getAppliedDate();
               row[9] = p.getStatus();                            

               model.addRow(row);
       }
    }
}
