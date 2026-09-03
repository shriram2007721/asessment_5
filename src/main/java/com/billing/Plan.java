package com.billing;

public enum Plan {
    BASIC(10.0, 50.0, 2.0),      // $10 base, 50 GB cap, $2 per extra GB
    STANDARD(20.0, 150.0, 1.5),  // $20 base, 150 GB cap, $1.50 per extra GB
    PREMIUM(35.0, 300.0, 1.0);   // $35 base, 300 GB cap, $1 per extra GB

    private final double basePrice;
    private final double dataLimitGB;
    private final double extraRatePerGB;

    Plan(double basePrice, double dataLimitGB, double extraRatePerGB) {
        this.basePrice = basePrice;
        this.dataLimitGB = dataLimitGB;
        this.extraRatePerGB = extraRatePerGB;
    }

    public double getBasePrice() { return basePrice; }
    public double getDataLimitGB() { return dataLimitGB; }
    public double getExtraRatePerGB() { return extraRatePerGB; }
}
