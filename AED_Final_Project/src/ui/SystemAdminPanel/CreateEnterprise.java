/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SystemAdminPanel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import mysql.util.MySQLUtil;

/**
 *
 * @author parjita
 */
public class CreateEnterprise extends javax.swing.JPanel {

    /**
     * Creates new form CreateEnterprise
     */
    public CreateEnterprise() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        FirstNameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LastNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GenderTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        Createbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        RoleTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EnterpriseNameTextField = new javax.swing.JTextField();
        PasswordTextField = new javax.swing.JPasswordField();
        eename = new javax.swing.JLabel();
        efname = new javax.swing.JLabel();
        elname = new javax.swing.JLabel();
        egender = new javax.swing.JLabel();
        erole = new javax.swing.JLabel();
        eemail = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("FirstName");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 158, 126, 49));

        FirstNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                FirstNameTextFieldKeyReleased(evt);
            }
        });
        add(FirstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 266, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("LastName");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 226, 126, 40));

        LastNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                LastNameTextFieldKeyReleased(evt);
            }
        });
        add(LastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 266, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Gender");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 295, 126, 46));

        GenderTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                GenderTextFieldKeyReleased(evt);
            }
        });
        add(GenderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 266, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Email");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 452, 126, 44));

        EmailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailTextFieldKeyReleased(evt);
            }
        });
        add(EmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 266, 30));

        Createbtn.setBackground(new java.awt.Color(0, 153, 153));
        Createbtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Createbtn.setForeground(new java.awt.Color(255, 255, 255));
        Createbtn.setText("Create");
        Createbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        Createbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatebtnActionPerformed(evt);
            }
        });
        add(Createbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 602, 266, 39));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Enterprise");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 20, -1, 44));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Role");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 373, 126, 46));

        RoleTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                RoleTextFieldKeyReleased(evt);
            }
        });
        add(RoleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 266, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Password");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 126, 44));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("Enterprise Name");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 95, 126, 45));

        EnterpriseNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EnterpriseNameTextFieldKeyReleased(evt);
            }
        });
        add(EnterpriseNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 266, 30));

        PasswordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordTextFieldKeyReleased(evt);
            }
        });
        add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 270, 30));

        eename.setForeground(new java.awt.Color(204, 0, 102));
        add(eename, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 130, -1));

        efname.setForeground(new java.awt.Color(204, 0, 102));
        add(efname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 130, -1));

        elname.setForeground(new java.awt.Color(204, 0, 102));
        add(elname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 130, -1));

        egender.setForeground(new java.awt.Color(204, 0, 102));
        add(egender, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 130, -1));

        erole.setForeground(new java.awt.Color(204, 0, 102));
        add(erole, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 130, -1));

        eemail.setForeground(new java.awt.Color(204, 0, 102));
        add(eemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void CreatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatebtnActionPerformed
        // TODO add your handling code here:
        if(EnterpriseNameTextField.getText().isEmpty() || FirstNameTextField.getText().isEmpty() ||
                LastNameTextField.getText().isEmpty() || GenderTextField.getText().isEmpty() ||
                RoleTextField.getText().isEmpty() ||
                EmailTextField.getText().isEmpty() ||
                PasswordTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inputs should not be Empty");
            return;
        }
        
        String EnterpriseName = EnterpriseNameTextField.getText();
        String FirstName = FirstNameTextField.getText();
        String LastName = LastNameTextField.getText();
        String Gender = GenderTextField.getText();
        String Role = RoleTextField.getText();
        String Email = EmailTextField.getText();        
        String Password = PasswordTextField.getText();
                
        MySQLUtil.addenterprisedetails(EnterpriseName,FirstName, LastName, Gender, Role, Email, Password);
        JOptionPane.showMessageDialog(this,"New Enterprise Added");
        clearAllFields();
    }//GEN-LAST:event_CreatebtnActionPerformed

    private void EnterpriseNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnterpriseNameTextFieldKeyReleased
        // TODO add your handling code here:
         String Allowed="^[A-Z a-z]+$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher( EnterpriseNameTextField.getText());
        if(!same.matches()){
            eename.setText("Only Alphabets allowed.");
            Createbtn.setEnabled(false);
        }
        else{
            eename.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_EnterpriseNameTextFieldKeyReleased

    private void FirstNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FirstNameTextFieldKeyReleased
        // TODO add your handling code here:
         String Allowed="^[A-Z a-z]+$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(FirstNameTextField.getText());
        if(!same.matches()){
            efname.setText("Only Alphabets allowed.");
            Createbtn.setEnabled(false);
        }
        else{
            efname.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_FirstNameTextFieldKeyReleased

    private void LastNameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LastNameTextFieldKeyReleased
        // TODO add your handling code here:
         String Allowed="^[A-Z a-z]+$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(LastNameTextField.getText());
        if(!same.matches()){
            elname.setText("Only Alphabets allowed.");
            Createbtn.setEnabled(false);
        }
        else{
            elname.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_LastNameTextFieldKeyReleased

    private void GenderTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GenderTextFieldKeyReleased
        // TODO add your handling code here:
         String Allowed="^[A-Z a-z]+$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(GenderTextField.getText());
        if(!same.matches()){
            egender.setText("Only Alphabets allowed.");
            Createbtn.setEnabled(false);
        }
        else{
            egender.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_GenderTextFieldKeyReleased

    private void RoleTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RoleTextFieldKeyReleased
        // TODO add your handling code here:
         String Allowed="^[A-Z a-z]+$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(RoleTextField.getText());
        if(!same.matches()){
            erole.setText("Only Alphabets allowed.");
            Createbtn.setEnabled(false);
        }
        else{
            erole.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_RoleTextFieldKeyReleased

    private void EmailTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailTextFieldKeyReleased
        // TODO add your handling code here:
        String Allowed="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(EmailTextField.getText());
        if(!same.matches()){
            eemail.setText("Invalid Email.");
            Createbtn.setEnabled(false);
        }
        else{
            eemail.setText(null);
            Createbtn.setEnabled(true);
        }
    }//GEN-LAST:event_EmailTextFieldKeyReleased

    private void PasswordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordTextFieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordTextFieldKeyReleased
    public void clearAllFields() {
        EnterpriseNameTextField.setText("");
        FirstNameTextField.setText("");
        LastNameTextField.setText("");
        GenderTextField.setText("");
        RoleTextField.setText("");
        EmailTextField.setText("");        
        PasswordTextField.setText("");
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Createbtn;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JTextField EnterpriseNameTextField;
    private javax.swing.JTextField FirstNameTextField;
    private javax.swing.JTextField GenderTextField;
    private javax.swing.JTextField LastNameTextField;
    private javax.swing.JPasswordField PasswordTextField;
    private javax.swing.JTextField RoleTextField;
    private javax.swing.JLabel eemail;
    private javax.swing.JLabel eename;
    private javax.swing.JLabel efname;
    private javax.swing.JLabel egender;
    private javax.swing.JLabel elname;
    private javax.swing.JLabel erole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
