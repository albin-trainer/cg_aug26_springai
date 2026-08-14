package com.cg.entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
    private int id;
    private String productName;
    private float price;
    private float rating;
    public Product() {
    }
    public Product(int id, String productName, float price, float rating) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    
}
