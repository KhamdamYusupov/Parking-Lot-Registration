package com.cars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCar {
    private static final String SQL_INSERT = "INSERT INTO cars (NAME, PRICE, HORSEPOWER) VALUES (?, ?, ?)";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "Pshtqapipi0209");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {
            preparedStatement.setString(1, "KIA");
            preparedStatement.setInt(2, 25000);
            preparedStatement.setInt(3, 120);
            int rowsAffected = preparedStatement.executeUpdate();

            //how many rows have changed
            System.out.println(rowsAffected);


        } catch (SQLException e) {
            System.err.format("SQL state: %s \n %s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



