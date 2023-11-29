package org.example;

public class PremiumToppings extends Topping {
   private PremiumToppingType premiumToppingType;
   private String name;

    public PremiumToppings(String name, PremiumToppingType premiumToppingType) {
        super(name);
        this.premiumToppingType = premiumToppingType;
    }


    public double getPrice(int sandwichSize) {
        if (premiumToppingType==PremiumToppingType.CHEESE) {
            if (sandwichSize == 4) {
                return 0.75;
            }
            else if (sandwichSize == 8) {
                return 1.50;
            }
            else {
                return 2.25;
            }
        } else if (premiumToppingType ==PremiumToppingType.EXTRA_CHEESE) {
            if (sandwichSize==4){
                return 0.30;
            }
            else if (sandwichSize==8){
                return 0.60;
            }
            else{
                return 0.90;
            }

        }
        else if (premiumToppingType==PremiumToppingType.EXTRA_MEAT){
            if (sandwichSize==4){
                return 0.50;
            }
            else if (sandwichSize==8){
                return 1.00;
            }
            else{
                return 1.50;
            }
        }
        else {
            if (sandwichSize == 4) {
                return 1;
            } else if (sandwichSize == 8) {
                return 2;
            } else {
                return 3;
            }
        }

    }
}