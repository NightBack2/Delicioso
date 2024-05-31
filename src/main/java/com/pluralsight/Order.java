package com.pluralsight;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
public class Order {
        private List<OrderItem> items;
        private LocalDateTime> orderTime;

        public Order() {
            this.items = new ArrayList<>();
            this.orderTime = LocalDateTime.now();
        }
        public void addItem(OrderItem Item {
            items.add(item);
        }

        public double calculateTotalCost() {
            double totalCost = 0.0;
            for (OrderItem item : items) {
                totalCost += item.calculateItemCost();
            }
            return totalCost;
        }

        public void generateReceipt(){
         String fileName = "receipts/" + orderTime.format(DateTimeFormatter.ofPattern("yyyy-mm-dd")) + " .txt"
        }


    @Override
    public void processOrder(Order order) {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();

    }
    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    // Add drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Add chips to the order
    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    // Calculate the total cost of the order
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Sandwich sandwich : sandwiches) {
            totalCost += sandwich.calculateTotalCost();
        }
        for (Drink drink : drinks) {
            totalCost += drink.getPrice();
        }
        for (Chips chip : chips) {
            totalCost += chip.getPrice();
        }
        return totalCost;
    }
}

