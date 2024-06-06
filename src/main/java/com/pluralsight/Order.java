package com.pluralsight;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
public class Order {
        private List<OrderItem> items;
        private LocalDateTime orderTime;

        public Order() {
            this.items = new ArrayList<>();
            this.orderTime = LocalDateTime.now();
        }
        public void addItem(OrderItem item) {
            items.add(item);
        }

        public double calculateTotalCost() {
            double totalCost = 0.0;
            for (OrderItem item : items) {
                totalCost += item.calculteItemCost();
            }
            return totalCost;
        }

        public void generateReceipt() {
            try {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
                String fileName = "receipts/" + now.format(formatter) + ".txt";
                FileWriter writer = new FileWriter(fileName);
                writer.write("Order Details:\n");
                for (OrderItem item : items) {
                    writer.write(item.getDescription() + "\n");
                }
                writer.write("Total Cost: $" + calculateTotalCost() + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error generating receipt: " + e.getMessage());
            }
        }

    public OrderItem[] getItems() {
        return new OrderItem[0];
    }
}

