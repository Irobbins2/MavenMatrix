package org.example;

import java.util.ArrayList;

public class Checkout {
    private ArrayList<Sandwhich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;

    public Checkout() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwhich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public void listAmountOfItems() {
        System.out.println("Number of Sandwiches: " + sandwiches.size());
        System.out.println("Number of Drinks: " + drinks.size());
        System.out.println("Number of Chips: " + chips.size());
    }

    public double totalPrice() {
        double totalPrice = basePrice();

        for (Sandwhich sandwich : sandwiches) {
            totalPrice += sandwich.getMeatPrice() + sandwich.getCheesePrice();
        }


        // Add similar logic for drinks and chips if they have additional costs.

        return totalPrice;
    }

    private double basePrice() {
        // Assuming your base price depends on the size of the sandwich
        // Adjust this based on your actual implementation.
        // I'm using a placeholder value for demonstration purposes.
        String size = "medium"; // Replace with actual logic to get the size
        switch (size.toLowerCase()) {
            case "small":
                return 5.50 + 1;
            case "medium":
                return 7.00 + 1;
            case "large":
                return 8.50 + 1;
            default:
                return 0.0; // Handle unknown size
        }
    }

    // Other methods and logic specific to your Checkout class
}
