package org.example;

import org.example.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Checkout checkout = new Checkout();

    public static void runOrderingSystem() {
        Scanner scanner = new Scanner(System.in);
        boolean addingItems = true;

        while (addingItems) {
            System.out.println("What would you like to order? (sandwich/drink/chips)");
            String itemType = scanner.next();

            switch (itemType.toLowerCase()) {
                case "sandwich":
                    orderSandwich();
                    break;
                case "drink":
                    orderDrinks();
                    break;
                case "chips":
                    orderChips();
                    break;
                default:
                    System.out.println("Invalid item type. Please choose sandwich, drink, or chips.");
                    break;
            }

            System.out.println("Would you like to add another item to your order? (yes/no)");
            String addAnother = scanner.next();
            if (!addAnother.equalsIgnoreCase("yes")) {
                addingItems = false;
            }
        }

        System.out.println("Would you like a receipt? (yes/no)");
        String wantReceipt = scanner.next();
        if (wantReceipt.equalsIgnoreCase("yes")) {
            generateReceipt();
        }
    }

    private static void orderSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What type of bread do you want?");
        System.out.println("Bread Options: White, Wheat, Rye, Wrap");
        String breadType = scanner.nextLine();

        System.out.println("Please select sandwich size (4/8/12 inches): ");
        int sandwichSize = scanner.nextInt();

        System.out.println("Do you want premium meat? (yes/no): ");
        boolean premiumMeat = "yes".equalsIgnoreCase(scanner.next());

        System.out.println("What type of premium meat do you want?");
        scanner.nextLine();
        System.out.println("Meat Options: Steak, ham, salami, roast beef, chicken, bacon");
        String meatType = scanner.nextLine();


        // If the user wants premium meat, ask if they want extra meat
        boolean extraMeat = false;
        if (premiumMeat) {
            System.out.println("Do you want extra meat? (yes/no): ");
            extraMeat = "yes".equalsIgnoreCase(scanner.next());
        }
        System.out.println("Do you want premium cheese? (yes/no): ");
        boolean premiumCheese = "yes".equalsIgnoreCase(scanner.next());

        System.out.println("What type of premium cheese do you want?");
        scanner.nextLine();
        System.out.println("Cheese options : American, Provolone, Cheddar, Swiss");
        String cheeseType = scanner.nextLine();


        boolean extraCheese = false;
        if (premiumCheese) {
            System.out.println("Do you want extra cheese? (yes/no): ");
            extraCheese = "yes".equalsIgnoreCase(scanner.next());
        }

        Sandwich sandwich = new Sandwich(sandwichSize, breadType);

        if (premiumMeat) {
            PremiumToppings premiumMeatTopping = new PremiumToppings("Premium Meat", PremiumToppingType.MEAT);
            sandwich.addTopping(premiumMeatTopping);
            if (extraMeat) {
                PremiumToppings extraMeatTopping = new PremiumToppings("Extra Meat", PremiumToppingType.EXTRA_MEAT);
                sandwich.addTopping(extraMeatTopping);
            }
        }
        if (premiumCheese) {
            PremiumToppings premiumCheeseTopping = new PremiumToppings("Premium Cheese", PremiumToppingType.CHEESE);
            sandwich.addTopping(premiumCheeseTopping);

            if (extraCheese) {
                PremiumToppings extraCheeseTopping = new PremiumToppings("Extra Cheese", PremiumToppingType.EXTRA_CHEESE);
                sandwich.addTopping(extraCheeseTopping);
            }
        }
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Enter a regular topping to add (type 'done' to finish): ");
            System.out.println("Here are your options again: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
            String regularTopping = scanner.next();

            if (regularTopping.equalsIgnoreCase("done")) {
                addingToppings = false;
            } else {
                RegularToppings topping = new RegularToppings(regularTopping);
                sandwich.addTopping(topping);
            }
        }
        System.out.println("Do you want to add sauces? (yes/no): ");
        boolean addSauces = "yes".equalsIgnoreCase(scanner.next());

        if (addSauces) {
            System.out.println("Enter sauce type (e.g., mayo, mustard, ketchup, etc.): ");
            String sauceType = scanner.next();
            Sauces sauce = Sauces.valueOf(sauceType.toUpperCase());

            // Add the chosen sauce to the sandwich
            if (sauce != null) {
                RegularToppings sauceTopping = new RegularToppings(sauce.name());
                sandwich.addTopping(sauceTopping);
            }
        }

        checkout.addSandwich(sandwich);
    }


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

    private static void generateReceipt() {
        ArrayList<Sandwich> sandwiches = checkout.getSandwiches();
        ArrayList<Drink> drinks = checkout.getDrinks();
        ArrayList<Chips> chips = checkout.getChips();

        ArrayList<String> items = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        for (Sandwich sandwich : sandwiches) {
            items.add("Sandwich");
            prices.add(sandwich.getTotalPrice());
        }
        for (Drink drink : drinks) {
            items.add("Drink");
            prices.add(drink.getDrinkPrice());
        }
        for (Chips chip : chips) {
            items.add("Chips");
            prices.add(chip.getChipsPrice());
        }

        double totalPrice = checkout.totalPrice();

        String[] itemsArray = items.toArray(new String[0]);
        double[] pricesArray = prices.stream().mapToDouble(Double::doubleValue).toArray();

        ArrayList<RegularToppings> regularToppingsList = new ArrayList<>();
        // Add selected regular toppings to regularToppingsList

        ArrayList<String> saucesList = new ArrayList<>();
        // Add selected sauces to saucesList

        ReceiptFileManager receiptFileManager = new ReceiptFileManager("src/main/resources/Receipt.csv");
        receiptFileManager.createReceipt(itemsArray, pricesArray, totalPrice, regularToppingsList, saucesList, drinks, chips);

        ArrayList<String> receiptDetails = receiptFileManager.getReceipt();
        System.out.println("Receipt Details:");
        for (String line : receiptDetails) {
            System.out.println(line);
        }
    }
}