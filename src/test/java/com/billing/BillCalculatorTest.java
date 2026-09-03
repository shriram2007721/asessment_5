package com.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillCalculatorTest {

    @Test
    public void testUnderLimitUsage() {
        double bill = BillCalculator.calculateTotalBill(Plan.BASIC, 40.0);
        assertEquals(10.0, bill, 0.001);
    }

    @Test
    public void testExactLimitUsage() {
        double bill = BillCalculator.calculateTotalBill(Plan.STANDARD, 150.0);
        assertEquals(20.0, bill, 0.001);
    }

    @Test
    public void testOverageUsage() {
        // Standard limit: 150GB. Overage: 10GB * $1.50 = $15. Total = $35
        double bill = BillCalculator.calculateTotalBill(Plan.STANDARD, 160.0);
        assertEquals(35.0, bill, 0.001);
    }
}
