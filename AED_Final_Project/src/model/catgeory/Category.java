/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.catgeory;

/**
 *
 * @author parjita
 */
public class Category {
    private int categoryId;
    private String categoryName;
    private String Date;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Category(int categoryId, String categoryName, String Date) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.Date = Date;
    }
    
}
