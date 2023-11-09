package com.cars;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static String response = "";
    public static void main(String[] args) {
        welcome();
        System.out.println("If you want to quit, please enter 'Q': ");
        response = scanner.nextLine();
        if(response.equalsIgnoreCase("q"))
        welcome();
    }

    private static void welcome() {

        System.out.println("* * * WELCOME TO DAILY PARK SPOT!!! * * * \n If you want to register new car, " + "please enter 'Y' or \n you want to see registered car's list enter 'L':");
        response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            new Service();
            System.out.println("YOUR CAR HAS BEEN SUCCESSFULLY REGISTERED!!! \n you want to see registered car's list enter 'L':");
            response = scanner.nextLine();
            if (response.equalsIgnoreCase("l")) {
                new DBListFetch().printListOfCars();
                System.out.println("Thank you for using our service!!!");
            } else {
                System.out.println("Thank you for using our service!!!");
            }
        }
        else if (response.equalsIgnoreCase("l")) {
                new DBListFetch().printListOfCars();
            System.out.println("Thank you for using our service!!!");
            }
        else {
                System.out.println("* * * WELCOME TO DAILY PARK SPOT!!! * * * \n If you want to register new car, " + "press 'Y' or \n you want to see registered car's list press 'L'");
                welcome();
             }
    }
}
