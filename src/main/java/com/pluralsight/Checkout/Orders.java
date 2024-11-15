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

    //add items
    public void addItems(Items items){
        itemList.add(items);
    }

    //clear items in the order
    public void clearOrder() {
        itemList.clear();
    }

    //TOTAL CALCULATION
    public double calculateTotalPrice() {
        return itemList.stream()
                .mapToDouble(Items::calculatePrice) //Map each item to its price
                .sum(); //Sum up all the prices
    }


    @Override
    public String toString() {
        //getting current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        //receipt header, adds current date and time
        StringBuilder receipt = new StringBuilder("Receipt:\nDate: ").append(formattedDateTime).append("\n");
        receipt.append("-----------------------------------\n");

        //separating items by type
        List<Items> sandwiches = new ArrayList<>();
        List<Items> drinks = new ArrayList<>();
        List<Items> chips = new ArrayList<>();

        //if this object in items is true, add to the type
        for (Items item : itemList) {
            if (item instanceof Sandwich) {
                sandwiches.add(item);
            } else if (item instanceof Drinks) {
                drinks.add(item);
            } else if (item instanceof Chips) {
                chips.add(item);
            }
        }

        //appends sandwich first
        for (Items sandwich : sandwiches) {
            receipt.append(sandwich.toString()).append("\n");
        }

        //appends drinks next
        for (Items drink : drinks) {
            receipt.append(drink.toString()).append("\n");
        }

        //appends chips last
        for (Items chip : chips) {
            receipt.append(chip.toString()).append("\n");
        }

        //adds total price
        receipt.append("-----------------------------------\n")
                .append("Total: $").append(String.format("%.2f", calculateTotalPrice()))
                .append("\n-----------------------------------");

        return receipt.toString();
    }

}
