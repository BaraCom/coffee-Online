package com.bkolomiets.entity;

public class CoffeeOrder extends Coffee {
    private int countCups;
    private double totalPrice;

    public CoffeeOrder() {}

    public CoffeeOrder(String type, double price, int countCups) {
        super(type, price);

        this.countCups = countCups;
    }

    public int getCountCups() {
        return countCups;
    }

    public void setCountCups(int countCups) {
        this.countCups = countCups;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
