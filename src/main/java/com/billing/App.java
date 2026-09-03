package com.billing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Internet Data Usage Billing System ===");
        
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Select Plan (BASIC, STANDARD, PREMIUM): ");
            String planInput = scanner.nextLine().trim().toUpperCase();
            
            Plan selectedPlan;
            try {
                selectedPlan = Plan.valueOf(planInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Plan Type. Please start over.");
                continue;
            }

            System.out.print("Enter Data Consumed (in GB): ");
            double dataUsage;
            try {
                dataUsage = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid numeric value for data usage.");
                continue;
            }

            try {
                double finalBill = BillCalculator.calculateTotalBill(selectedPlan, dataUsage);
                System.out.println("\n--- INVOICE ---");
                System.out.println("Customer Name: " + name);
                System.out.println("Selected Plan: " + selectedPlan.name());
                System.out.println("Data Allowed:  " + selectedPlan.getDataLimitGB() + " GB");
                System.out.println("Data Consumed: " + dataUsage + " GB");
                System.out.printf("Total Monthly Amount Due: $%.2f\n", finalBill);
                System.out.println("----------------");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("System exited. Goodbye!");
        scanner.close();
    }
}
