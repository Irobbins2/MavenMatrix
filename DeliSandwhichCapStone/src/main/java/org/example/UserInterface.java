package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.example.Menu.displayWelcomeMessage;

public class UserInterface {
    private static Checkout checkout = new Checkout();
    private static Scanner scanner = new Scanner(System.in);

    public static void runOrderingSystem() {
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