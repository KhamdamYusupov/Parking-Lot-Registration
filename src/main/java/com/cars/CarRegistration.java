package com.cars;

import lombok.Data;
import java.util.Scanner;

@Data
public class CarRegistration {
    private Car car;


    Scanner scanner = new Scanner(System.in);

    public Car registerCar() {
        System.out.println("***CAR REGISTRATION FORM***");
        System.out.println("Enter the car model:");
        String name = scanner.nextLine();
        System.out.println("Enter the price of the car:");
        int price = scanner.nextInt();
        System.out.println("Enter the horsepower of the car:");
        int horsePower = scanner.nextInt();
        car = Car.builder()
                .name(name)
                .price(price)
                .horsePower(horsePower)
                .build();
        return car;
    }
}
