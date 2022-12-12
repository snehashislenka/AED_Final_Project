/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.userdashboard;

import ui.SystemAdminPanel.SystemAdmin_Dashboard;
import auth.AuthenticationUtil;
import java.awt.Color;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mysql.util.MySQLUtil;
import model.Person.Person;
import ui.Hotel.HotelFrame;
import ui.InsuranceManagment.TravelInsuranceAdmin_Dashboard;
import ui.Restraunt.RestrauntFrame;
import ui.busAdminDashboard.BusAdminDashboard;
import ui.carRentalAdminPanels.CarRentalAdminFrame;
import ui.flightAdminDashboard.FlightAdminDashboard;
import ui.lifestyle.LifestyleFrame;
import ui.rentalAdmin.RentalAdminFrame;
import ui.travelAdmin.TravelAdminDashboard;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author slenk
 */
public class Signin extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Signin() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        MySQLUtil.removePersonSession();
        panelUserSignin.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.6f));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            public void paintComponent(Graphics g) {

                ImageIcon im = new ImageIcon("D:\\xxxxxx\\git 3\\AED_Final_Project\\AED_Final_Project\\src\\assets\\bg-signin1.jpg");

                Image i = im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width,
                    this.getSize().height, this);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        panelUserSignin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSignin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRAVEL MANAGEMENT SYSTEM");

        panelUserSignin.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sign in");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Email");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Password");

        btnSignin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignin.setText("Sign in");
        btnSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSigninActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Create an account");

        btnSignup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSignup.setText("Sign up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUserSigninLayout = new javax.swing.GroupLayout(panelUserSignin);
        panelUserSignin.setLayout(panelUserSigninLayout);
        panelUserSigninLayout.setHorizontalGroup(
            panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserSigninLayout.createSequentialGroup()
                .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelUserSigninLayout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserSigninLayout.createSequentialGroup()
                            .addGap(92, 92, 92)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordField)
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                    .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUserSigninLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnSignin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(92, 92, 92))
        );
        panelUserSigninLayout.setVerticalGroup(
            panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUserSigninLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelUserSigninLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSignup, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(panelUserSignin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(panelUserSignin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSigninActionPerformed
        String email = lblEmail.getText().trim();

        String Allowed="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern patt = Pattern.compile(Allowed);
        Matcher same = patt.matcher(email);

        if(!same.matches()){
            JOptionPane.showMessageDialog(this, "Please enter valid email!");
            lblEmail.setText("");
            return;
        }

        char[] password = passwordField.getPassword();
        String pass = new String(password);

        boolean isAuthenticated = AuthenticationUtil.authenticateUser(email, pass);
        if(!isAuthenticated) {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        } else {
            JOptionPane.showMessageDialog(this, "Sign in successful!");
            Person person = MySQLUtil.getPerson(email);

            MySQLUtil.savePersonSession(person.getId(), person.getRole());

            dispose();
            switch (person.getRole()) {
                case "PASSENGER":
                Dashboard dashboard = new Dashboard();
                dashboard.setVisible(true);
                break;
                case "SYSTEM_ADMIN":
                SystemAdmin_Dashboard systemAdminDashboard =
                new SystemAdmin_Dashboard();
                systemAdminDashboard.setVisible(true);
                break;

                case "INSURANCE_ADMIN":
                TravelInsuranceAdmin_Dashboard ia_dash = new
                TravelInsuranceAdmin_Dashboard();
                ia_dash.setVisible(true);
                break;

                case "LIFESTYLE_ADMIN":
                LifestyleFrame lifeStyleFrame = new
                LifestyleFrame();
                lifeStyleFrame.setVisible(true);
                break;

                case "HOTEL_ADMIN":
                HotelFrame hotelFrame = new HotelFrame();
                hotelFrame.setVisible(true);
                break;

                case "RESTRAUNT_ADMIN":
                RestrauntFrame restrauntFrame = new RestrauntFrame();
                restrauntFrame.setVisible(true);
                break;

                case "TRAVEL_ADMIN":
                TravelAdminDashboard travelAdminDashboard = new TravelAdminDashboard();
                travelAdminDashboard.setVisible(true);
                break;

                case "FLIGHT_ADMIN":
                FlightAdminDashboard flightAdminDashboard = new FlightAdminDashboard();
                flightAdminDashboard.setVisible(true);
                break;

                case "BUS_ADMIN":
                BusAdminDashboard busAdminDashboard =
                new BusAdminDashboard();
                busAdminDashboard.setVisible(true);
                break;

                case "CAR_RENTAL_ADMIN":
                CarRentalAdminFrame carRentalAdmin =
                new CarRentalAdminFrame();
                carRentalAdmin.setVisible(true);
                break;

                case "RENTAL_ADMIN":
                RentalAdminFrame rentalAdmin =
                new RentalAdminFrame();
                rentalAdmin.setVisible(true);
                break;

                default:
                break;
            }
        }
    }//GEN-LAST:event_btnSigninActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        Signup signupPanel = new Signup();
        signupPanel.setVisible(true);
    }//GEN-LAST:event_btnSignupActionPerformed

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
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignin;
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lblEmail;
    private javax.swing.JPanel panelUserSignin;
    private javax.swing.JPasswordField passwordField;
    // End of variables declaration//GEN-END:variables
}
