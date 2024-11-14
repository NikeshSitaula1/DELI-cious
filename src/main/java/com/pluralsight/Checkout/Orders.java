package com.pluralsight.Checkout;

import com.pluralsight.Items.Chips;
import com.pluralsight.Items.Drinks;
import com.pluralsight.Items.Sandwich;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Items> itemList = new ArrayList<>();

    public void addItems(Items items){
        itemList.add(items);
    }

    public void clearOrder() {
        itemList.clear();
    }

    public double calculateTotalPrice(){
        double orderTotalPrice = 0;

        for (Items items : itemList){
            orderTotalPrice += items.calculatePrice();
        }

        return orderTotalPrice;
    }

    //TO-STRING
    @Override
    public String toString() {
        //GETTING CURRENT DATE AND TIME
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        //RECEIPT HEADER, ADDS CURRENT DATE AND TIME
        StringBuilder receipt = new StringBuilder("Receipt:\nDate: ").append(formattedDateTime).append("\n");
        receipt.append("-----------------------------\n");

        //SEPARATING ITEMS BY TYPE
        List<Items> sandwiches = new ArrayList<>();
        List<Items> drinks = new ArrayList<>();
        List<Items> chips = new ArrayList<>();

        //IF THIS OBJECT IN ITEMS IS TRUE, ADD TO THE TYPE
        for (Items item : itemList) {
            if (item instanceof Sandwich) {
                sandwiches.add(item);
            } else if (item instanceof Drinks) {
                drinks.add(item);
            } else if (item instanceof Chips) {
                chips.add(item);
            }
        }

        //APPENDS SANDWICH FIRST
        for (Items sandwich : sandwiches) {
            receipt.append(sandwich.toString()).append("\n");
        }

        //APPENDS DRINKS NEXT
        for (Items drink : drinks) {
            receipt.append(drink.toString()).append("\n");
        }

        //APPENDS CHIPS LAST
        for (Items chip : chips) {
            receipt.append(chip.toString()).append("\n");
        }

        //ADDS TOTAL PRICE
        receipt.append("-----------------------------\n")
                .append("Total: $").append(calculateTotalPrice());

        return receipt.toString();
    }

}
