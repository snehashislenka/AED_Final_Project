/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Enterprise;

import ui.SystemAdminPanel.CreateCity;
import ui.SystemAdminPanel.CreateEnterprise;
import ui.SystemAdminPanel.CreateNetwork;
import ui.SystemAdminPanel.ViewEnterprise;
import ui.userdashboard.Dashboard;

/**
 *
 * @author slenk
 */
public class SystemAdminLeftPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminLeftPanel
     */
    
    Dashboard dashboard;
    
    public SystemAdminLeftPanel(Dashboard dashboard) {
        initComponents();
        this.dashboard = dashboard;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CreateEnterpriseBtn = new javax.swing.JButton();
        ViewEnterpriseBtn = new javax.swing.JButton();
        Addnetworkbtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        CreateEnterpriseBtn.setText("Create Entrprise");
        CreateEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateEnterpriseBtnActionPerformed(evt);
            }
        });

        ViewEnterpriseBtn.setText("View Enterprise");
        ViewEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewEnterpriseBtnActionPerformed(evt);
            }
        });

        Addnetworkbtn.setText("Manage Network");
        Addnetworkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddnetworkbtnActionPerformed(evt);
            }
        });

        jButton4.setText("Manage City");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ViewEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Addnetworkbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Addnetworkbtn, CreateEnterpriseBtn, ViewEnterpriseBtn, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(CreateEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ViewEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Addnetworkbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateEnterpriseBtnActionPerformed
        // TODO add your handling code here:
        CreateEnterprise CreatePanel = new CreateEnterprise();
        dashboard.switchPanel(CreatePanel);
    }//GEN-LAST:event_CreateEnterpriseBtnActionPerformed

    private void ViewEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewEnterpriseBtnActionPerformed
        // TODO add your handling code here:
        ViewEnterprise ViewPanel = new ViewEnterprise();
        dashboard.switchPanel(ViewPanel);
    }//GEN-LAST:event_ViewEnterpriseBtnActionPerformed

    private void AddnetworkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddnetworkbtnActionPerformed
        // TODO add your handling code here:
        CreateNetwork CreatePanel = new CreateNetwork();
        dashboard.switchPanel(CreatePanel);
    }//GEN-LAST:event_AddnetworkbtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CreateCity CreatePanel = new CreateCity();
        dashboard.switchPanel(CreatePanel);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addnetworkbtn;
    private javax.swing.JButton CreateEnterpriseBtn;
    private javax.swing.JButton ViewEnterpriseBtn;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
