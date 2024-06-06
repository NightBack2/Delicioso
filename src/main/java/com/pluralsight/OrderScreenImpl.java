package com.pluralsight;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class OrderScreenImpl implements OrderScreen{
    private Scanner scanner;
    private Order currentOrder;


    public OrderScreenImpl() {
        scanner = new Scanner(System.in);
        currentOrder = new Order();
    }
    @Override
    public void addSandwich() {
        SandwichSize size = askForSandwich();
        BreadType breadType = askForBreadType();
        Sandwich sandwich = new Sandwich(size, breadType);

        customizeSandwich(sandwich);

        currentOrder.addItem(sandwich);

    }

    private SandwichSize askForSandwich() {
        return null;
    }

    private SandwichSize askForSandwichSize() {
        System.out.println("Select sandwich size:");
        System.out.println("1. 4\"");
        System.out.println("2. 8\"");
        System.out.println("3. 12\"");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return SandwichSize.SIZE_4;
            case 2:
                return SandwichSize.SIZE_8;
            case 3:
                return SandwichSize.SIZE_12;
            default:
                System.out.println("Invalid choice. Defaulting to 4\".");
                return SandwichSize.SIZE_4;
        }

    }

    private BreadType askForBreadType() {
        System.out.println("Select bread type:");
        System.out.println("1. White");
        System.out.println("2. Wheat");
        System.out.println("3. Rye");
        System.out.println("4. Wrap");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return BreadType.WHITE;
            case 2:
                return BreadType.WHEAT;
            case 3:
                return BreadType.RYE;
            case 4:
                return BreadType.WRAP;
            default:
                System.out.println("Invalid choice. Defaulting to White.");
                return BreadType.WHITE;
        }

    }

    private void customizeSandwich(Sandwich sandwich) {
        boolean continueCustomizing = true;
        while (continueCustomizing) {

        System.out.println("Customize toppings:");
        System.out.println("1. Add Lettuce");
        System.out.println("2. Add Tomato");
        System.out.println("3. Add Cheese");
        System.out.println("4. Add Meat");
        System.out.println("5. Add Sauce");
        System.out.println("6. Toasted?");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sandwich.addTopping(new Topping("Lettuce", ToppingCategory.Regular, 0.0));
                break;
            case 2:
                sandwich.addTopping(new Topping("Tomato", ToppingCategory.Regular, 0.0));
                break;
            case 3:
                sandwich.addTopping(new Topping("Cheese", ToppingCategory.Premium, 0.75));
                break;
            case 4:
                sandwich.addTopping(new Topping("Meat", ToppingCategory.Premium, 1.00));
                break;
            case 5:
                addSauceToSandwich(sandwich);
                break;
                System.out.println("Select sauce:");
                System.out.println("1. Mayo");
                System.out.println("2. Mustard");
                System.out.println("3. Ketchup");
                int sauceChoice = scanner.nextInt();
                SauceType sauceType;
                switch (sauceChoice) {
                    case 1:
                        sauceType = SauceType.MAYO;
                        break;
                    case 2:
                        sauceType = SauceType.MUSTARD;
                        break;
                    case 3:
                        sauceType = SauceType.KETCHUP;
                        break;
                    default:
                        sauceType = SauceType.MAYO; // Defaulting to Mayo
                        break;
                }
                sandwich.addTopping(new Sauce(sauceType));
                break;
            case 6:
                System.out.println("Toast the sandwich? (Y/N)");
                String toastChoice = scanner.next();
                sandwich.setToasted(toastChoice.equalsIgnoreCase("Y"));
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
            System.out.println("Continue customizing? (Y/N)");
            String continueChoice = scanner.next();
            continueCustomizing = continueChoice.equalsIgnoreCase("Y");

    }


    @Override
    public void addDrink() {
        String size =  askForDrinkSize();
        String flavor = askForDrinkFlavor();
        Drink drink = new Drink(size, flavor, getDrinkPrice(size));

        currentOrder.addItem(drink);

    }

    private String askForDrinkSize() {
        System.out.println("Select drink size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Small";
            case 2:
                return "Medium";
            case 3:
                return "Large";
            default:
                System.out.println("Invalid choice. Defaulting to Small.");
                return "Small";
        }

    }

    private String askForDrinkFlavor() {
        System.out.println("Enter drink flavor:");
        scanner.nextLine();
        return scanner.nextLine();

    }

    private double getDrinkPrice(String size) {
        return 2.00;

    }


    @Override
    public void addChips() {
        String type = askForChipType();
        Chips chips = new Chips(type, getChipPrice());


        currentOrder.addItem(chips);

    }

    private String askForChipType() {
        System.out.println("Select chip type:");
        System.out.println("1. Regular");
        System.out.println("2. Barbecue");
        System.out.println("3. Sour Cream & Onion");
        System.out.println("4. Salt & Vinegar");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Regular";
            case 2:
                return "Barbecue";
            case 3:
                return "Sour Cream & Onion";
            case 4:
                return "Salt & Vinegar";
            default:
                System.out.println("Invalid choice. Defaulting to Regular.");
                return "Regular";
        }

    }

    private double getChipPrice() {
        return 1.50;

    }

    @Override
    public void checkout() {
        displayOrderDetails();
        double totalCost = 0; currentOrder.calculateTotalCost();
        System.out.println("Total Cost: $" + totalCost);

        if(confirmOrder()) {
            currentOrder.generateReceipt();
            System.out.println("Receipt generated successfully.");
        } else {
            System.out.println("Order canceled.");
        }

    }

    private void displayOrderDetails() {
        System.out.println("Order Details:");
        for (OrderItem item : currentOrder.getItems()) {
            System.out.println(item.getDescription());
        }

    }

    private boolean confirmOrder() {
            // Logic to ask user for confirmation and return true/false based on their choice
            System.out.println("Confirm order? (Y/N)");
            String choice = scanner.next();
            return choice.equalsIgnoreCase("Y");
        }


    public void cancelOrder() {

    }
    private void generateReceipt() {
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = "receipts/" + now.format(formatter) + ".txt";
            FileWriter writer = new FileWriter(fileName);
            writer.write("Order Details:\n");
            for (OrderItem item : currentOrder.getItems()) {
                writer.write(item.getDescription() + "\n");
            }
            writer.write("Total Cost: $" + currentOrder.calculateTotalCost() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error generating receipt: " + e.getMessage());
        }}
}

    private double getChipPrice() {
    }

    private String askForChipType() {
    }

    private void addSauceToSandwich(Sandwich sandwich) {
        System.out.println("Select sauce:");
        System.out.println("1. Mayo");
        System.out.println("2. Mustard");
        System.out.println("3. Ketchup");
        int sauceChoice = scanner.nextInt();
        switch (sauceChoice) {
            case 1:
                sandwich.addTopping(new Topping("Mayo", ToppingCategory.Sauce, 0.0));
                break;
            case 2:
                sandwich.addTopping(new Topping("Mustard", ToppingCategory.Sauce, 0.0));
                break;
            case 3:
                sandwich.addTopping(new Topping("Ketchup", ToppingCategory.Sauce, 0.0));
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }