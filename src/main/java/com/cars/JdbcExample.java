package com.cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExample {
    public static void main(String[] args) {
        System.out.println("PostgreSQl JDBC connecting ..... ha-ha");

        List<Car> carList = new ArrayList<>();
        String SQL_QUERY = "SELECT * FROM cars";

        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "Pshtqapipi0209");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                long id = resultSet.getLong("ID");
                String name = resultSet.getString("NAME");
                int price = resultSet.getInt("PRICE");
                int horsepower = resultSet.getInt("HORSEPOWER");

                Car obj = new Car();
                obj.setId(id);
                obj.setName(name);
                obj.setPrice(price);
                obj.setHorsePower(horsepower);

                carList.add(obj);
            }
            carList.forEach(System.out::println);

        } catch (SQLException e) {
          throw new RuntimeException(e);
        } catch(Exception e){
            e.printStackTrace();

        }
    }
}

