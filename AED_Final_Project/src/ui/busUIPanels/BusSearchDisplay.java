/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.busUIPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import model.bus.Bus;
import mysql.util.MySQLUtil;
import org.xml.sax.SAXException;
import ui.flightUIPanels.CallFlightUIPanels;
import ui.userdashboard.FlightDispalyUILabels;
import util.flights.FlightUtils;

/**
 *
 * @author slenk
 */
public class BusSearchDisplay extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    
    String departureCity;
    String arrivalCity;
    String departureDate;
//    private String arrivalDate;
    int passenger;
    
    public BusSearchDisplay(String departureCity, String arrivalCity, 
        String departureDate,int passenger) throws IOException, 
            InterruptedException, ParserConfigurationException, SAXException {
        initComponents();
        
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDate = departureDate;
//        this.arrivalDate = arrivalDate;
        this.passenger = passenger;
        
        this.setBackground(new Color(1f, 1f, 1f, 0.2f));
        
        populateBusSearchPane();
    }
    
    public void populateBusSearchPane() throws IOException, InterruptedException, 
            ParserConfigurationException, SAXException {
        
        ArrayList<Bus> busSearchList = MySQLUtil
                .getListOfBusSearch(this.departureCity, this.arrivalCity);
                
        setLayout(new GridLayout(busSearchList.size(), 3, 0, 0));     
        for(Bus bus: busSearchList) {
            
            System.out.println(bus.getDepartureBusStation());
            
            for (int j=0; j<3; j++) {
                JLabel lbl = new JLabel();
                if(j == 0) {
                    lbl.setText(BusDisplayUILabels.getHTMLBusScheduleCode(bus.getBusId()
                            ,departureDate,
                            bus.getDepartingTimestamp(),
                    bus.getArrivalTimestamp(), bus.getDepartingCity(),
                    bus.getArrivalCity(), bus.getBusCompanyName()));
                }
                else if(j == 1) {
                    lbl.setText(BusDisplayUILabels.getHTMLBusDurationCode(
                            bus.getBusTotalDuration()));
                } else {
                    lbl.setText(BusDisplayUILabels.getHTMLBusPriceCode(
                            this.passenger, bus.getPrice()));
                    Component comp = this;
                    lbl.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            BusSeatSelection busSeatSelection = 
                                    new BusSeatSelection(passenger, bus, departureDate);
                            busSeatSelection.setVisible(true);
                        }
                    });
                }
                lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.add(lbl); 
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
