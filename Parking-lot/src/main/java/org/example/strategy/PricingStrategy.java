package org.example.strategy;

public interface PricingStrategy {
    double calculatePrice(long durationInMinutes);
}
