package com.bkolomiets.models.entity;

public class Coffee {
    private String type;
    private double price;

    public Coffee(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
