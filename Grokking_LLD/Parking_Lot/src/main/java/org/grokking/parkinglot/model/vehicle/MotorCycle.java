package org.grokking.parkinglot.model.vehicle;

import org.grokking.parkinglot.model.ParkingTicket;

public class MotorCycle extends Vehicle {

  MotorCycle(String licenceNo) {
    super(licenceNo);
  }

  @Override
  public void assignVehicle(ParkingTicket ticket) {
    ticket.setVehicle(this);
  }
}
