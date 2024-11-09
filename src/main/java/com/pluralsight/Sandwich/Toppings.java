package com.pluralsight.Sandwich;

import java.util.Arrays;
import java.util.List;

public class Toppings {

    private String toppingName;
    private String toppingType;
    private boolean toppingIsPremium;
    private boolean toppingIsExtra;

    //LIST OF FIXED VALUES
    private final List<String> meatOptions = Arrays.asList("Steak","Ham","Salami","Roast beef","Chicken","Bacon");
    private final List<String> cheeseOptions = Arrays.asList("American", "Provolone","Cheddar","Swiss");
    private final double costMeatSize4 = 1.00;
    private final double costMeatSize8 = 2.00;
    private final double costMeatSize12 = 3.00;
    private final double extraCostMeatSize4 = 0.50;
    private final double extraCostMeatSize8 = 1.00;
    private final double extraCostMeatSize12 = 1.50;
    private final double costCheeseSize4 = 0.75;
    private final double costCheeseSize8 = 1.50;
    private final double costCheeseSize12 = 2.25;
    private final double extraCostCheeseSize4 = 0.30;
    private final double extraCostCheeseSize8 = 0.60;
    private final double extraCostCheeseSize12 = 0.90;



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

    public boolean validMeatOption(String toppingName){
        return meatOptions.contains(toppingName.toLowerCase().trim());
    }

    public boolean validCheeseOption(String toppingName){
        return cheeseOptions.contains(toppingName.toLowerCase().trim());
    }


    public void toppingOption(String toppingName, String toppingType) {
        if (toppingType.equalsIgnoreCase("Meat") && !validMeatOption(toppingName)){
            System.out.println("Invalid meat option, Please choose a valid meat option");
        }
        else if (toppingType.equalsIgnoreCase("Cheese") && !validCheeseOption(toppingName)){
            System.out.println("Invalid cheese option, Please choose a valid cheese option");
        }
    }


    // MAIN CALCULATION
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
            case "4" -> toppingIsExtra ? costMeatSize4 + extraCostMeatSize4 : costMeatSize4;  // 1.00 + 0.5 for extra
            case "8" -> toppingIsExtra ? costMeatSize8 + extraCostMeatSize8 : costMeatSize8;  // 2.00 + 1.00 for extra
            case "12" -> toppingIsExtra ? costMeatSize12 + extraCostMeatSize12 : costMeatSize12; // 3.00 + 1.5 for extra
            default -> 0;
        };
    }

    public double calculateCheeseCost(String sandwichSize, boolean toppingIsExtra){
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? costCheeseSize4 + extraCostCheeseSize4 : costCheeseSize4;  // 0.75 + 0.30 for extra
            case "8" -> toppingIsExtra ? costCheeseSize8 + extraCostCheeseSize8: costCheeseSize8;  // 1.50 + 0.60 for extra
            case "12" -> toppingIsExtra ? costCheeseSize12 + extraCostCheeseSize12 : costCheeseSize12; // 2.25 + 0.90 for extra
            default -> 0;
        };
    }
}
