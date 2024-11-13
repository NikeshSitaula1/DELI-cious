package com.pluralsight.Checkout;

public abstract class Items {

    private String name;
    private int quantity;

    public Items(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    protected Items() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculatePrice();


}
