package org.grokking.parkinglot;

import org.grokking.parkinglot.model.ParkingTicket;
import org.grokking.parkinglot.model.parkingspot.Compact;
import org.grokking.parkinglot.model.parkingspot.Large;
import org.grokking.parkinglot.model.parkingspot.MotorcycleSpot;
import org.grokking.parkinglot.model.vehicle.Car;
import org.grokking.parkinglot.model.vehicle.Truck;
import org.grokking.parkinglot.model.vehicle.Vehicle;

public class Main {
  public static void main(String[] args) {
    Entrance ent1 = new Entrance(1);
    Entrance ent2 = new Entrance(2);
    ParkingLot.getInstance().addEntrance(ent1);
    ParkingLot.getInstance().addEntrance(ent2);

    Exit exit1 = new Exit(1);
    Exit exit2 = new Exit(2);
    ParkingLot.getInstance().addExit(exit1);
    ParkingLot.getInstance().addExit(exit2);

    genSpots();

    System.out.println(ParkingLot.getInstance().getSpotManager().toString());

    Vehicle car1 = new Car("CAR_1");

    Truck t1 = new Truck("t1");
    Truck t2 = new Truck("t2");
    Truck t3 = new Truck("t3");
    Truck t4 = new Truck("t4");

    try {
      ParkingTicket car1Ticket = ent1.getTicket(car1);
      ParkingTicket tt1 = ent2.getTicket(t1);
      ParkingTicket tt2 = ent2.getTicket(t2);
      ParkingTicket tt3 = ent1.getTicket(t3);
      ParkingTicket tt4 = ent1.getTicket(t4);

      System.out.println(ParkingLot.getInstance().getSpotManager().toString());

      Thread.sleep(3000);
      exit2.processExit("CAR_1", true);
      exit1.processExit("t1", true);
      exit2.processExit("t2", true);
      exit1.processExit("t3", true);
      exit2.processExit("t4", true);

      System.out.println(ParkingLot.getInstance().getSpotManager().toString());

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  static void genSpots() {
    for (int i = 0; i < 6; i++) {
      ParkingLot.getInstance().addParkingSpot(new MotorcycleSpot());
    }
    for (int i = 0; i < 4; i++) {
      ParkingLot.getInstance().addParkingSpot(new Large());
    }
    for (int i = 0; i < 8; i++) {
      ParkingLot.getInstance().addParkingSpot(new Compact());
    }
  }
}
