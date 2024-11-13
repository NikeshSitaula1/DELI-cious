package com.pluralsight.Checkout;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Items> itemList = new ArrayList<>();


    public void addItems(Items items){
        itemList.add(items);
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
        StringBuilder summary = new StringBuilder("Order Summary:\n");
        for (Items item : itemList) {
            summary.append(item.toString()).append("\n");
        }
        summary.append("Grand Total: $").append(calculateTotalPrice());
        return summary.toString();
    }
}
