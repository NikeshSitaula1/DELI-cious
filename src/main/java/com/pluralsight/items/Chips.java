package com.pluralsight.items;

import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Items {

    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public String getChipType() {
        return chipType;
    }

    public void setChipType(String chipType) {
        this.chipType = chipType;
    }

    @Override
    public double totalPrice() {
        return 0;
    }
}
