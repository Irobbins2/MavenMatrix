package org.example;

public class PremiumToppings extends Sandwich {
    private boolean premiumMeat;
    private boolean premiumCheese;

    public PremiumToppings(int sandwichSize, boolean premiumMeat, boolean premiumCheese) {
        super(sandwichSize);
        this.premiumMeat = premiumMeat;
        this.premiumCheese = premiumCheese;
    }
    @Override
    public double getExtraMeatPrice() {
        switch (getSandwichSize()) {
            case 4:
                return 0.50;
            case 8:
                return 1.00;
            case 12:
                return 1.50;
            default:
                return 0.0;
        }
    }

    @Override
    public double getExtraCheesePrice() {
        switch (getSandwichSize()) {
            case 4:
                return 0.30;
            case 8:
                return 0.60;
            case 12:
                return 0.90;
            default:
                return 0.0;
        }
    }

    @Override
    public double getPremiumMeatPrice() {
        switch (getSandwichSize()) {
            case 4:
                return 1;
            case 8:
                return 2.00 ;
            case 12:
                return 3.00;
            default:
                return 0.0;
        }
    }

    @Override
    public double getPremiumCheesePrice() {
        switch (getSandwichSize()) {
            case 4:
                return 0.75;
            case 8:
                return 1.50 ;
            case 12:
                return 2.25 ;
            default:
                return 0.0;
        }
    }

    public double getTotalPremiumPrice(){
        double premiumTotal = getPremiumMeatPrice()+getPremiumCheesePrice();
        return premiumTotal;
    }
}