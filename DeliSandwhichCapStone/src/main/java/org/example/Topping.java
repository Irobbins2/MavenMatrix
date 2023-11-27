package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Topping {
    private RegularToppings toppings;
    private Sauces sauces;
    private String name;
    private String type;
    private double price;

    public Topping(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;

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

    public RegularToppings getToppings() { return toppings; }

    public void setToppings(RegularToppings toppings) {
        this.toppings = toppings;
    }

    public Sauces getSauces() { return sauces; }

    public void setSauces(Sauces sauces) {
        this.sauces = sauces;
    }
}



