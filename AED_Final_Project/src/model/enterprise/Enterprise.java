/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.enterprise;

/**
 *
 * @author parjita
 */
public class Enterprise {
    private String EnterpriseName;
    private int AdminID;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Role;
    private String Email;    
    private String Password;

    public Enterprise(String EnterpriseName,int AdminID, String FirstName, String LastName, String Gender, String Role,String Email, String Password) {
        this.EnterpriseName = EnterpriseName;
        this.AdminID = AdminID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Role = Role;
        this.Email = Email;       
        this.Password = Password;
    }

    public Enterprise(int AdminID,String EnterpriseName,String Email) {
        this.AdminID = AdminID;
        this.EnterpriseName = EnterpriseName;              
        this.Email = Email;       
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int AdminID) {
        this.AdminID = AdminID;
    }
    
    public String getEnterpriseName() {
        return EnterpriseName;
    }

    public void setEnterpriseName(String EnterpriseName) {
        this.EnterpriseName = EnterpriseName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    
    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }    

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
    
    
}
