package org.example;
import java.util.ArrayList;

public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak(){
        super(8, "White");
        addTopping(new RegularToppings("Steak"));
        addTopping(new PremiumToppings("American Cheese", PremiumToppingType.CHEESE));
        addTopping(new RegularToppings("Peppers"));
        addTopping(new RegularToppings("Mayo"));
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

    // Method to modify toppings in PhillyCheeseSteak
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
