package org.example.strategy;

import org.example.enums.SpotType;
import org.example.enums.VehicleType;
import org.example.models.ParkingSpot;
import org.example.models.Vehicle;

public class VehicleSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public boolean isSpotCompatible(Vehicle vehicle, ParkingSpot parkingSpot) {
        if (vehicle.getVehicleType() == VehicleType.BIKE && parkingSpot.getSpotType() == SpotType.SMALL) return true;
        if (vehicle.getVehicleType() == VehicleType.CAR && parkingSpot.getSpotType() == SpotType.MEDIUM) return true;
        if (vehicle.getVehicleType() == VehicleType.TRUCK && parkingSpot.getSpotType() == SpotType.LARGE) return true;
        return false;
    }
}
