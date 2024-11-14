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
        toppingsList.add(topping);  // Add the regular topping
    }


    //MAIN CALCULATIONS
    //CALCULATE SANDWICH AND TOPPING PRICE
    @Override
    public double calculatePrice() {
        double sandwichPrice = 0;
        double toppingsCost = 0;

        if (sandwichSize.equals("4")){
            sandwichPrice = sandwichSize4;
        }
        else if (sandwichSize.equals("8")) {
            sandwichPrice = sandwichSize8;
        }
        else if (sandwichSize.equals("12")) {
            sandwichPrice = sandwichSize12;
        }

        for (Toppings toppings : toppingsList){
            //ADDS TOPPINGS PRICE LOOKING AT SANDWICH SIZE
            toppingsCost += toppings.calculateToppingCost(sandwichSize);
        }
        return sandwichPrice + toppingsCost;
    }


    //TO STRING TO OUTPUT
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
