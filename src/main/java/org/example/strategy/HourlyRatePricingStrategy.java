package org.example.strategy;

public class HourlyRatePricingStrategy implements PricingStrategy{

    private final double hourlyRate;

    public HourlyRatePricingStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(long durationInMinutes) {
        return Math.ceil(durationInMinutes / 60.0) * hourlyRate;
    }
}
