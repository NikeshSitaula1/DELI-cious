package com.pluralsight.items;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.checkout.Items;

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


    // ALL CONSTRUCTORS
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

    public Sandwich(){}


    // ALL GETTERS AND SETTERS
    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        if (sandwichSize.equals("4") || sandwichSize.equals("8") || sandwichSize.equals("12")) {
            this.sandwichSize = sandwichSize;
        } else {
            System.out.println("Invalid size. Please choose 4\", 8\", or 12\".");
        }
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


    // ADD TOPPINGS
    public void addTopping(Toppings topping) {
        toppingsList.add(topping);  // Add the regular topping
    }


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
            toppingsCost += toppings.calculateToppingCost(sandwichSize);
        }

        return sandwichPrice + toppingsCost;
    }


    @Override
    public String toString() {
        return "Sandwich{" +
                ", sandwichBread='" + sandwichBread + '\'' +"\n" +
                ", sandwichSize='" + sandwichSize + '\'' + "\n" +
                ", Toppings='" + toppingsList + '\'' + "\n" +
                ", isToasted='" + isToasted + '\'' + "\n" +
                ", price= " + calculatePrice() +
                '}';
    }

}
