package com.pluralsight.items;

import com.pluralsight.checkout.Items;

public class Chips extends Items {

    private String chipsType;


    public Chips(String chipType) {
        this.chipsType = chipType;
    }

    public String getChipType() {
        return chipsType;
    }

    public void setChipType(String chipType) {
        this.chipsType = chipType;
    }

    @Override
    public double calculatePrice() {

        double chipsSmall = 1.5;
        double chipsMedium = 2.0;
        double chipsLarge = 2.5;

        if (chipsType.equalsIgnoreCase("Small")) {
            return chipsSmall;
        }
        else if(chipsType.equalsIgnoreCase("Medium")) {
            return chipsMedium;
        }
        else if (chipsType.equalsIgnoreCase("Large")) {
            return chipsLarge;
        }
        else {
            System.out.println("Please choose between Small, Medium or Large. ");
        }
        return 0;
    }
}
