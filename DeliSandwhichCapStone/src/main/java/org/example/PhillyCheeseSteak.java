package org.example;


public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak(){
        super(8, "White");
        addTopping(new RegularToppings("Steak"));
        addTopping(new PremiumToppings("American Cheese", PremiumToppingType.CHEESE));
        addTopping(new RegularToppings("Peppers"));
        addTopping(new RegularToppings("Mayo"));
        setToasted(true);
    }
}
