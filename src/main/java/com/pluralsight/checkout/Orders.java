package com.pluralsight.checkout;

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


}
