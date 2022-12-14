/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.flightUIPanels;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Flight.Flight;
import mysql.util.MySQLUtil;
import model.Person.Person;

/**
 *
 * @author slenk
 */
public class BookFlightDetails extends javax.swing.JFrame {

    /**
     * Creates new form FlightBooking
     */
    
    Flight selectedFlight;
    ArrayList<String> seatList;
    
    
    public BookFlightDetails() {
        initComponents();
    }
    
    public BookFlightDetails(Flight flight, ArrayList<String> seatList) {
        initComponents();
        this.selectedFlight = flight;
        this.seatList = seatList;
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.out.println(flight.getFlightCompanyName());
        populateFlightBookingFrame();
    }
    
    public void populateFlightBookingFrame() {
        String departureDate = formattedDate(this.selectedFlight.getDepartingTimeStamp());
        String departingTime = selectedFlight.getDepartingTimeStamp().substring(11);
        String arrivalDate = formattedDate(this.selectedFlight.getArrivalTimeStamp());
        String arrivalTime = selectedFlight.getArrivalTimeStamp().substring(11);
        String flightName = selectedFlight.getFlightCompanyCode()
                + "-" + selectedFlight.getFlightType() + " "
                + selectedFlight.getFlightCompanyName();
        String seats = "";
        for(String seat: this.seatList) {
            seats = seats + seat + ", ";
        }
        seats = seats.substring(0, seats.length() - 2);
        Double price = this.seatList.size() * selectedFlight.getPrice();
        
        Person person = MySQLUtil.getPersonSession();
        
        lblPassengerName.setText(person.getFirstname() + " " + person.getLastname());
        
        lblDepartureCity.setText(selectedFlight.getDepartingCity());
        lblDepartureDate.setText(departureDate);
        lblDepartureTime.setText(departingTime);
        lblDepartureAirport.setText(selectedFlight.getDepartureAirport());
        lblDepartureTerminal.setText(selectedFlight.getDepartureTerminal());
            
        lblArrivalCity.setText(selectedFlight.getArrivalCity());
        lblArrivalDate.setText(arrivalDate);
        lblArrivalTime.setText(arrivalTime);
        lblArrivalAirport.setText(selectedFlight.getArrivalAirport());
        lblArrivalTerminal.setText(selectedFlight.getArrivalTerminal());
        
        lblFlightName.setText(flightName);
        lblFlightDuration.setText(selectedFlight.getTotalFlightDuration().substring(2));
        lblTotalMiles.setText(String.valueOf(selectedFlight.getTotalMiles() + " Miles"));
        lblSeats.setText(seats);
        lblTotalPrice.setText(price.toString());
    }
    
    private String formattedDate(String dateTimestamp) {
        int month = 0;
        String day = "";
        String year = "";
        StringBuilder stb = new StringBuilder(dateTimestamp);
        year = stb.substring(0, 4);
        month = Integer.parseInt(stb.substring(5, 7));
        day = stb.substring(8, 10);
        
        String[] monthNames = {"Jan","Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
        "Sep", "Oct", "Nov", "Dec"};
        
        return day + " " + monthNames[--month] + ", " + year;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblPassengerName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDepartureCity = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblDepartureDate = new javax.swing.JLabel();
        lblDepartureTime = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblDepartureAirport = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblDepartureTerminal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblArrivalCity = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblArrivalDate = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblArrivalTime = new javax.swing.JLabel();
        lblArrivalAirport = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblArrivalTerminal = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblFlightName = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblFlightDuration = new javax.swing.JLabel();
        lblTotalMiles = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblSeats = new javax.swing.JLabel();
        btnBookTicket = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BOOK FLIGHT");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Name");

        lblPassengerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPassengerName.setText("John Doe");

        jLabel4.setText("Departure City");

        lblDepartureCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDepartureCity.setText("Departure City");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Departure Details");

        jLabel6.setText("Departure Date");

        lblDepartureDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDepartureDate.setText("Departure Date");

        lblDepartureTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDepartureTime.setText("Departure Time");

        jLabel9.setText("Departure Time");

