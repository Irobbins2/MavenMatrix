package org.example;

import java.util.ArrayList;

public class Checkout {
    private ArrayList<Sandwich> sandwiches;
    private ArrayList<PremiumToppings> premiumToppings;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;

    public Checkout() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
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
        double totalPrice = 0;
        for (Sandwich sandwich : sandwiches) {

            totalPrice+=sandwich.getSandwichPrice();
        }

        for (PremiumToppings premiumToppings : premiumToppings) {
            totalPrice += premiumToppings.getTotalPremiumPrice();
        }
        /*for (PremiumToppings premiumToppings : premiumToppings) {
            totalPrice += premiumToppings.getPremiumCheesePrice();
        }*/

        for (Drink drink : drinks) {
            totalPrice += drink.getDrinkPrice();
        }

        for (Chips chip : chips) {
            totalPrice += chip.getChipsPrice();
        }

        return totalPrice;
    }
}