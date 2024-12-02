package org.example.gates;

import org.example.models.Ticket;
import org.example.strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
    private final PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void processPayment(Ticket ticket) {
        ticket.setExitTime(LocalDateTime.now());
        long duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes();

        double amountDue = pricingStrategy.calculatePrice(duration);
        ticket.getParkingSpot().setOccupied(false);

        System.out.println("Payment processed for Ticket: " + ticket.getTicketId() +
                ". Duration: " + duration + " minutes. Amount due: $" + amountDue);
    }
}
