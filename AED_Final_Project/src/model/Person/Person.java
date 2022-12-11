/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Person;

/**
 *
 * @author slenk
 */

public class Person {

    private int id;
    private String firstname;
    private String lastname;
    private String gender;
    private String role;
    private String email;
    private String password;

    public Person(int id, String firstname, String lastname, String gender, 
            String role, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.role = role;
        this.email = email;
        this.password = password;
    }
    
    public Person(int id, String firstname, String gender, String email) {
        this.id = id;
        this.firstname =firstname ;
        this.gender = gender;
        this.email =email;
    }
    
    public Person(int id, String firstname, String gender, String email, String lastname) {
        this.id = id;
        this.firstname =firstname ;
        this.gender = gender;
        this.email =email;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
