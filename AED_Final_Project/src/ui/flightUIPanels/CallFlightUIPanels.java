/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.flightUIPanels;

import model.Flight.Flight;

/**
 *
 * @author slenk
 */
public class CallFlightUIPanels {
    public static void callFlightUIPanels(int passenger, Flight flight) {
        FlightSeatSelection flightSeatSelectionFrame = 
                new FlightSeatSelection(passenger, flight);
        flightSeatSelectionFrame.setVisible(true);
    }
}
