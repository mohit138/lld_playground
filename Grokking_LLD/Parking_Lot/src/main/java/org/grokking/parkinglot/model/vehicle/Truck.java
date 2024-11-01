package org.grokking.parkinglot.model.vehicle;

import org.grokking.parkinglot.model.ParkingTicket;

public class Truck extends Vehicle {

  public Truck(String licenceNo) {
    super(licenceNo);
  }

  @Override
  public void assignVehicle(ParkingTicket ticket) {
    ticket.setVehicle(this);
  }
}
