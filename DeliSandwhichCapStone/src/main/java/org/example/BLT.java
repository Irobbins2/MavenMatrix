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
    public void removeTopping(String toppingName) {
        ArrayList<Topping> toppings = getToppings();
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).getName().equalsIgnoreCase(toppingName)) {
                toppings.remove(i);
                break;
            }
        }
    }

    public void modifyTopping(String oldTopping, Topping newTopping) {
        ArrayList<Topping> toppings = getToppings();
        for (int i = 0; i < toppings.size(); i++) {
            if (toppings.get(i).getName().equalsIgnoreCase(oldTopping)) {
                toppings.set(i, newTopping);
                break;
            }
        }
    }
}
