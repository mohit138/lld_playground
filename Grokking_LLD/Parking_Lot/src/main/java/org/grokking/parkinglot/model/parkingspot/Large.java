package org.grokking.parkinglot.model.parkingspot;

import org.grokking.parkinglot.model.vehicle.Vehicle;

public class Large extends ParkingSpot {
  public Large() {
    super();
  }

  @Override
  public void assignVehicle(Vehicle vehicle) {
    this.setVehicle(vehicle);
  }
}
