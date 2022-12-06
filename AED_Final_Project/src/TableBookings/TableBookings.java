/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableBookings;

import java.util.Date;

/**
 *
 * @author Anshul
 */
public class TableBookings {
    private int id;
    private int restrauntId;
    private int table_no;
    private int no_of_tables;
    private String status;
    private Date from;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(int restrauntId) {
        this.restrauntId = restrauntId;
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public int getNo_of_tables() {
        return no_of_tables;
    }

    public void setNo_of_tables(int no_of_tables) {
        this.no_of_tables = no_of_tables;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }
    
    
    
    
}
