package com.pluralsight.Sandwich;

import com.pluralsight.Items.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class SignatureSandwiches extends Sandwich {

    public SignatureSandwiches(String name, int quantity, String sandwichBread, String sandwichSize, String isToasted, List<Toppings> toppingsList) {
        super(name, quantity, sandwichBread, sandwichSize, isToasted, toppingsList);
    }

    public static SignatureSandwiches createBLT() {

        List<Toppings> bltTopping = new ArrayList<>();

        bltTopping.add(new Toppings("Bacon", "Meat"));
        bltTopping.add(new Toppings("Cheddar","Cheese"));
        bltTopping.add(new Toppings("Lettuce", "Regular Toppings"));
        bltTopping.add(new Toppings("Tomato", "Regular Toppings"));
        bltTopping.add(new Toppings("Ranch", "Sauce"));

        return new SignatureSandwiches("BLT", 1, "white bread", "8",
                                                            "yes", bltTopping );
    }


    public static SignatureSandwiches createPhillyCheeseSteak() {

        List<Toppings> phillyTopping = new ArrayList<>();

        phillyTopping.add(new Toppings("Steak", "Meat"));
        phillyTopping.add(new Toppings("American Cheese","Cheese"));
        phillyTopping.add(new Toppings("Peppers", "Regular Toppings"));
        phillyTopping.add(new Toppings("Mayo", "Sauce"));

        return new SignatureSandwiches("Philly Cheese Steak", 1,
                                                "white bread","8", "yes", phillyTopping);
    }

    @Override
    public String toString() {
        //CALLING SANDWICH TO STRING BUT CHANGING NAME
        String baseDescription = super.toString();
        return baseDescription.replace("Item: Custom Sandwich", "Item: " + getName());
    }
}
