package com.bkolomiets.services;

import com.bkolomiets.dao.impl.CoffeeDaoImpl;
import com.bkolomiets.entity.Coffee;
import com.bkolomiets.entity.CoffeeOrder;
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
public class  CoffeeService {
    private static final String COFFEE_TYPE = "type";
    private static final String COFFEE_PRICE = "price";
    private List<CoffeeOrder> orderCoffeeList = new ArrayList<>();
    private int countCupsSpinner = new CoffeeOrder().getCountCups();

    public double getTotalPrice() {
        double totalPrice = 0;

        for (CoffeeOrder coffee : orderCoffeeList) {
            totalPrice += coffee.getPrice();
        }

        return totalPrice;
    }

    public void addingToTheOrderList() {
        CoffeeOrder newCoffeeOrder = null;

        Map<String, String> coffeeParam = getCoffeeParam();
        String coffeeType = coffeeParam.get(COFFEE_TYPE);
        double coffeePrice = parseDouble(coffeeParam.get(COFFEE_PRICE));

        for (CoffeeOrder coffeeOrder : orderCoffeeList) {
            if (isContainsList(coffeeOrder, coffeeType)) {
                newCoffeeOrder = coffeeOrder;

                break;
            }
        }

        if (newCoffeeOrder == null) {
            coffeePrice *= countCupsSpinner;
            orderCoffeeList.add(new CoffeeOrder(coffeeType, coffeePrice, countCupsSpinner));
        } else {
            updatingOrderData(newCoffeeOrder, coffeeType);
        }
    }

    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new LinkedList<>();
        coffeeList.addAll(new CoffeeDaoImpl().getCoffeeList());

        return coffeeList;
    }

    public int getCountCups() {
        return countCupsSpinner;
    }

    public void setCountCups(int countCups) {
        countCupsSpinner = countCups;
    }

    public List<CoffeeOrder> getOrderCoffeeList() {
        return orderCoffeeList;
    }

    private Map<String, String> getCoffeeParam() {
        return FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
    }

    private void updatingOrderData(CoffeeOrder newCoffeeOrder, String coffeeType) {
        double standardPrice = new CoffeeDaoImpl().getPriceByType(coffeeType);

        double price = newCoffeeOrder.getPrice() + standardPrice * countCupsSpinner;
        int countCups = newCoffeeOrder.getCountCups() + countCupsSpinner;
        int index = orderCoffeeList.indexOf(newCoffeeOrder);

        newCoffeeOrder.setPrice(price);
        newCoffeeOrder.setCountCups(countCups);

        orderCoffeeList.set(index, newCoffeeOrder);
    }

    private boolean isContainsList(Coffee coffee, String coffeeType) {
        return coffee.getType().contains(coffeeType);
    }
}
