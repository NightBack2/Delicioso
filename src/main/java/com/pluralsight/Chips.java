package com.pluralsight;

public class Chips implements OrderItem {
        private String type;
        private double price;

    public Chips(String type, double price) {
        this.type = type;
        this.price = price;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculteItemCost() {
        return price ;
    }

    @Override
    public String getDescription() {
        return type + "chips";
    }
}


