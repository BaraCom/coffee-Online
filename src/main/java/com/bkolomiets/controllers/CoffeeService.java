package com.bkolomiets.controllers;

import com.bkolomiets.models.dao.impl.CoffeeDaoImpl;
import com.bkolomiets.models.entity.Coffee;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.lang.Double.parseDouble;

@ManagedBean(eager = true)
@ApplicationScoped
public class CoffeeService {
    private List<Coffee> orderCoffeeList = new ArrayList<>();
    private int COUNT_CUPS = 1;

    private Map<String, String> getCoffeeParam() {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
    }

    public void addingToTheOrderList() {
        Coffee newCoffeeObj = null;

        Map<String, String> coffeeParam = getCoffeeParam();
        String coffeeType = coffeeParam.get("type");
        double coffeePrice = parseDouble(coffeeParam.get("price"));

        for (Coffee coffee : orderCoffeeList) {
            if (isContainsList(coffee, coffeeType)) {
                newCoffeeObj = coffee;
                break;
            }
        }

        if (newCoffeeObj == null) {
            orderCoffeeList.add(new Coffee(coffeeType, coffeePrice, COUNT_CUPS));
        } else {
            double price = newCoffeeObj.getPrice() + 100;
            int countCups1 = newCoffeeObj.getCountCups() + COUNT_CUPS;
            newCoffeeObj.setPrice(price);
            newCoffeeObj.setCountCups(countCups1);
            int index = orderCoffeeList.indexOf(newCoffeeObj);
            orderCoffeeList.set(index, newCoffeeObj);
        }
    }

    private boolean isContainsList(Coffee coffee, String coffeeType) {
        return coffee.getType().contains(coffeeType);
    }

    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new LinkedList<>();
        coffeeList.addAll(new CoffeeDaoImpl().getCoffeeList());

        return coffeeList;
    }

    public int getCountCups() {
        return COUNT_CUPS;
    }

    public void setCountCups(int countCups) {
        COUNT_CUPS = countCups;
    }

    public List<Coffee> getOrderCoffeeList() {
        return orderCoffeeList;
    }
}
