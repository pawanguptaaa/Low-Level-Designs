package org.example.strategy;

import org.example.models.ParkingSpot;
import org.example.models.Vehicle;

public interface SpotAllocationStrategy {
    boolean isSpotCompatible(Vehicle vehicle, ParkingSpot parkingSpot);
}
