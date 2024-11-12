package com.pluralsight.items;

import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends Items {

    private String drinkSize;
    private String drinkFlavor;

    //FIXED VALUES
    private List<String> drinkFlavorList = new ArrayList<>(List.of("Coke", "Fanta", "Sprite", "Mountain Dew", "Tropicana", "Arizona Ice tea" ));
    private static final double drinksSmall = 2.0, drinksMedium = 2.50 , drinksLarge = 3.0;

    //CONSTRUCTORS
    public Drinks(String name, int quantity, String drinkSize, String drinkFlavor) {
        super(name,quantity);
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }

    public Drinks(){}

    //GETTERS AND SETTERS
    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public String getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(String drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    public List<String> getDrinkFlavorList(){
        return drinkFlavorList;
    }


    @Override
    public double calculatePrice() {

        if (drinkSize.equalsIgnoreCase("Small")) {
            return drinksSmall * getQuantity();
        }
        else if(drinkSize.equalsIgnoreCase("Medium")) {
            return drinksMedium * getQuantity();
        }
        else if (drinkSize.equalsIgnoreCase("Large")) {
            return drinksLarge * getQuantity();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "Size='" + drinkSize + '\'' +
                ", Flavor='" + drinkFlavor + '\'' +
                ", Total Price= $" + calculatePrice() +
                '}';
    }

}
