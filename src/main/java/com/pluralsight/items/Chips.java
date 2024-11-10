package com.pluralsight.items;

import com.pluralsight.checkout.Items;

public class Chips extends Items {

    private String chipsType;


    public Chips(String name, int quantity, String chipType) {
        super(name, quantity);
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

        double chipsPrice = 1.5;

        if (chipsType.equalsIgnoreCase(getName())) {
            return chipsPrice;
        } else if (chipsType.equalsIgnoreCase("No")) {
            return 0;
        } else {
            System.out.println("Please choose chips or Choose No to exit. ");
        }
        return chipsPrice * getQuantity();
    }

    @Override
    public String toString() {
        return "Chips{" +
                "total price= " + calculatePrice() + '\'' +
                '}';
    }
}
