package com.pluralsight;

public class DeliciosoApp {
    private HomrScreen homrScreen;
    private OrderScreen orderScreen;

    private Order currentOrder;

    public DeliciosoApp() {
        homrScreen = new HomrScreenImpl();
        orderScreen = new OrderScreenImpl();
        currentOrder = new Order();
    }
    public void start () {
        boolean running = true;
        while (running) {
            homrScreen.displayOptions();
            int choice = homrScreen.getUserChoice();
            switch (choice) {
                case 1:
                    orderScreen.addSandwich();
                    break;
                case 2:
                    orderScreen.addDrink();
                    break;
                case 3:
                    orderScreen.addChips();
                    break;
                case 4:
                    orderScreen.checkout();
                    break;
                case 0:
                    currentOrder = new Order();
                    break;
                case -1:
                    running = false;
                    break;
                default:
                    System.out.println("Invaild choice. Please enter a valid option.");
            }
        }
        homrScreen.closeScanner();
    }

    public static void main(String[] args) {
        DeliciosoApp app = new DeliciosoApp();
        app.start();
}
}
