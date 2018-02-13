package com.bkolomiets.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static java.lang.Class.forName;

public class ConnectionFactory {
    private static Properties properties = new Properties();
    private static Connection connection = null;
    private static FileInputStream fileInputStream;

    public static Connection getConnection() {
        try {
            fileInputStream = new FileInputStream("C://Users/Марина/IdeaProjects/online-coffee/src/main/resources/application.properties");
            properties.load(fileInputStream);

            forName(properties.getProperty("DB_DRIVER_CLASS"));

            connection = DriverManager.getConnection(
                    properties.getProperty("DB_URL"),
                    properties.getProperty("DB_USERNAME"),
                    properties.getProperty("DB_PASSWORD")
            );
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.getStackTrace();
        }
        return connection;
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
