package com.pluralsight.items;

import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Drinks extends Items {

    private String drinkSize;
    private String drinkFlavor;

    //FIXED VALUES
    private List<String> drinkFlavorList = new ArrayList<>(List.of("Mango","Coke","Orange"));

    public Drinks(String name, int quantity, String drinkSize, String drinkFlavor) {
        super(name,quantity);
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }

    public Drinks(){};

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
        double drinksSmall = 2.0;
        double drinksMedium = 2.50;
        double drinksLarge = 3.0;

        if (drinkSize.equalsIgnoreCase("Small")) {
            return drinksSmall * getQuantity();
        }
        else if(drinkSize.equalsIgnoreCase("Medium")) {
            return drinksMedium * getQuantity();
        }
        else if (drinkSize.equalsIgnoreCase("Large")) {
            return drinksLarge * getQuantity();
        }
        else {
            System.out.println("Please choose between Small, Medium or Large. ");
        }
        return 0;
    }
}
