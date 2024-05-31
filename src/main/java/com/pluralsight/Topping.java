package com.pluralsight;

public  class Topping implements OrderItem {
    public  String name;
    public  ToppingCategory category;
    public  double additionalCost;

    public Topping(String name, ToppingCategory category, double additionalCost) {
        this.name = name;
        this.category = category;
        this.additionalCost = additionalCost;
    }

    // Getters
    public String getName() {

        return name;
    }

    public ToppingCategory getCategory() {

        return category;
    }

    public double getAdditionalCost() {

        return additionalCost;
    }

    @Override
    public double calculteItemCost() {
        return additionalCost;
    }

    @Override
    public String getDescription() {
        return name;
    }
}


