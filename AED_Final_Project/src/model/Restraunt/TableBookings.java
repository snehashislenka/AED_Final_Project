/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

import java.util.Date;

/**
 *
 * @author Anshul
 */
public class TableBookings {
    private int id;
    private int restrauntId;
    private int table_no;
    private String restraunt;
    private String status;
    private Date from;

    public TableBookings(int id, int restrauntId, int table_no, String restraunt, String status, java.sql.Date from) {
        this.id = id;
        this.restrauntId = restrauntId;
        this.table_no = table_no;
        this.restraunt = restraunt;
        this.status = status;
        this.from = from;
        
    }
    

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

    public String getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(String restraunt) {
        this.restraunt = restraunt;
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
