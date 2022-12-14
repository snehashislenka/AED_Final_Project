/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.HotelUser;
	import java.awt.Graphics;
	import java.awt.Image;
	import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysql.util.MySQLUtil;
import static mysql.util.MySQLUtil.connectMySQL;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.Hotel.Rooms;
import static mysql.util.MySQLUtil.connectMySQL;

/**
 *
 * @author Anshul
 */
public class RoomSelect extends javax.swing.JPanel {

    /**
     * Creates new form RoomSelects
     */
    HotelFrame hotelFrame;
    String city;
    String hotel;
    String address;
    String zipcode;
    int hotelId;
    Date checkin;
    Date checkout;
    int no_rooms;
    int room_no;
    float price;
    
    public RoomSelect(HotelFrame hotelFrame, String hotel, String address, String city, String zipcode, int hotelId, Date checkin, Date checkout, int no_rooms) {
        initComponents();
         this.hotelFrame = hotelFrame;
         this.hotel = hotel;
         this.address = address;
         this.city =city;
         this.zipcode = zipcode;
         this.hotelId =hotelId;
         this.checkin = checkin;
         this.checkout = checkout;
         this.no_rooms = no_rooms;
         
         sHotel.setText(hotel);
         sAddress.setText(address);
         sCity.setText(city);
         
    }
    
    public RoomSelect(HotelFrame hotelFrame) {
        initComponents();
         this.hotelFrame = hotelFrame;
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
        sHotel = new javax.swing.JLabel();
        sCity = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        sAddress = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g) {

                ImageIcon im = new ImageIcon("D:\\xxxxxx\\git 3\\AED_Final_Project\\AED_Final_Project\\src\\assets\\12.jpg");

                Image i = im.getImage();

                g.drawImage(i, 0, 0, this.getSize().width,
                    this.getSize().height, this);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sHotel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sHotel.setForeground(new java.awt.Color(255, 255, 255));
        sHotel.setText("Hotel Name here");
        jPanel1.add(sHotel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 350, 40));

        sCity.setForeground(new java.awt.Color(255, 255, 255));
        sCity.setText("Hotel Address here");
        jPanel1.add(sCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("12:00 PM");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 100, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Check-in");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 100, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Check-out");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 100, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("11:00 AM");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 100, 30));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 255, 51), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Free Cancelation Available");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("icon");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 30, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 300, 40));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton8.setText("???");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 50, 50));

        sAddress.setForeground(new java.awt.Color(255, 255, 255));
        sAddress.setText("Hotel Address here");
        jPanel1.add(sAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 360, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 190));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("DELUXE ROOM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 140));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 230, 160));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("PREMIUM ROOM");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 210, 140));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Select");
        jPanel6.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 230, 160));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setText("Select");
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setText("Select");
        jPanel8.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 230, 160));

        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 230, 160));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 230, 160));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setText("SUITE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 210, 140));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 230, 160));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setText("PRESEDENTIAL SUITE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 210, 140));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 230, 160));

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.hotelFrame.switchPanel(new SearchHotel(this.hotelFrame));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        deluxe
        String roomName = "DELUXE";
        
        long diffInMillies = Math.abs(checkin.getTime() - checkout.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("diff-----"+days);
        
        getPrice(roomName);
        System.out.println("price-----"+room_no+price);
        
        this.hotelFrame.switchPanel(new Checkout(this.hotelFrame, hotel,address,city,zipcode,hotelId,checkin,checkout,no_rooms,room_no,price,days, roomName));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
//        suite
        String roomName = "KING SUITE";
        
        long diffInMillies = Math.abs(checkin.getTime() - checkout.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("diff-----"+days);
        
        getPrice(roomName);
        System.out.println("price-----"+room_no+price);
        
        this.hotelFrame.switchPanel(new Checkout(this.hotelFrame, hotel,address,city,zipcode,hotelId,checkin,checkout,no_rooms,room_no,price,days, roomName));
    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//        presedential
        String roomName = "PRESIDENTIAL SUITE"; 
        long diffInMillies = Math.abs(checkin.getTime() - checkout.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("diff-----"+days);
        
        getPrice(roomName);
        System.out.println("price-----"+room_no+price);
        
        this.hotelFrame.switchPanel(new Checkout(this.hotelFrame, hotel,address,city,zipcode,hotelId,checkin,checkout,no_rooms,room_no,price,days, roomName));
    
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        premium
        String roomName = "PREMIUM"; 
        long diffInMillies = Math.abs(checkin.getTime() - checkout.getTime());
        long days = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        System.out.println("diff-----"+days);
        
        getPrice(roomName);
        System.out.println("price-----"+room_no+price);
        
        this.hotelFrame.switchPanel(new Checkout(this.hotelFrame, hotel,address,city,zipcode,hotelId,checkin,checkout,no_rooms,room_no,price,days, roomName));
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getPrice(String room){
        String query = "Select r.room_no, r.price from rooms r inner join hotel_bookings h on r.hotelId = h.hotelId where r.type like CONCAT('%', ?, '%') and r.hotelId = ? and (h.status = 'CHECKED-OUT' or r.status = 'AVAILABLE') LIMIT 1";
         try {
            Connection conn = connectMySQL();
            PreparedStatement ps = conn.prepareStatement(query); 
            
            ps.setString(1, room);
            ps.setInt(2,hotelId);
            
            ResultSet rs = ps.executeQuery();   
            
            if(rs.next()){
                room_no = rs.getInt("room_no");
                price = rs.getFloat("price");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sAddress;
    private javax.swing.JLabel sCity;
    private javax.swing.JLabel sHotel;
    // End of variables declaration//GEN-END:variables
}
