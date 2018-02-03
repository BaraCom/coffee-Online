package com.bkolomiets.dao.interfaces;

import com.bkolomiets.entity.Coffee;
import java.util.List;

public interface CoffeeDao {
    List<Coffee> getCoffeeList();

    double getPriceByType(String coffeeType);
}
