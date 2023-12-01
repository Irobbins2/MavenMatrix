package org.example;

public class Drink {
    private String size;
    private String brand;

    public Drink(String size, String brand) {
        this.size = size;
        this.brand = brand;
    }
    public String getSize() {
        return size;
    }

    public double getDrinkPrice() {
        switch (size.toLowerCase()) {
            case "small":
                return 2.0;
            case "medium":
                return 2.50;
            case "large":
                return 3.0;
            default:
                return 0.0;
        }
    }
}



