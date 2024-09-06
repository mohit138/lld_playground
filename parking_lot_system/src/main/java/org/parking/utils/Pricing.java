package org.parking.utils;

import org.parking.models.Ticket;

import java.time.Duration;

public final class Pricing {

    // static final int SIXTY_MINUTES = 60;

    public static Integer calculateFees(Ticket ticket){
        int baseFee = ticket.getVehicle().getVehicleType().getBaseFee();
        int hourlyFee = ticket.getVehicle().getVehicleType().getHourlyFee();
        long differenceInMinutes = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toMinutes() - 1;

        return Math.toIntExact(baseFee + hourlyFee * Math.ceilDiv(differenceInMinutes, 1));
    }
}
