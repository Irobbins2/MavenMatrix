package org.example;

public class Sandwich {
    public int sandwichSize;

    public Sandwich(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public  double getExtraMeatPrice(){return 0;};

    public double getExtraCheesePrice(){return 0;};

    public double getPremiumMeatPrice(){return 0;};

    public  double getPremiumCheesePrice(){return 0;};

    public double getSandwichPrice() {
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

    public  double getTotalPrice(){return 0;};
}