package org.example;

public class PremiumToppings {

    public double getMeatPrice(Topping meatTopping, int sandwichSize, boolean addExtra) {
        double meatPrice = meatTopping.getPrice();

        // Adjust price based on sandwich size
        if (sandwichSize == 4) {
            meatPrice += 1.0;
            if (addExtra) {
                meatPrice += 0.5;
            }
        } else if (sandwichSize == 8) {
            meatPrice += 2.0;
            if (addExtra) {
                meatPrice += 1.0;
            }
        } else if (sandwichSize == 12) {
            meatPrice += 3.0;
            if (addExtra) {
                meatPrice += 1.5;
            }
        }

        return meatPrice;
    }
    public double getCheesePrice(Topping cheeseTopping, int sandwichSize, boolean extraCheese) {
        double cheesePrice = cheeseTopping.getPrice();

        // Adjust price based on sandwich size and extra toppings
        if (sandwichSize == 4) {
            cheesePrice += 0.75;
            if (extraCheese) {
                cheesePrice += 0.30;
            }
        } else if (sandwichSize == 8) {
            cheesePrice += 1.50;
            if (extraCheese) {
                cheesePrice += 0.60;
            }
        } else if (sandwichSize == 12) {
            cheesePrice += 2.25;
            if (extraCheese) {
                cheesePrice += 2.25;
            }
        }

        return cheesePrice;
    }
}

