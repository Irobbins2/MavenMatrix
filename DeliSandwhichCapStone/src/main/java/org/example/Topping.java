package org.example;

import java.util.ArrayList;

public class Topping {
    private String name;
    private String type;
    private double price;
    private ArrayList<Topping> toppings;

    public Topping(String name, String type, double price, ArrayList<Topping> toppings) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.toppings = toppings;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}



