package com.bkolomiets.models.dao.impl;

import com.bkolomiets.models.dao.interfaces.CoffeeDao;
import com.bkolomiets.models.entity.Coffee;
import sun.awt.util.IdentityLinkedList;
import java.util.List;

public class CoffeeDaoImpl implements CoffeeDao {
    @Override
    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new IdentityLinkedList<>();
        coffeeList.add(new Coffee("Latte", 24, 1));
        coffeeList.add(new Coffee("Cappuccino", 70, 1));

        return coffeeList;
    }
}
