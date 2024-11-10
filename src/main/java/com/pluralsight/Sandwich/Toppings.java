package com.pluralsight.Sandwich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Toppings {

    private String toppingName;
    private String toppingType;
    private boolean toppingIsPremium;
    private boolean toppingIsExtra;


    // FIXED VALUES
    private final List<String> meatOptions = new ArrayList<>(List.of("Steak","Ham","Salami","Roast beef","Chicken","Bacon"));
    private final List<String> cheeseOptions = new ArrayList<>(List.of("American", "Provolone","Cheddar","Swiss"));
    private final List<String> regularOptions = new ArrayList<>(List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos",
                                                                        "Cucumbers", "Pickles", "Guacamole", "Mushrooms"));
    private final List<String> sauceOptions = new ArrayList<>(List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"));

    private final double costMeatSize4= 1.00, costMeatSize8= 2.00, costMeatSize12= 3.00;
    private final double extraCostMeatSize4= 0.50, extraCostMeatSize8= 1.00, extraCostMeatSize12= 1.50;
    private final double costCheeseSize4= 0.75, costCheeseSize8= 1.50, costCheeseSize12= 2.25;
    private final double extraCostCheeseSize4= 0.30, extraCostCheeseSize8= 0.60, extraCostCheeseSize12= 0.90;



    // CONSTRUCTORS
    public Toppings(String toppingName, String toppingType, boolean toppingIsExtra) {
        this.toppingName = toppingName;
        this.toppingType = toppingType;
        this.toppingIsPremium = toppingType.equalsIgnoreCase("Meat") || toppingType.equalsIgnoreCase("Cheese");
        this.toppingIsExtra = toppingIsExtra;
    }


    // GETTERS AND SETTERS
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

    public boolean validRegularOption(String toppingName){
        return regularOptions.contains(toppingName.toLowerCase().trim());
    }

    public boolean validSauceOptions(String toppingName){
        return sauceOptions.contains(toppingName.toLowerCase().trim());
    }


    public void toppingOption(String toppingName, String toppingType) {
        if (toppingType.equalsIgnoreCase("Meat") && !validMeatOption(toppingName)){
            System.out.println("Invalid meat option, Please choose a valid meat option");
        }
        if (toppingType.equalsIgnoreCase("Cheese") && !validCheeseOption(toppingName)){
            System.out.println("Invalid cheese option, Please choose a valid cheese option");
        }
        if (toppingType.equalsIgnoreCase("Regular") && !validRegularOption(toppingName)){
            System.out.println("Invalid Regular option, Please choose a valid Regular topping option");
        }
        if (toppingType.equalsIgnoreCase("Sauce") && !validSauceOptions(toppingName)){
            System.out.println("Invalid Sauce option, Please choose a valid sauce option");
        }
    }


    // MAIN CALCULATION
    public double calculateToppingCost(String sandwichSize) {


        if (toppingType.equalsIgnoreCase("Meat")){
             return calculateMeatCost(sandwichSize);
        }
        else if (toppingType.equalsIgnoreCase("Cheese")){
             return calculateCheeseCost(sandwichSize);
        }
        else {
            return 0;
        }

    }

    public double calculateMeatCost(String sandwichSize){
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? costMeatSize4 + extraCostMeatSize4 : costMeatSize4;  // 1.00 + 0.5 for extra
            case "8" -> toppingIsExtra ? costMeatSize8 + extraCostMeatSize8 : costMeatSize8;  // 2.00 + 1.00 for extra
            case "12" -> toppingIsExtra ? costMeatSize12 + extraCostMeatSize12 : costMeatSize12; // 3.00 + 1.5 for extra
            default -> 0;
        };
    }

    public double calculateCheeseCost(String sandwichSize){
        return switch (sandwichSize) {
            case "4" -> toppingIsExtra ? costCheeseSize4 + extraCostCheeseSize4 : costCheeseSize4;  // 0.75 + 0.30 for extra
            case "8" -> toppingIsExtra ? costCheeseSize8 + extraCostCheeseSize8: costCheeseSize8;  // 1.50 + 0.60 for extra
            case "12" -> toppingIsExtra ? costCheeseSize12 + extraCostCheeseSize12 : costCheeseSize12; // 2.25 + 0.90 for extra
            default -> 0;
        };
    }

    @Override
    public String toString() {
        String toppingDescription = "Topping: " + toppingName;
        if (toppingIsExtra) {
            toppingDescription += " (Extra)";
        }
        return toppingDescription;
    }
}
