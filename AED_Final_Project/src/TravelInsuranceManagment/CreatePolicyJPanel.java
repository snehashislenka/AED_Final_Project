/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package TravelInsuranceManagment;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bus.Bus;
import model.catgeory.Category;
import model.policy.Policy;
import mysql.util.MySQLUtil;

/**
 *
 * @author parjita
 */
public class CreatePolicyJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreatePolicyJPanel
     */
    ArrayList<Category> categoryList;
    Category selectedCategory;
    public CreatePolicyJPanel() {
        initComponents();
         
        this.categoryList = MySQLUtil.getallcategory();
        String[] categoryNameArr = new String[categoryList.size()];
        for(int i =0; i< categoryList.size(); i++) {
	categoryNameArr[i] = categoryList.get(i).getCategoryName();
        }

        categoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(categoryNameArr));
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
        PolicyTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PolicyNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SumAssuranceTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PremiumTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TenureTextField = new javax.swing.JTextField();
        CreatePolicyBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        PolicyDateTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        categoryDropdown = new javax.swing.JComboBox<>();
        viewpolicybtn = new javax.swing.JButton();
        updatepolicybtn = new javax.swing.JButton();
        deletepolicybtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ViewPolicyTable = new javax.swing.JTable();

        PolicyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Policy ID", "Policy Name", "Category", "Sum Assurance", "Premium", "Tenure", "Creatation Date"
            }
        ));
        jScrollPane1.setViewportView(PolicyTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Policy");

        jLabel3.setText("Policy Name");

        jLabel4.setText("Sum Assurance");

        jLabel5.setText("Premium");

        jLabel6.setText("Tenure");

        CreatePolicyBtn.setText("Create");
        CreatePolicyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePolicyBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Date");

        jLabel2.setText("Category");

        categoryDropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        categoryDropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryDropdownActionPerformed(evt);
            }
        });

        viewpolicybtn.setText("View");
        viewpolicybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewpolicybtnActionPerformed(evt);
            }
        });

        updatepolicybtn.setText("Update");
        updatepolicybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatepolicybtnMouseClicked(evt);
            }
        });
        updatepolicybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatepolicybtnActionPerformed(evt);
            }
        });

        deletepolicybtn.setText("Delete");
        deletepolicybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletepolicybtnActionPerformed(evt);
            }
        });

        ViewPolicyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Policy ID", "Policy Name", "Category", "Sum Assurance", "Premium", "Tenure", "Creatation Date"
            }
        ));
        ViewPolicyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewPolicyTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ViewPolicyTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SumAssuranceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TenureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreatePolicyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewpolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PolicyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PremiumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PolicyDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(updatepolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deletepolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryDropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PolicyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SumAssuranceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PremiumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TenureTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PolicyDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreatePolicyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewpolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updatepolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deletepolicybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreatePolicyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePolicyBtnActionPerformed
        // TODO add your handling code here:
        String PolicyName = PolicyNameTextField.getText();
        String CategoryName;
        int PolicySumAssurance = Integer.parseInt(SumAssuranceTextField.getText());
        int PolicyPremium = Integer.parseInt(PremiumTextField.getText());
        int PolicyTenure = Integer.parseInt(TenureTextField.getText());
        String PolicyDate = PolicyDateTextField.getText();
        
        
        MySQLUtil.addpolicydetails(PolicyName,this.selectedCategory.getCategoryName(),PolicySumAssurance,PolicyPremium,PolicyTenure,PolicyDate);
        JOptionPane.showMessageDialog(this,"New Policy Detail Added");
       
    }//GEN-LAST:event_CreatePolicyBtnActionPerformed

    private void viewpolicybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewpolicybtnActionPerformed
        // TODO add your handling code here:
         populateTable();
    }//GEN-LAST:event_viewpolicybtnActionPerformed

    private void deletepolicybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletepolicybtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = ViewPolicyTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) ViewPolicyTable.getModel();
        int policyID = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        
        MySQLUtil.deletepolicy(policyID);
                    
        populateTable();
    }//GEN-LAST:event_deletepolicybtnActionPerformed

    private void updatepolicybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatepolicybtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = ViewPolicyTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to update!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) ViewPolicyTable.getModel();
        int selectedpolicyId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
                
        String PolicyName = PolicyNameTextField.getText();
        int PolicySumAssurance = Integer.parseInt(SumAssuranceTextField.getText());
        int PolicyPremium = Integer.parseInt(PremiumTextField.getText());
        int PolicyTenure = Integer.parseInt(TenureTextField.getText());
        String PolicyDate = PolicyDateTextField.getText();
               
        MySQLUtil.updatepolicydetail(PolicyName,PolicySumAssurance,PolicyPremium,PolicyTenure,PolicyDate,selectedpolicyId);
        populateTable();
    }//GEN-LAST:event_updatepolicybtnActionPerformed

    private void categoryDropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryDropdownActionPerformed
        // TODO add your handling code here:
        JComboBox categoryDropdown = (JComboBox)evt.getSource();
        String networkName = (String)categoryDropdown.getSelectedItem();
        
        for(Category category: this.categoryList) {
            if(category.getCategoryName().equals(networkName)) {
                this.selectedCategory = category;
            }
        }
    }//GEN-LAST:event_categoryDropdownActionPerformed

    private void updatepolicybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatepolicybtnMouseClicked
        // TODO add your handling code here:
  
    }//GEN-LAST:event_updatepolicybtnMouseClicked

    private void ViewPolicyTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPolicyTableMouseClicked
        // TODO add your handling code here:
              int selectedRow = ViewPolicyTable.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to update!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) ViewPolicyTable.getModel();
        int selectedpolicyId = Integer.parseInt(model.getValueAt(selectedRow, 0).toString());
        
        
        Policy selectedPolicy = MySQLUtil.getPolicyById(selectedpolicyId);
        
        PolicyNameTextField.setText(selectedPolicy.getPolicyName());
        SumAssuranceTextField.setText(String.valueOf(selectedPolicy.getPolicySumAssurance()));
        PremiumTextField.setText(String.valueOf(selectedPolicy.getPolicyPremium()));
        TenureTextField.setText(String.valueOf(selectedPolicy.getPolicyTenure()));
        PolicyDateTextField.setText(selectedPolicy.getPolicyDate());
    }//GEN-LAST:event_ViewPolicyTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePolicyBtn;
    private javax.swing.JTextField PolicyDateTextField;
    private javax.swing.JTextField PolicyNameTextField;
    private javax.swing.JTable PolicyTable;
    private javax.swing.JTextField PremiumTextField;
    private javax.swing.JTextField SumAssuranceTextField;
    private javax.swing.JTextField TenureTextField;
    private javax.swing.JTable ViewPolicyTable;
    private javax.swing.JComboBox<String> categoryDropdown;
    private javax.swing.JButton deletepolicybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton updatepolicybtn;
    private javax.swing.JButton viewpolicybtn;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
       DefaultTableModel model = (DefaultTableModel) ViewPolicyTable.getModel();
       model.setRowCount(0);
       ArrayList<Policy> policyList = MySQLUtil.viewpolicydetails();
       for(Policy p : policyList ){
            Object[] row = new Object[7];
                   row[0] = p.getPolicyID();
                   row[1] = p.getPolicyName();
                   row[2] = p.getCategoryName();
                   row[3] = p.getPolicySumAssurance();
                   row[4] = p.getPolicyPremium();
                   row[5] = p.getPolicyTenure();
                   row[6] = p.getPolicyDate();                   
                   
                   model.addRow(row);
       }
    }
}
