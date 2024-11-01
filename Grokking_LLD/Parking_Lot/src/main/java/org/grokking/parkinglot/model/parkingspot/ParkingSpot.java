package org.grokking.parkinglot.model.parkingspot;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.grokking.parkinglot.model.vehicle.Vehicle;

@Getter
@Setter
@ToString
public abstract class ParkingSpot {
  static int cnt = 100;
  private int id;
  private boolean isFree;
  private Vehicle vehicle;

  ParkingSpot() {
    this.id = cnt;
    cnt++;
    this.isFree = true;
  }

  public abstract void assignVehicle(Vehicle vehicle);

  public void removeVehicle() {
    this.vehicle = null;
    isFree = true;
  }
}
