package com.billing;

public class BillCalculator {
    public static double calculateTotalBill(Plan plan, double consumedGB) {
        if (consumedGB < 0) {
            throw new IllegalArgumentException("Data usage cannot be negative.");
        }
        
        double total = plan.getBasePrice();
        if (consumedGB > plan.getDataLimitGB()) {
            double overage = consumedGB - plan.getDataLimitGB();
            total += overage * plan.getExtraRatePerGB();
        }
        return total;
    }
}
