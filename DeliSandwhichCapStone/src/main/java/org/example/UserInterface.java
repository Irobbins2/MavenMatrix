package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Checkout checkout = new Checkout();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayHomeScreen();

            int userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    runOrderingSystem();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }

    private static void displayHomeScreen() {
        System.out.println("Welcome to the Sandwich Shop!");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
    }
    static void runOrderingSystem() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;
        while (ordering) {
            System.out.println("What would you like to order? (sandwich/signature/drink/chips)");
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
                case "signature":
                    signatureSandwich();
                    break;
                default:
                    System.out.println("Invalid item type. Please choose sandwich, drink, or chips.");
                    break;
            }
            System.out.println("Would you like to add another item to your order? (yes/no)");
            String addAnother = scanner.next();
            if (!addAnother.equalsIgnoreCase("yes")) {
                ordering = false;
            }
        }
        System.out.println("Do you want to confirm your order? (yes/no)");
        String confirmOrder = scanner.next();
        if (confirmOrder.equalsIgnoreCase("yes")) {
            generateReceipt();
        } else {
            System.out.println("Order canceled. Returning to the main menu.");
            checkout.clearOrder();
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
        String meatType = "";
        boolean extraMeat = false;
        if (premiumMeat) {
            System.out.println("What type of premium meat do you want?");
            scanner.nextLine();
            System.out.println("Meat Options: Steak, ham, salami, roast beef, chicken, bacon");
            meatType = scanner.nextLine();
            System.out.println("Do you want extra meat? (yes/no): ");
            extraMeat = "yes".equalsIgnoreCase(scanner.next());
        }
        System.out.println("Do you want premium cheese? (yes/no): ");
        boolean premiumCheese = "yes".equalsIgnoreCase(scanner.next());
        String cheeseType = "";
        boolean extraCheese = false;
        if (premiumCheese) {
            System.out.println("What type of premium cheese do you want?");
            scanner.nextLine();
            System.out.println("Cheese options: American, Provolone, Cheddar, Swiss");
            cheeseType = scanner.nextLine();
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
        System.out.println("Do you want to remove toppings? (yes/no): ");
        boolean removeToppings = "yes".equalsIgnoreCase(scanner.next());
        if (removeToppings) {
            boolean removingToppings = true;
            while (removingToppings) {
                System.out.println("Enter a regular topping to remove (type 'done' to finish): ");
                System.out.println("Here are your options again: lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
                String regularTopping = scanner.next();

                if (regularTopping.equalsIgnoreCase("done")) {
                    removingToppings = false;
                } else {
                    RegularToppings topping = new RegularToppings(regularTopping);
                    sandwich.removeTopping(topping);
                }
            }
        }
        System.out.println("Do you want to add sauces? (yes/no): ");
        boolean addSauces = "yes".equalsIgnoreCase(scanner.next());
        if (addSauces) {
            System.out.println("Enter sauce type (e.g., mayo, mustard, ketchup, etc.): ");
            String sauceType = scanner.next();
            Sauces sauce = Sauces.valueOf(sauceType.toUpperCase());

            if (sauce != null) {
                RegularToppings sauceTopping = new RegularToppings(sauce.name());
                sandwich.addTopping(sauceTopping);
            }
        }
        checkout.addSandwich(sandwich);
    }
    private static void signatureSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Signature Sandwich Options:");
        System.out.println("1) BLT (Bacon, Lettuce, Tomato)");
        System.out.println("2) Philly Cheese Steak");
        System.out.print("Enter the number of the signature sandwich you want to order: ");
        int choice = scanner.nextInt();
        Sandwich signatureSandwich = null;
        switch (choice) {
            case 1:
                signatureSandwich = new BLT();
                System.out.println("BLT added to your order.");
                break;
            case 2:
                signatureSandwich = new PhillyCheeseSteak();
                System.out.println("Philly Cheese Steak added to your order.");
                break;
            default:
                System.out.println("Invalid choice. No signature sandwich added to your order.");
                return;
        }
        System.out.print("Do you want to add toppings? (yes/no): ");
        String addToppingsChoice = scanner.next();
        if (addToppingsChoice.equalsIgnoreCase("yes")) {
            boolean addingToppings = true;
            while (addingToppings) {
                System.out.println("Enter a topping to add (type 'done' to finish): ");
                System.out.println("Here are your options: Bacon, Lettuce, Tomato, Steak, American Cheese, Peppers, Mayo");
                String toppingName = scanner.next();
                if (toppingName.equalsIgnoreCase("done")) {
                    addingToppings = false;
                } else {
                    Topping topping = new RegularToppings(toppingName);
                    signatureSandwich.addTopping(topping);
                    System.out.println(toppingName + " added to your sandwich.");
                }
            }
        }
        System.out.print("Do you want to remove toppings? (yes/no): ");
        String removeToppingsChoice = scanner.next();
        if (removeToppingsChoice.equalsIgnoreCase("yes")) {
            boolean removingToppings = true;
            while (removingToppings) {
                System.out.println("Enter a topping to remove (type 'done' to finish): ");
                System.out.println("Here are your options: Bacon, Lettuce, Tomato, Steak, American Cheese, Peppers, Mayo");
                String toppingName = scanner.next();

                if (toppingName.equalsIgnoreCase("done")) {
                    removingToppings = false;
                } else {
                    Topping topping = new RegularToppings(toppingName);
                    signatureSandwich.removeTopping(topping);
                    System.out.println(toppingName + " removed from your sandwich.");
                }
            }
        }
        checkout.addSandwich(signatureSandwich);
    }
    private static void orderDrinks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to add drinks? (yes/no): ");
        boolean addDrinks = "yes".equalsIgnoreCase(scanner.next());

        if (addDrinks) {
            System.out.println("Please specify the number of drinks: ");
            int numberOfDrinks = scanner.nextInt();

            for (int i = 0; i < numberOfDrinks; i++) {

                System.out.println("Available drinks:");
                Menu.displayDrinksList();

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

                System.out.println("Available chips:");
                Menu.displayChipsList();

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

        ArrayList<String> saucesList = new ArrayList<>();

        ReceiptFileManager receiptFileManager = new ReceiptFileManager("src/main/resources/Receipt.csv");
        receiptFileManager.createReceipt(itemsArray, pricesArray, totalPrice, regularToppingsList, saucesList, drinks, chips);

        ArrayList<String> receiptDetails = receiptFileManager.getReceipt();
        System.out.println("Receipt Details:");
        for (String line : receiptDetails) {
            System.out.println(line);
        }
        checkout.clearOrder();
    }
}