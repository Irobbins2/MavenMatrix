package org.example;


import org.example.*;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Menu.displayWelcomeMessage;

public class UserInterface {
    private static Checkout checkout = new Checkout();
    private static Scanner scanner = new Scanner(System.in);

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

        Sandwich sandwich = new Sandwich(sandwichSize);

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


        while (true) {
            displayWelcomeMessage();
            displayHomeScreen();
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    newOrder();
                    break;
                case 0:
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayHomeScreen() {

        System.out.println("1) New Order");
        System.out.println("0) Exit");
    }

    private static void newOrder() {
        while (true) {
            displayOrderScreen();
            int choice = getIntegerInput();

            switch (choice) {
                case 1:
                    orderSandwich();
                    break;
                case 2:
                    orderDrinks();
                    break;
                case 3:
                    orderChips();
                    break;
                case 4:
                    printOrderSummary();
                    break;
                case 0:
                    cancelOrder();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayOrderScreen() {
        System.out.println("Explore our menu and create your perfect sandwich combination.");
        System.out.println("We use the freshest ingredients to ensure a delicious experience.");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
    }

    private static void orderSandwich() {
        try {
            System.out.println("How many sandwiches do you want?");
            int numberOfSandwiches = getIntegerInput();

            for (int sandwichNumber = 1; sandwichNumber <= numberOfSandwiches; sandwichNumber++) {
                System.out.println("Sandwich #" + sandwichNumber);

                System.out.println("Select type of bread (choose from the Menu): ");
                Menu.displayBreadType();
                String breadType = scanner.next();

                System.out.println("Please select sandwich size (4/8/12 inches): ");
                int sandwichSize = getIntegerInput();

                System.out.println("Do you want premium meat? (yes/no): ");
                boolean premiumMeat = getYesNoInput();

                System.out.println("Do you want premium cheese? (yes/no): ");
                boolean premiumCheese = getYesNoInput();

                Sandwich sandwich = new Sandwich(sandwichSize, breadType);
                checkout.addSandwich(sandwich);

                addRegularToppings(sandwich);

                if (premiumMeat) {
                    addPremiumToppings(sandwich, PremiumToppingType.MEAT);
                }

                if (premiumCheese) {
                    addPremiumToppings(sandwich, PremiumToppingType.CHEESE);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addPremiumToppings(Sandwich sandwich, PremiumToppingType toppingType) {
        try {
            System.out.println("Adding Premium " + toppingType.toString().toLowerCase() + ":");
            for (String premiumTopping : Menu.getPremiumToppings(toppingType.toString().toLowerCase())) {
                System.out.println("Do you want " + premiumTopping + "? (yes/no): ");
                boolean addTopping = getYesNoInput();

                if (addTopping) {
                    sandwich.addTopping(new PremiumToppings(premiumTopping, toppingType));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addRegularToppings(Sandwich sandwich) {
        try {
            Menu.displayRegularToppings();

            for (String regularTopping : Menu.getRegularToppings()) {
                System.out.println("Add " + regularTopping + "? (yes/no): ");
                boolean addTopping = getYesNoInput();

                if (addTopping) {
                    sandwich.addTopping(new RegularToppings(regularTopping));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    private static void orderDrinks() {
        try {
            System.out.println("Do you want to add drinks? (yes/no): ");
            boolean addDrinks = getYesNoInput();

            if (addDrinks) {
                System.out.println("Please specify the number of drinks: ");
                int numberOfDrinks = getIntegerInput();

                for (int i = 0; i < numberOfDrinks; i++) {
                    System.out.println("Drink #" + (i + 1));

                    Menu.displayDrinkBrands();

                    System.out.println("Enter drink brand for drink #" + (i + 1) + ": ");
                    String drinkBrand = scanner.next();

                    System.out.println("Enter drink size for drink #" + (i + 1) + " (small/medium/large): ");
                    String drinkSize = scanner.next();

                    Drink drink = new Drink(drinkSize, drinkBrand);
                    checkout.addDrink(drink);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void orderChips() {
        try {
            System.out.println("Do you want to add chips? (yes/no): ");
            boolean addChips = getYesNoInput();

            if (addChips) {
                System.out.println("Please specify the number of chips: ");
                int numberOfChips = getIntegerInput();

                for (int i = 0; i < numberOfChips; i++) {
                    System.out.println("Chips #" + (i + 1));

                    Menu.displayChipsBrands();

                    System.out.println("Enter chips brand for chips #" + (i + 1) + ": ");
                    String chipsBrand = scanner.next();

                    Chips chips = new Chips(chipsBrand);
                    checkout.addChips(chips);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

    private static void printOrderSummary() {
        try {
            checkout.listAmountOfItems();
            System.out.println("Total Price: $" + checkout.totalPrice());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int getIntegerInput() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    }

    private static boolean getYesNoInput() {
        while (true) {
            String input = scanner.next().toLowerCase();
            if (input.equals("yes")) {
                return true;
            } else if (input.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    private static void cancelOrder() {
        checkout = new Checkout();
        System.out.println("Order canceled. Returning to the home screen.");
    }

    private static void exitApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);

    }
}