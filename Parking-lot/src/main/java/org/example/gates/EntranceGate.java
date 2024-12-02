package org.example.gates;

import org.example.models.ParkingSpot;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.strategy.SpotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class EntranceGate {
    private static int ticketCounter = 0;
    private SpotAllocationStrategy allocationStrategy;

    public EntranceGate(SpotAllocationStrategy allocationStrategy) {
        this.allocationStrategy = allocationStrategy;
    }

    public Ticket issueTicket(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        for (ParkingSpot spot : parkingSpots) {
            if (!spot.isOccupied() && allocationStrategy.isSpotCompatible(vehicle, spot)) {
                spot.setOccupied(true);
                return new Ticket(++ticketCounter, LocalDateTime.now(), spot);
            }
        }
        System.out.println("No parking spot available for Vehicle: " + vehicle.getVehicleNumber());
        return null;
    }
}
