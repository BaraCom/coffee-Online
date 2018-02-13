package com.bkolomiets.dao.impl;

import com.bkolomiets.dao.interfaces.CoffeeDao;
import com.bkolomiets.entity.Coffee;
import com.bkolomiets.utils.ConnectionFactory;
import sun.awt.util.IdentityLinkedList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.bkolomiets.utils.ConnectionFactory.closeConnection;
import static com.bkolomiets.utils.ConnectionFactory.closeStatement;
import static com.bkolomiets.utils.ConnectionFactory.getConnection;

public class CoffeeDaoImpl implements CoffeeDao {
    @Override
    public List<Coffee> getCoffeeList() {
        List<Coffee> coffeeList = new IdentityLinkedList<>();
        Connection connection = getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coffeetype");

            while (resultSet.next()) {
                coffeeList.add(
                    new Coffee(
                        resultSet.getString("type"),
                        resultSet.getDouble("price")
                    )
                );
            }
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            closeStatement(statement);
            closeConnection(connection);
        }

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
