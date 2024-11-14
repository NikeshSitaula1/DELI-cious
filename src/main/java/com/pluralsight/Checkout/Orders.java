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

    @Override
    public String toString() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        // Build the receipt header
        StringBuilder receipt = new StringBuilder("Receipt:\nDate: ").append(formattedDateTime).append("\n");
        receipt.append("-----------------------------\n");

        // Separate items by type
        List<Items> sandwiches = new ArrayList<>();
        List<Items> drinks = new ArrayList<>();
        List<Items> chips = new ArrayList<>();

        for (Items item : itemList) {
            if (item instanceof Sandwich) {
                sandwiches.add(item);
            } else if (item instanceof Drinks) {
                drinks.add(item);
            } else if (item instanceof Chips) {
                chips.add(item);
            }
        }

        // Append sandwiches first
        for (Items sandwich : sandwiches) {
            receipt.append(sandwich.toString()).append("\n");
        }

        // Append drinks next
        for (Items drink : drinks) {
            receipt.append(drink.toString()).append("\n");
        }

        // Append chips last
        for (Items chip : chips) {
            receipt.append(chip.toString()).append("\n");
        }

        // Add the total price
        receipt.append("-----------------------------\n")
                .append("Total: $").append(calculateTotalPrice());

        return receipt.toString();
    }

}
