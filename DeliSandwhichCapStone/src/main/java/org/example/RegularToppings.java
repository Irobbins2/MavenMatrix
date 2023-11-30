package org.example;

public class RegularToppings extends Topping{
    private String toppingName;

    public RegularToppings(String name) {
        super(name);
        this.toppingName = name;
    }

    public String getToppingName() {
        return toppingName;
    }
    @Override
    public double getPrice(int sandwichSize) {
        return 0;
    }

    public int getName() {
        return getName();
    }
}