        jLabel10.setText("Departure Airport");

        lblDepartureAirport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDepartureAirport.setText("Departure Airport");

        jLabel12.setText("Departure Terminal");

        lblDepartureTerminal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDepartureTerminal.setText("Departure Terminal");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Arrival Details");

        jLabel16.setText("Arrival City");

        lblArrivalCity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArrivalCity.setText("Arrival City");

        jLabel18.setText("Arrival Date");

        lblArrivalDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArrivalDate.setText("Arrival Date");

        jLabel20.setText("Arrival Time");

        lblArrivalTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArrivalTime.setText("Arrival Time");

        lblArrivalAirport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArrivalAirport.setText("Arrival Airport");

        jLabel23.setText("Arrival Airport");

        jLabel24.setText("Arrival Terminal");

        lblArrivalTerminal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblArrivalTerminal.setText("Arrival Terminal");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setText("Flight Details");

        jLabel27.setText("Flight Name");

        lblFlightName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFlightName.setText("Flight Name");

        jLabel29.setText("Flight Duration");

        lblFlightDuration.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFlightDuration.setText("Flight Duration");

        lblTotalMiles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalMiles.setText("Total Miles");

        jLabel32.setText("Total Miles");

        jLabel33.setText("Seats");

        lblSeats.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSeats.setText("Seats");

        btnBookTicket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookTicket.setText("BOOK TICKET");
        btnBookTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookTicketActionPerformed(evt);
            }
        });

        jLabel35.setText("Total Price");

        lblTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalPrice.setText("Total Price");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblArrivalAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblArrivalCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblArrivalTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblArrivalTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblDepartureAirport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(lblPassengerName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblDepartureDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblDepartureCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDepartureTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblDepartureTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblFlightDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblTotalMiles, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnBookTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblFlightName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblPassengerName))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDepartureCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDepartureDate)
                    .addComponent(jLabel9)
                    .addComponent(lblDepartureTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblDepartureAirport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblDepartureTerminal))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblArrivalCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblArrivalDate)
                    .addComponent(jLabel20)
                    .addComponent(lblArrivalTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblArrivalAirport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lblArrivalTerminal))
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(lblFlightName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblFlightDuration)
                    .addComponent(jLabel32)
                    .addComponent(lblTotalMiles))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblSeats))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblTotalPrice))
                .addGap(40, 40, 40)
                .addComponent(btnBookTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookTicketActionPerformed
        
        String seats = "";
        for(String seat: this.seatList) {
            seats = seats + seat + ", ";
        }
        seats = seats.substring(0, seats.length() - 2);
        
        Person person = MySQLUtil.getPersonSession();
        
        try {
            MySQLUtil.addFlightBooking(this.selectedFlight.getFlightId(), person.getId(),
                seats, this.seatList.size() * selectedFlight.getPrice(), "BOOKED");
            JOptionPane.showMessageDialog(this, "Flight Booked");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Issue with insertion!");
        }
        
        
    }//GEN-LAST:event_btnBookTicketActionPerformed

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
            java.util.logging.Logger.getLogger(BookFlightDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookFlightDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookFlightDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookFlightDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookFlightDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblArrivalAirport;
    private javax.swing.JLabel lblArrivalCity;
    private javax.swing.JLabel lblArrivalDate;
    private javax.swing.JLabel lblArrivalTerminal;
    private javax.swing.JLabel lblArrivalTime;
    private javax.swing.JLabel lblDepartureAirport;
    private javax.swing.JLabel lblDepartureCity;
    private javax.swing.JLabel lblDepartureDate;
    private javax.swing.JLabel lblDepartureTerminal;
    private javax.swing.JLabel lblDepartureTime;
    private javax.swing.JLabel lblFlightDuration;
    private javax.swing.JLabel lblFlightName;
    private javax.swing.JLabel lblPassengerName;
    private javax.swing.JLabel lblSeats;
    private javax.swing.JLabel lblTotalMiles;
    private javax.swing.JLabel lblTotalPrice;
    // End of variables declaration//GEN-END:variables
}
