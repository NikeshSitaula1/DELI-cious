package com.pluralsight.Sandwich;

import com.pluralsight.items.Sandwich;

public class Toppings {

    private String toppingName;
    private boolean toppingIsPremium;
    private double toppingExtra;

    public Toppings(String toppingName, boolean toppingIsPremium, double toppingExtra) {
        this.toppingName = toppingName;
        this.toppingIsPremium = toppingIsPremium;
        this.toppingExtra = toppingExtra;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public boolean isToppingIsPremium() {
        return toppingIsPremium;
    }

    public void setToppingIsPremium(boolean toppingIsPremium) {
        this.toppingIsPremium = toppingIsPremium;
    }

    public double getToppingExtra() {
        return toppingExtra;
    }

    public void setToppingExtra(double toppingExtra) {
        this.toppingExtra = toppingExtra;
    }

    public double calculateCost() {

        return 0;
    }
}
