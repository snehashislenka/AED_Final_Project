/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.policy;

/**
 *
 * @author parjita
 */
public class Policy {
       private int PolicyID;
       private String PolicyName;
       private int PolicySumAssurance;
       private int PolicyPremium;
       private int PolicyTenure;
       private String PolicyDate;

    public int getPolicyID() {
        return PolicyID;
    }

    public void setPolicyID(int PolicyID) {
        this.PolicyID = PolicyID;
    }

    public String getPolicyName() {
        return PolicyName;
    }

    public void setPolicyName(String PolicyName) {
        this.PolicyName = PolicyName;
    }

    public int getPolicySumAssurance() {
        return PolicySumAssurance;
    }

    public void setPolicySumAssurance(int PolicySumAssurance) {
        this.PolicySumAssurance = PolicySumAssurance;
    }

    public int getPolicyPremium() {
        return PolicyPremium;
    }

    public void setPolicyPremium(int PolicyPremium) {
        this.PolicyPremium = PolicyPremium;
    }

    public int getPolicyTenure() {
        return PolicyTenure;
    }

    public void setPolicyTenure(int PolicyTenure) {
        this.PolicyTenure = PolicyTenure;
    }

    public String getPolicyDate() {
        return PolicyDate;
    }

    public void setPolicyDate(String PolicyDate) {
        this.PolicyDate = PolicyDate;
    }

    public Policy(int PolicyID, String PolicyName, int PolicySumAssurance, int PolicyPremium, int PolicyTenure, String PolicyDate) {
        this.PolicyID = PolicyID;
        this.PolicyName = PolicyName;
        this.PolicySumAssurance = PolicySumAssurance;
        this.PolicyPremium = PolicyPremium;
        this.PolicyTenure = PolicyTenure;
        this.PolicyDate = PolicyDate;
    }
       
       
}
