package com.pluralsight.items;

import com.pluralsight.checkout.Items;

public class Drinks extends Items {

    private String drinkSize;
    private String drinkFlavor;

    public Drinks(String drinkSize, String drinkFlavor) {
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }

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


    @Override
    public double calculatePrice() {
        double drinksSmall = 2.0;
        double drinksMedium = 2.50;
        double drinksLarge = 3.0;

        if (drinkSize.equalsIgnoreCase("Small")) {
            return drinksSmall;
        }
        else if(drinkSize.equalsIgnoreCase("Medium")) {
            return drinksMedium;
        }
        else if (drinkSize.equalsIgnoreCase("Large")) {
            return drinksLarge;
        }
        else {
            System.out.println("Please choose between Small, Medium or Large. ");
        }
        return 0;
    }
}
