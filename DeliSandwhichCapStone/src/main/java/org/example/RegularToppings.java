package org.example;

public class RegularToppings extends Topping{
    public RegularToppings(String name) {
        super(name);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0;
    }

}
