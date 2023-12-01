package org.example;

import java.util.ArrayList;

public class Sandwich {
    private int sandwichSize;
    private String breadType;
    private ArrayList<Topping> toppings = new ArrayList<>();
    private boolean toasted;

    public Sandwich(int sandwichSize, String breadType) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
    }
    public void  addTopping(Topping topping){
        toppings.add(topping);
    }
    public void  removeTopping(Topping topping){
        toppings.remove(topping);
    }
    public void setToasted(boolean toasted) {this.toasted = toasted;}
    public ArrayList<Topping> getToppings() {return toppings;}

    public int getSandwichSize() {
        return sandwichSize;
    }
    public double getTotalPrice(){
        double totalprice=0;
        for (Topping topping:toppings){
            totalprice+= topping.getPrice(sandwichSize);
        }
        return getSandwichBasePrice()+ totalprice;
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
}