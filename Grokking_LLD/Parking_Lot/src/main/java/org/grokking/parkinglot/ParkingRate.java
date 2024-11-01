package org.grokking.parkinglot;

import java.time.Duration;
import org.grokking.parkinglot.model.ParkingTicket;

public class ParkingRate {
  private double freeHours;
  private double perHourRate;

  ParkingRate() {
    freeHours = 1;
    perHourRate = 20;
  }

  public double calculate(ParkingTicket ticket) {
    // logic is for seconds, to check working.
    long parkedFor =
        Duration.between(ticket.getTimestamp(), ticket.getExitTime()).toSeconds()
            + 1
            - (long) freeHours;
    return perHourRate * parkedFor;
  }
}
