package com.pluralsight;

public class Sauces implements OrderItem{
    private SauceType type;

    public Sauces(SauceType type) {
        this.type = type;

    }

    @Override
    public double calculteItemCost() {
        return 0;
    }

    @Override
    public String getDescription() {
        return type.name();
    }
}
