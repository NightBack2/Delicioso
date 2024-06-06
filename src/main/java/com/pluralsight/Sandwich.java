package com.pluralsight;
import java.util.List;
import java.util.ArrayList;
public class Sandwich implements OrderItem, ItemCustomizable {
    private SandwichSize size;
    private BreadType breadType;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(SandwichSize size, BreadType breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(Topping topping) {

        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {

        this.toasted = toasted;
    }

    @Override
    public void addTopping(Sauce sauce) {

    }

    // Calculate the total cost of the sandwich

    @Override
    public double calculteItemCost() {
        double totalCost = 0.0;
        // Add base price based on size
        switch (size) {
            case SIZE_4:
                totalCost += 5.50;
                break;
            case SIZE_8:
                totalCost += 7.00;
                break;
            case SIZE_12:
                totalCost += 8.50;
                break;
        }
        for (Topping topping : toppings) {
            totalCost += topping.calculteItemCost();
        }
        if (toasted) {
            totalCost += 0.50;
        }
        return totalCost;


        }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(size).append(" ").append(breadType).append(" Sandwich\n");
        description.append("Toppings:\n");
        for (Topping topping : toppings) {
            description.append("- ").append(topping.getName()).append("\n");
        }
        if (toasted) {
            description.append("Toasted\n");
        }
        return description.toString();
    }
}

