package org.grokking.parkinglot.model.parkingspot;

import org.grokking.parkinglot.model.vehicle.Vehicle;

public class Compact extends ParkingSpot {
  public Compact() {
    super();
  }

  @Override
  public void assignVehicle(Vehicle vehicle) {
    this.setVehicle(vehicle);
  }
}
