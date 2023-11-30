package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.ColoredText.*;

public class Menu {
    public static List<String> getBreadType() {
        return Arrays.asList("White", "Wheat", "Rye", "Wrap");
    }

    public static List<String> getMeats() {
        return Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Bacon");
    }

    public static List<String> getRegularToppings() {
        return Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms");
    }

    public static  List<String> getSauces() {
        List<String> sauces = Arrays.asList(ANSI_WHITE + "Mayo ," + ANSI_RESET + ANSI_YELLOW + "mustard ," + ANSI_RESET
                + ANSI_RED + "ketchup ," + ANSI_RESET + ANSI_GREEN + "ranch ," + ANSI_RESET + ANSI_MIXED + "thousand islands ," + ANSI_RESET
                + ANSI_ORANGE + "vinaigrette" + ANSI_RESET);
        return sauces;
    }

    public static List<String> getCheese() {
        return Arrays.asList("American", "Provolone", "Cheddar", "Swiss");
    }

    public static List<String> getPremiumToppings(String toppingType) {
        if ("meat".equalsIgnoreCase(toppingType)) {
            return Arrays.asList("Pepperoni", "Turkey", "Roast Beef");
        } else if ("cheese".equalsIgnoreCase(toppingType)) {
            return Arrays.asList("Pepper Jack", "Swiss", "Blue Cheese");
        } else {
            return Arrays.asList();
        }
    }

    public static List<String> getChipsBrands() {
        return Arrays.asList("Lays", "Doritos", "Pringles", "Ruffles", "Cheetos", "Tostitos");
    }

    public static List<String> getDrinkBrands() {
        return Arrays.asList("Coca-Cola", "Pepsi", "Sprite", "Mountain Dew", "Dr. Pepper", "Fanta");
    }
    public static void displayWelcomeMessage() {
        System.out.println("Welcome to the Maven Matrix shop! Crafting Delightful Sandwiches!");
    }

   /* public static void displayMenu() {

        System.out.println("Bread: ");
        for (String breadType : getBreadType()) {
            System.out.println("- " + breadType);
        }

        System.out.println("\n Meats: ");
        for (String meat : getMeats()) {
            System.out.println("- " + meat);
        }

        System.out.println("\n Cheese: ");
        for (String cheese : getCheese()) {
            System.out.println("- " + cheese);
        }

        System.out.println("\n Regular Toppings: ");
        for (String topping : getRegularToppings()) {
            System.out.println("- " + topping);
        }

        System.out.println("\n Sauces: ");
        for (String sauces : getSauces()) {
            System.out.println("- " + sauces);
        }

        System.out.println("\n Chips Brands: ");
        for (String chipsBrand : getChipsBrands()) {
            System.out.println("- " + chipsBrand);
        }

        System.out.println("\n Drink Brands: ");
        for (String drinkBrand : getDrinkBrands()) {
            System.out.println("- " + drinkBrand);
        }
    }*/
    public static void displayBreadType() {
        System.out.println("Bread Types:");
        for (String breadType : getBreadType()) {
            System.out.println("- " + breadType);
        }
    }

    public static void displayRegularToppings() {
        System.out.println("Regular Toppings:");
        for (String topping : getRegularToppings()) {
            System.out.println("- " + topping);
        }
    }

    public static void displayDrinkBrands() {
        System.out.println("Drink Brands:");
        for (String drinkBrand : getDrinkBrands()) {
            System.out.println("- " + drinkBrand);
        }
    }

    public static void displayChipsBrands() {
        System.out.println("Chips Brands:");
        for (String chipsBrand : getChipsBrands()) {
            System.out.println("- " + chipsBrand);
        }
    }
}