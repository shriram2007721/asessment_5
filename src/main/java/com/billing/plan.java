package com.billing;

public enum Plan {
    BASIC(10.0, 50.0, 2.0),     // 50 GB limit, $10 base, $2/GB extra
    STANDARD(20.0, 150.0, 1.5),  // 150 GB limit, $20 base, $1.5/GB extra
    PREMIUM(35.0, 300.0, 1.0);   // 300 GB limit, $35 base, $1.0/GB extra

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
