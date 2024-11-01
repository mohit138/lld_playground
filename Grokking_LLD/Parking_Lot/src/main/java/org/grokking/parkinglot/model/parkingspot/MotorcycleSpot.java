package org.grokking.parkinglot.model.parkingspot;

import org.grokking.parkinglot.model.vehicle.Vehicle;

public class MotorcycleSpot extends ParkingSpot {
  public MotorcycleSpot() {
    super();
  }

  @Override
  public void assignVehicle(Vehicle vehicle) {
    this.setVehicle(vehicle);
  }
}
