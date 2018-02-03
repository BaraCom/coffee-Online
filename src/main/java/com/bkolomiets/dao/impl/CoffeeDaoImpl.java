package com.bkolomiets.dao.impl;

import com.bkolomiets.dao.interfaces.CoffeeDao;
import com.bkolomiets.entity.Coffee;
import sun.awt.util.IdentityLinkedList;
import java.util.List;

public class CoffeeDaoImpl implements CoffeeDao {
    @Override
    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new IdentityLinkedList<>();
        coffeeList.add(new Coffee("Latte", 24));
        coffeeList.add(new Coffee("Cappuccino", 70));

        return coffeeList;
    }

    @Override
    public double getPriceByType(String coffeeType) {
        double price = 0;

        for (Coffee coffee : getCoffeeList()) {
            if (coffee.getType().contains(coffeeType)) {
                price = coffee.getPrice();
            }
        }

        return price;
    }
}
