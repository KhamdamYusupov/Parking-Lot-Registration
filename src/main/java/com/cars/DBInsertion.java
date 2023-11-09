package com.cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBInsertion {
    private static final String SQL_INSERT = "INSERT INTO cars (NAME, PRICE, HORSEPOWER) VALUES (?, ?, ?)";
    private Car car;

    public DBInsertion(Car car) {
        this.car = car;
    }

    public void insertCar() {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "Pshtqapipi0209");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getPrice());
            preparedStatement.setInt(3, car.getHorsePower());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.format("SQL state: %s \n %s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



