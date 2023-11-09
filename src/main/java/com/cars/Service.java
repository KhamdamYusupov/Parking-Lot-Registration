package com.cars;

public class Service {

    public Service() {
        Car car = new CarRegistration().registerCar();
        new DBInsertion(car).insertCar();
    }
}
