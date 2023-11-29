package org.example;

import java.util.ArrayList;

public class Sandwich {
    private int sandwichSize;
    private ArrayList<Topping> toppings = new ArrayList<>();

    public Sandwich(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public double getSandwichBasePrice() {
        double basePrice;

        switch (sandwichSize) {
            case 4:
                basePrice = 5.50;
                break;
            case 8:
                basePrice = 7.00;
                break;
            case 12:
                basePrice = 8.50;
                break;
            default:
                basePrice = 0.0;
                break;
        }

        return basePrice ;
    }
    public void  addTopping(Topping topping){
        toppings.add(topping);
    }
    public void  removeTopping(Topping topping){
        toppings.remove(topping);
    }
    public double getTotalPrice(){
        double totalprice=0;
        for (Topping topping:toppings){
            totalprice+= topping.getPrice(sandwichSize);
        }
        return getSandwichBasePrice()+ totalprice;
    }
}