package com.pluralsight.Checkout;

public abstract class Items {

    private String name;
    private int quantity;

    //CONSTRUCTORS
    public Items(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    //only extending classes can see protected
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
