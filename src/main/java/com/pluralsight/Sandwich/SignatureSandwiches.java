package com.pluralsight.Sandwich;

import com.pluralsight.Items.Sandwich;

import java.util.List;

public class SignatureSandwiches extends Sandwich {

    public SignatureSandwiches(String name, int quantity, String sandwichBread, String sandwichSize, String isToasted, List<Toppings> toppingsList) {
        super(name, quantity, sandwichBread, sandwichSize, isToasted, toppingsList);
    }


}
