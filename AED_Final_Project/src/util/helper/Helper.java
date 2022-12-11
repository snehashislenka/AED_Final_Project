/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.helper;

import java.util.Date;

/**
 *
 * @author slenk
 */
public class Helper {
    
    public static String getFormattedDateForFlightAPI(Date date) {
        String formattedDate = date.toString();
        String day = formattedDate.substring(8, 10);
        String[] monthArray = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        String mm = formattedDate.substring(4,7);
        int month = 0;
        for(int i=0; i<monthArray.length; i++) {
            if(monthArray[i].equals(mm)) {
                month = i;
            }
        }
        month++;
        
        String monthFormat = "";
        
        if(month < 10) monthFormat = "0" + month;
        else monthFormat = String.valueOf(month);
        
        String year = formattedDate.substring(24, 28);
        
        return year+month+day;
    }
}
