package com.pluralsight;
import java.util.Scanner;
public class HomrScreenImpl implements HomrScreen {
    private Scanner scanner;

    public HomrScreenImpl(){
        scanner = new Scanner(System.in);
    }
    @Override
    public void displayOptions() {
        System.out.println("Welcome To DELIcioso !!!");
        System.out.println("THE BEST DELI IN NEW YORK!");
        System.out.println("1. Add Sandwich");
        System.out.println("2. Add Drink");
        System.out.println("3. Add Chips");
        System.out.println("4. Checkout");
        System.out.println("0. Cancel Order");

    }
    public int getUserChoice() {
        System.out.println("Enter your choice: ");
                return scanner.nextInt();
    }
    public void closeScanner() {
        scanner.close();
    }
}
