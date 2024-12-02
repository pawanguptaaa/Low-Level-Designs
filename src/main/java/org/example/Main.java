package org.example;

import org.example.enums.SpotType;
import org.example.enums.VehicleType;
import org.example.factory.ParkingSpotFactory;
import org.example.gates.EntranceGate;
import org.example.gates.ExitGate;
import org.example.models.ParkingSpot;
import org.example.models.Ticket;
import org.example.models.Vehicle;
import org.example.strategy.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // Create parking spots
        ParkingSpotFactory factory = new ParkingSpotFactory();
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        parkingSpots.add(factory.createParkingSpot(1, SpotType.SMALL));
        parkingSpots.add(factory.createParkingSpot(2, SpotType.MEDIUM));
        parkingSpots.add(factory.createParkingSpot(3, SpotType.LARGE));

        // Initialize strategies
        SpotAllocationStrategy allocationStrategy = new VehicleSpotAllocationStrategy();
        PricingStrategy flatRatePricing = new FlatRatePricingStrategy(10.0); // Flat $10 for bikes
        PricingStrategy hourlyRatePricing = new HourlyRatePricingStrategy(2.0); // $2/hour for cars

        // Gates
        EntranceGate entranceGate = new EntranceGate(allocationStrategy);
        ExitGate bikeExitGate = new ExitGate(flatRatePricing);
        ExitGate carExitGate = new ExitGate(hourlyRatePricing);

        // Vehicles
        Vehicle bike = new Vehicle("BIKE123", VehicleType.BIKE);
        Vehicle car = new Vehicle("CAR456", VehicleType.BIKE);

        // Vehicle Entry
        Ticket bikeTicket = entranceGate.issueTicket(bike, parkingSpots); // Spot 1 assigned
        Ticket carTicket = entranceGate.issueTicket(car, parkingSpots);   // Spot 2 assigned

        // Vehicle Exit
        if (bikeTicket != null) {
            bikeExitGate.processPayment(bikeTicket); // Flat rate $10
        }
        if (carTicket != null) {
            carExitGate.processPayment(carTicket); // Hourly rate $4
        }


    }
}