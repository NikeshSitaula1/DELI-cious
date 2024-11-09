package com.pluralsight.Sandwich;

public class Toppings {

    private String toppingName;
    private String toppingType;
    private boolean toppingIsPremium;
    private boolean toppingIsExtra;

    public Toppings(String toppingName, String toppingType, boolean toppingIsPremium, boolean toppingIsExtra) {
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.toppingIsPremium = toppingIsPremium;
        this.toppingIsExtra = toppingIsExtra;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        this.toppingType = toppingType;
    }

    public boolean isToppingIsPremium() {
        return toppingIsPremium;
    }

    public void setToppingIsPremium(boolean toppingIsPremium) {
        this.toppingIsPremium = toppingIsPremium;
    }

    public boolean getToppingIsExtra() {
        return toppingIsExtra;
    }

    public void setToppingIsExtra(boolean toppingExtra) {
        this.toppingIsExtra = toppingExtra;
    }



    //MAIN CALCULATION
    public double calculateToppingCost(String sandwichSize) {
        double toppingCost = 0;

        if (toppingIsPremium){
            if (toppingType.equalsIgnoreCase("Meat")){
                toppingCost = calculateMeatCost(sandwichSize,toppingIsExtra);
            }
            else if (toppingType.equalsIgnoreCase("Cheese")){
                toppingCost = calculateCheeseCost(sandwichSize, toppingIsExtra);
            }
        }
        return toppingCost;
    }


    public double calculateMeatCost(String sandwichSize, boolean toppingIsExtra){
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? 1.50 : 1.00;  // 1.00 + 0.5 for extra
            case "8" -> toppingIsExtra ? 3.00 : 2.00;  // 2.00 + 1.00 for extra
            case "12" -> toppingIsExtra ? 4.50 : 3.00; // 3.00 + 1.5 for extra
            default -> 0;
        };
    }

    public double calculateCheeseCost(String sandwichSize, boolean toppingIsExtra){
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? 1.05 : 0.75;  // 0.75 + 0.30 for extra
            case "8" -> toppingIsExtra ? 2.10 : 1.50;  // 1.50 + 0.60 for extra
            case "12" -> toppingIsExtra ? 3.15 : 2.25; // 2.25 + 0.90 for extra
            default -> 0;
        };
    }
}
