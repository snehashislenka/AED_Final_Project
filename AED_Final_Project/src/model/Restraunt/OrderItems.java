/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.Restraunt;

/**
 *
 * @author Anshul
 */
public class OrderItems {
    private int orderId;
    private int itemId;
    private String item;
    private Float total;
    private int quantity;

    public OrderItems(String item, float total, int quantity) {
        this.item = item;
        this.total = total;
        this.quantity = quantity;
    }

    public OrderItems(int itemId, String item, float total, int quantity) {
        this.itemId = itemId;
        this.item = item;
        this.total = total;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
