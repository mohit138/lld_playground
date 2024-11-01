package org.grokking.parkinglot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.grokking.parkinglot.model.ParkingTicket;
import org.grokking.parkinglot.model.parkingspot.Compact;
import org.grokking.parkinglot.model.parkingspot.Large;
import org.grokking.parkinglot.model.parkingspot.MotorcycleSpot;
import org.grokking.parkinglot.model.vehicle.Car;
import org.grokking.parkinglot.model.vehicle.MotorCycle;
import org.grokking.parkinglot.model.vehicle.Truck;
import org.grokking.parkinglot.model.vehicle.Vehicle;

@Getter
@AllArgsConstructor
public class Entrance {
  private int id;

  public ParkingTicket getTicket(Vehicle vehicle) throws Exception {
    String spotType = getSpotType(vehicle);

    ParkingTicket generatedTicket = ParkingLot.getInstance().getParkingTicket(vehicle, spotType);
    generatedTicket.setEntry(this);
    return generatedTicket;
  }

  private String getSpotType(Vehicle vehicle) throws Exception {
    String vehicleType = vehicle.getClass().getSimpleName();
    ParkingLot parkingLot = ParkingLot.getInstance();

    if (vehicleType.equals(MotorCycle.class.getSimpleName())) {
      if (!parkingLot.isFull(MotorcycleSpot.class.getSimpleName())) {
        return MotorcycleSpot.class.getSimpleName();
      }
    } else if (vehicleType.equals(Car.class.getSimpleName())) {
      if (!parkingLot.isFull(Compact.class.getSimpleName())) {
        return Compact.class.getSimpleName();
      } else if (!parkingLot.isFull(Large.class.getSimpleName())) {
        return Large.class.getSimpleName();
      }
    } else if (vehicleType.equals(Truck.class.getSimpleName())) {
      if (!parkingLot.isFull(Large.class.getSimpleName())) {
        return Large.class.getSimpleName();
      }
    }

    throw new Exception("Spot type is not available!");
  }
}
