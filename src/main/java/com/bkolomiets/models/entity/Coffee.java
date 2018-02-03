package com.bkolomiets.models.entity;

public class Coffee {
    private String type;
    private double price;
    private int countCups;

    public Coffee(String type, double price, int countCups) {
        this.type = type;
        this.price = price;
        this.countCups = countCups;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getCountCups() {
        return countCups;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCountCups(int countCups) {
        this.countCups = countCups;
    }
}
