package org.example.factory;

import org.example.enums.SpotType;
import org.example.models.ParkingSpot;

public class ParkingSpotFactory {
    public ParkingSpot createParkingSpot(int spotId, SpotType spotType) {
        return new ParkingSpot(spotId, spotType);
    }
}
