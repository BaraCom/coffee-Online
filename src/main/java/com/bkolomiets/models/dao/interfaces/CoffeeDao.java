package com.bkolomiets.models.dao.interfaces;

import com.bkolomiets.models.entity.Coffee;

import java.util.List;

public interface CoffeeDao {
    List<Coffee> getCoffeeList();
}
