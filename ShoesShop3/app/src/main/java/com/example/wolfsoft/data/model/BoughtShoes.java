package com.example.wolfsoft.data.model;

import java.io.Serializable;

public class BoughtShoes implements Serializable {
    private String name;
    private int quantity;
    private String seller;
    private double price;

    public BoughtShoes(String name, int quantity, String seller, double price) {
        this.name = name;
        this.quantity = quantity;
        this.seller = seller;
        this.price = price;
    }

    public BoughtShoes() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
