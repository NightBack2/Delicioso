package com.pluralsight;

public class Drink implements OrderItem{
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }

    // Getters
    public String getSize() {

        return size;
    }

    public String getFlavor() {

        return flavor;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculteItemCost() {
        return price;
    }

    @Override
    public String getDescription() {

        return size + "" + flavor + " Drink";
    }
}

