/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package policystatus;

/**
 *
 * @author parjita
 */
public class Policystatus {
    private int personID;
    private String personName;
    private int policyID;
    private String policyName;
    private String category;
    private int sumassurance;
    private int premium;
    private int tenure;
    private String appliedDate;
    private String status;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPolicyID() {
        return policyID;
    }

    public void setPolicyID(int policyID) {
        this.policyID = policyID;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSumassurance() {
        return sumassurance;
    }

    public void setSumassurance(int sumassurance) {
        this.sumassurance = sumassurance;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Policystatus(int personID, String personName, int policyID, String policyName, String category, int sumassurance, int premium, int tenure, String appliedDate, String status) {
        this.personID = personID;
        this.personName = personName;
        this.policyID = policyID;
        this.policyName = policyName;
        this.category = category;
        this.sumassurance = sumassurance;
        this.premium = premium;
        this.tenure = tenure;
        this.appliedDate = appliedDate;
        this.status = status;
    }
    
}
