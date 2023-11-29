package org.example;

public class Topping {
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
}