package org.grokking.parkinglot.model.parkingspot;

import org.grokking.parkinglot.model.vehicle.Vehicle;

public class Handicapped extends ParkingSpot {
  Handicapped() {
    super();
  }

  @Override
  public void assignVehicle(Vehicle vehicle) {
    this.setVehicle(vehicle);
  }
}
