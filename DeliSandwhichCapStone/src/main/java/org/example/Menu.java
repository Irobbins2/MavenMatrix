package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.ColoredText.*;

public class Menu {
    public static List<String> getBreadType(){
        List<String> breadType = Arrays.asList("White, Wheat, Rye, Wrap");
        return breadType;
    }

    public static List<String> getMeats(){
       List<String> meats = Arrays.asList("Steak, ham, salami, roast beef, chicken, bacon");
       return meats;
    }

    public static  List<String> getRegularToppings(){
        List<String> regularToppings = Arrays.asList
                ("lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms");
        return regularToppings;
    }
    public static  List<String> getSauces(){
        List<String> sauces = Arrays.asList(ANSI_WHITE + "Mayo ," + ANSI_RESET + ANSI_YELLOW  +"mustard ," + ANSI_RESET
                + ANSI_RED +"ketchup ," + ANSI_RESET + ANSI_GREEN + "ranch ," + ANSI_RESET + ANSI_MIXED +"thousand islands ,"+ ANSI_RESET
                + ANSI_ORANGE +"vinaigrette"+ ANSI_RESET);
        return sauces;
    }
    public static  List<String> getCheese(){
        List<String> cheese = Arrays.asList("American, Provolone, Cheddar, Swiss");
        return cheese;
    }
    public static void displayMenu() {
        System.out.println("Welcome to the Maven Matrix shop! These are the available options");

        //List of available bread types.
        System.out.println("Bread: ");
        for (String breadType : getBreadType()) {
            System.out.println("- " + breadType);
        }

        //list of available meats for the sandwich
        System.out.println("\n Meats: ");
        for (String meat : getMeats()) {
            System.out.println("- " + meat);
        }
        // List of available cheese options
        System.out.println("\n Cheese: ");
        for (String cheese : getCheese()) {
            System.out.println("- " + cheese);
        }
        //List of available regular toppings.
        System.out.println("\n Regular Toppings: ");
        for (String topping : getRegularToppings()) {
            System.out.println("- " + topping);
        }

        //List of available sauces.
        System.out.println("\n Sauces: ");
        for (String sauces : getSauces()) {
            System.out.println("- " + sauces);
        }
    }
}
