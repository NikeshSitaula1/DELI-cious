package com.pluralsight.Items;

import com.pluralsight.Checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Chips extends Items {

    private String chipsType;

    //FIXED VALUES
    private List<String> chipsTypeList = new ArrayList<>(List.of("Lays", "Cheetos", "Doritos"));
    private static final double chipsPrice = 1.5;

    //CONSTRUCTORS
    public Chips(String name, int quantity, String chipType) {
        super(name, quantity);
        this.chipsType = chipType;
    }

    public Chips(String chipsType) {
        this.chipsType = chipsType;
    }

    public Chips(){}


    //GETTERS AND SETTERS
    public String getChipType() {
        return chipsType;
    }

    public void setChipType(String chipType) {
        this.chipsType = chipType;
    }

    public List<String> getChipsTypeList(){
        return chipsTypeList;
    }

    @Override
    public double calculatePrice() {
        return chipsPrice;
    }

    @Override
    public String toString() {
        return "Chips: " + chipsType + " - $" + calculatePrice();
    }

}
