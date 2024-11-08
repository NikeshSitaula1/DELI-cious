package com.pluralsight.items;

import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Items {

    private String chipsType;
    private final double chipsSmall = 1.5;
    private final double chipsMedium = 2.0;
    private final double chipsLarge = 2.5;


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
    public double totalPrice() {
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
