package org.example.strategy;

public class FlatRatePricingStrategy implements PricingStrategy{

    private final double flatRate;

    public FlatRatePricingStrategy(double flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public double calculatePrice(long durationInMinutes) {
        return flatRate;
    }
}
