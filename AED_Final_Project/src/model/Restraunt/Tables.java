/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

/**
 *
 * @author Anshul
 */
public class Tables {
    private int table_no;
    private int restrauntId;
    private String restraunt;
    private String status;

    public Tables(int table_no, String status, int restrauntId, String restraunt) {
        this.table_no = table_no;
        this.status = status;
        this.restrauntId =restrauntId;
        this.restraunt = restraunt;
    }

    public int getTable_no() {
        return table_no;
    }

    public void setTable_no(int table_no) {
        this.table_no = table_no;
    }

    public int getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(int restrauntId) {
        this.restrauntId = restrauntId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(String restraunt) {
        this.restraunt = restraunt;
    }
    
    
}
