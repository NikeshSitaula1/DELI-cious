package com.pluralsight.checkout;

public abstract class Items {

    private String name;
    private int quantity;

    public abstract double calculatePrice();

}
