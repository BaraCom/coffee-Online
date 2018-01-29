package com.bkolomiets.controllers;

import com.bkolomiets.models.dao.impl.CoffeeDaoImpl;
import com.bkolomiets.models.entity.Coffee;
import sun.awt.util.IdentityLinkedList;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean(name = "coffee")
public class CoffeeService {
    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new IdentityLinkedList<>();
        coffeeList.addAll(new CoffeeDaoImpl().getCoffeeList());

        return coffeeList;
    }
}
