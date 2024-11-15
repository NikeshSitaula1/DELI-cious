package com.pluralsight.Items;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.Checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Items {

    private String sandwichBread;
    private String sandwichSize;
    private String isToasted;
    private List<Toppings> toppingsList =  new ArrayList<Toppings>();

    //FIXED VALUES
    private List<String> breadOptions = new ArrayList<>(List.of("White Bread", "Wheat", "Rye", "Wrap"));
    private static final double sandwichSize4= 5.50, sandwichSize8= 7.00, sandwichSize12= 8.50;


    //ALL CONSTRUCTORS
    public Sandwich(String name, int quantity, String sandwichBread, String sandwichSize, String isToasted) {
        super(name, quantity);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
    }

    public Sandwich(String name, int quantity, String sandwichBread, String sandwichSize,  String isToasted, List<Toppings> toppingsList) {
        super(name, quantity);
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
        this.toppingsList = toppingsList;
    }

    public Sandwich(String name, int quantity, String sandwichSize) {
        super(name, quantity);
        this.sandwichSize = sandwichSize;
    }

    public Sandwich(String sandwichBread, String sandwichSize, String isToasted) {
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
    }

    public Sandwich(String sandwichBread, String sandwichSize, List<Toppings> toppingsList, String isToasted) {
        this.sandwichBread = sandwichBread;
        this.sandwichSize = sandwichSize;
        this.toppingsList = new ArrayList<>(toppingsList);
        this.isToasted = isToasted;
    }

    public Sandwich(){}


    //ALL GETTERS AND SETTERS
    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public String getSandwichBread() {
        return sandwichBread;
    }

    public void setSandwichBread(String sandwichBread) {
        this.sandwichBread = sandwichBread;
    }

    public String isToasted() {
        return isToasted;
    }

    public void setToasted(String toasted) {
        this.isToasted = toasted;
    }

    public List<Toppings> getToppingsList() {
        return toppingsList;
    }

    public List<String> getBreadOptions(){
        return breadOptions;
    }


    //ADD TOPPINGS
    public void addTopping(Toppings topping) {
        toppingsList.add(topping);  //Add the regular topping
    }


    //MAIN CALCULATIONS
    //calculate sandwich and topping price
    @Override
    public double calculatePrice() {

        double sandwichPrice = switch (sandwichSize) {
            case "4" -> sandwichSize4;
            case "8" -> sandwichSize8;
            case "12" -> sandwichSize12;
            default -> 0;
        };

        double toppingsCost = toppingsList.stream()
                .mapToDouble(topping -> topping.calculateToppingCost(sandwichSize))
                .sum();
        return sandwichPrice + toppingsCost;
    }


    @Override
    public String toString() {
        StringBuilder sandwichDescription = new StringBuilder("Sandwich: Custom Sandwich\n");
        sandwichDescription.append("  Size: ").append(sandwichSize).append("\n")
                .append("  Bread: ").append(sandwichBread).append("\n")
                .append("  Toasted: ").append(isToasted).append("\n")
                .append("  Toppings:\n");

        //TOPPING TO-STRING WILL SHOW UP HERE
        for (Toppings topping : toppingsList) {
            sandwichDescription.append("    ").append(topping.toString()).append("\n");
        }

        double sandwichPrice = calculatePrice();
        sandwichDescription.append("  Total: $").append(String.format("%.2f",sandwichPrice));
        return sandwichDescription.toString();
    }
}
