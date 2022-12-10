/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

/**
 *
 * @author Anshul
 */
public class MenuItems {
    private int id;
    private int restrauntId;
    private String item;
    private Float price;
    private String desc;
    private String restraunt;

    public MenuItems(int restrauntId, String item, float price, String desc, String restraunt) {
        this.restrauntId = restrauntId;
        this.item = item;
        this.price = price;
        this.desc = desc;
        this.restraunt = restraunt;
    }

    public MenuItems(int id, int restrauntId, String item, float price, String desc, String restraunt) {
        this.id = id;
        this.restrauntId = restrauntId;
        this.item = item;
        this.price = price;
        this.desc = desc;
        this.restraunt = restraunt;
    }

    public MenuItems() {
   
    }

    public MenuItems(int id, String item, float price, String desc) {
        this.id = id;
        this.item = item;
        this.price = price;
        this.desc = desc;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRestraunt() {
        return restraunt;
    }

    public void setRestraunt(String restraunt) {
        this.restraunt = restraunt;
    }
    
    
    
}
