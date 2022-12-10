/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.booking;

/**
 *
 * @author parjita
 */
public class PolicyBooking {
    private int BookingID;
    private int PolicyID;
    private int PersonID;
    private String PolicyName;
    private String AppliedDate;
    private String Status;

   public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int BookingID) {
        this.BookingID = BookingID;
    }

    public int getPolicyID() {
        return PolicyID;
    }

    public void setPolicyID(int PolicyID) {
        this.PolicyID = PolicyID;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getAppliedDate() {
        return AppliedDate;
    }

    public void setAppliedDate(String AppliedDate) {
        this.AppliedDate = AppliedDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    public String getPolicyName() {
        return PolicyName;
    }

    public void setPolicyName(String PolicyName) {
        this.PolicyName = PolicyName;
    }

    public PolicyBooking(int BookingID, int PolicyID, int PersonID, String AppliedDate,String PolicyName, String Status) {
        this.BookingID = BookingID;
        this.PolicyID = PolicyID;
        this.PersonID = PersonID;
        this.PolicyName = PolicyName;
        this.AppliedDate = AppliedDate;
        this.Status = Status;
    }
}
