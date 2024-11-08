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
    public double totalPrice() {
        return 0;
    }
}
