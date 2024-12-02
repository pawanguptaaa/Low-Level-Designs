package org.example.models;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingSpot parkingSpot;

    public Ticket(int ticketId, LocalDateTime entryTime, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.parkingSpot = parkingSpot;
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() { // Add this getter
        return exitTime;
    }


    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
