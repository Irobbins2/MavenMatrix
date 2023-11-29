package org.example;

import org.example.*;

import java.util.Scanner;

public class UserInterface {

    private static Checkout checkout = new Checkout();

    public static void runOrderingSystem() {
        orderSandwich();
        orderDrinks();
        orderChips();
        printOrderSummary();

    }

    private static void orderSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of bread do you want?");
        String breadType = scanner.nextLine();

        System.out.println("Please select sandwich size (4/8/12 inches): ");
        int sandwichSize = scanner.nextInt();
        System.out.println("Do you want premium meat? (yes/no): ");
        boolean premiumMeat = "yes".equalsIgnoreCase(scanner.next());

        System.out.println("Do you want premium cheese? (yes/no): ");
        boolean premiumCheese = "yes".equalsIgnoreCase(scanner.next());
       // PremiumToppings premiumToppings = new PremiumToppings(sandwichSize, premiumMeat, premiumCheese);
       // checkout.addSandwich(premiumToppings);
    }
    /*private static void orderpremium() {
    Scanner scanner = new Scanner(System.in);


    }*/

    private static void orderDrinks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add drinks? (yes/no): ");
        boolean addDrinks = "yes".equalsIgnoreCase(scanner.next());

        if (addDrinks) {
            System.out.println("Please specify the number of drinks: ");
            int numberOfDrinks = scanner.nextInt();

            for (int i = 0; i < numberOfDrinks; i++) {
                System.out.println("Enter drink name for drink #" + (i + 1) + ": ");
                String drinkBrand = scanner.next();

                System.out.println("Enter drink size for drink #" + (i + 1) + " (small/medium/large): ");
                String drinkSize = scanner.next();

                Drink drink = new Drink(drinkSize, drinkBrand);
                checkout.addDrink(drink);
            }
        }
    }

    private static void orderChips() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add chips? (yes/no): ");
        boolean addChips = "yes".equalsIgnoreCase(scanner.next());

        if (addChips) {
            System.out.println("Please specify the number of chips: ");
            int numberOfChips = scanner.nextInt();

            for (int i = 0; i < numberOfChips; i++) {
                System.out.println("Enter chips type for chips #" + (i + 1) + ": ");
                String chipsBrand = scanner.next();

                Chips chips = new Chips(chipsBrand);
                checkout.addChips(chips);
            }
        }
    }

    private static void printOrderSummary() {
        checkout.listAmountOfItems();
        System.out.println("Total Price: $" + checkout.totalPrice());
    }
}