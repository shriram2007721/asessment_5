package com.billing;

public class BillCalculator {
    public static double calculateTotalBill(Plan plan, double consumedGB) {
        double total = plan.getBasePrice();
        if (consumedGB > plan.getDataLimitGB()) {
            double extraGB = consumedGB - plan.getDataLimitGB();
            total += extraGB * plan.getExtraRatePerGB();
        }
        return total;
    }
}
