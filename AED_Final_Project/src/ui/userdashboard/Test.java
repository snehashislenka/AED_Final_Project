/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.userdashboard;

import java.util.Date;
import mysql.util.MySQLUtil;

/**
 *
 * @author slenk
 */
public class Test {
    public static void main(String[] args) {
            String date = "Tue Dec 13 00:00:00 EST 2022";
            String x = "2022-12-22T06:00:00";
            System.out.println(x.substring(0, 10));
            
            String[] mmArr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            int mm = 0;
            System.out.println(date.substring(4, 7));
            for(int i=0; i<mmArr.length; i++) {
                if(mmArr[i].equals(date.substring(4, 7))) {
                    mm = ++i;
                }
            }
            
            String dd = date.substring(8, 10);
            String yyyy = date.substring(24, 28);
            System.out.println(yyyy+"-"+mm+"-"+dd);

    }
}
