package com.pluralsight.items;

import com.pluralsight.Sandwich.Toppings;
import com.pluralsight.checkout.Items;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Items {

    private String sandwichSize;
    private String sandwichBread;
    private List<Toppings> toppingsList =  new ArrayList<Toppings>();

    public Sandwich(String sandwichSize, String sandwichBread) {
        this.sandwichSize = sandwichSize;
        this.sandwichBread = sandwichBread;
    }

    public Sandwich(){}

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

    public void setToppingsList(List<Toppings> toppingsList) {
        this.toppingsList = toppingsList;
    }



    @Override
    public double calculatePrice() {
        return 0;
    }
}
