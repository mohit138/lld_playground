package org.grokking.parkinglot.model.vehicle;

import org.grokking.parkinglot.model.ParkingTicket;

public class Car extends Vehicle {

  public Car(String licenceNo) {
    super(licenceNo);
  }

  @Override
  public void assignVehicle(ParkingTicket ticket) {
    ticket.setVehicle(this);
  }
}
