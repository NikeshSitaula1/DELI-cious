package com.pluralsight.items;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Items {

    private String sandwichSize;
    private String sandwichBread;
    private List<Toppings> toppingsList =  new ArrayList<Toppings>();

    // ALL CONSTRUCTORS
    public Sandwich(String sandwichSize, String sandwichBread) {
        this.sandwichSize = sandwichSize;
        this.sandwichBread = sandwichBread;
    }

    public Sandwich(String sandwichSize, String sandwichBread, List<Toppings> toppingsList) {
        this.sandwichSize = sandwichSize;
        this.sandwichBread = sandwichBread;
        this.toppingsList = toppingsList;
    }

    public Sandwich(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public Sandwich(){}


    // ALL GETTERS AND SETTERS
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

    public List<Toppings> getToppingsList() {
        return toppingsList;
    }

    public void addTopping(Toppings toppings){
        toppingsList.add(toppings);
    }


    @Override
    public double calculatePrice() {
        double sandwichPrice = 0;
        double toppingsCost = 0;

        if (sandwichSize.equals("4")){
            sandwichPrice = 5.50;
        }
        else if (sandwichSize.equals("8")) {
            sandwichPrice = 7.00;
        }
        else if (sandwichSize.equals("12")) {
            sandwichPrice = 8.50;
        }


        for (Toppings toppings : toppingsList){
            toppingsCost += toppings.calculateToppingCost(sandwichSize);
        }

        return sandwichPrice + toppingsCost;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "sandwichSize='" + sandwichSize + '\'' +
                ", sandwichBread='" + sandwichBread + '\'' +
                ", Toppings='" + toppingsList + '\'' +
                ", price= " + calculatePrice() +
                '}' + "\n";
    }
}
