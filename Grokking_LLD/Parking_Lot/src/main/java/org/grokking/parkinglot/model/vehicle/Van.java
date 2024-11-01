package org.grokking.parkinglot.model.vehicle;

import org.grokking.parkinglot.model.ParkingTicket;

public class Van extends Vehicle {

  Van(String licenceNo) {
    super(licenceNo);
  }

  @Override
  public void assignVehicle(ParkingTicket ticket) {
    ticket.setVehicle(this);
  }
}
