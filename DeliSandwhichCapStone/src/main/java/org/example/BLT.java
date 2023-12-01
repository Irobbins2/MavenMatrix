package org.example;

import java.util.ArrayList;

public class BLT extends Sandwich {

    public BLT () {
        super(8, "White");
        addTopping(new RegularToppings("Bacon"));
        addTopping(new PremiumToppings("Cheddar", PremiumToppingType.CHEESE));
        addTopping(new RegularToppings("Lettuce"));
        addTopping(new RegularToppings("Tomato"));
        addTopping(new RegularToppings("Ranch"));
        setToasted(true);
    }
}
