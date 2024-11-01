package org.grokking.parkinglot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.grokking.parkinglot.model.ParkingTicket;
import org.grokking.parkinglot.model.parkingspot.ParkingSpot;
import org.grokking.parkinglot.model.vehicle.Vehicle;

@Getter
@ToString
public class ParkingLot {
  private int id;
  private String name;
  private String address;
  private ParkingRate parkingRate;

  private SpotManager spotManager;

  private HashMap<Integer, Entrance> entrances;
  private HashMap<Integer, Exit> exits;

  // liscence no, ticket -> map
  private HashMap<String, ParkingTicket> tickets;

  private static ParkingLot parkingLot = null;

  private ParkingLot() {
    id = 1;
    name = "Main Parking Lot";
    address = "Main PArking Lot, Near Beach Road";
    parkingRate = new ParkingRate();
    spotManager = new SpotManager();

    entrances = new HashMap<>();
    exits = new HashMap<>();
    tickets = new HashMap<>();
  }

  public static ParkingLot getInstance() {
    if (parkingLot == null) {
      parkingLot = new ParkingLot();
    }
    return parkingLot;
  }

  public boolean addEntrance(Entrance entrance) {
    entrances.put(entrance.getId(), entrance);
    return true;
  }

  public boolean addExit(Exit exit) {
    exits.put(exit.getId(), exit);
    return true;
  }

  // This function allows parking tickets to be available at multiple entrances
  public ParkingTicket getParkingTicket(Vehicle vehicle, String spotType) {
    // logic to generate ticket.
    ParkingTicket ticket = new ParkingTicket(vehicle);
    // we will have to add vehicle to a parking spot, add vehicle to ticket.
    spotManager.assignParkingSpot(vehicle, spotType);
    // And store ticket for licence plate.
    tickets.put(vehicle.getLiscenseNo(), ticket);
    return ticket;
  }

  public boolean addParkingSpot(ParkingSpot spot) {
    return spotManager.addParkingSpot(spot.getClass().getSimpleName(), spot);
  }

  public boolean isFull(String spotType) {
    return !spotManager.hasAvailableSpots(spotType);
  }
}

@ToString
class SpotManager {
  // spot type,
  private HashMap<String, HashSet<ParkingSpot>>
      spots; // using hashSet for quick access. Can use List as well
  HashMap<String, Integer> availableSpots;

  SpotManager() {
    spots = new HashMap<>();
    availableSpots = new HashMap<>();
  }

  public boolean addParkingSpot(String type, ParkingSpot spot) {
    if (!spots.containsKey(type)) {
      spots.put(type, new HashSet<>());
    }
    if (!availableSpots.containsKey(type)) {
      availableSpots.put(type, 0);
    }
    spots.get(type).add(spot);
    availableSpots.put(type, availableSpots.get(type) + 1);
    return true;
  }

  public boolean hasAvailableSpots(String type) {
    return (availableSpots.get(type) > 0);
  }

  public void assignParkingSpot(Vehicle vehicle, String spotType) {
    if (availableSpots.get(spotType) == 0) {
      System.out.println("No slots available !!");
    }

    for (ParkingSpot spot : spots.get(spotType)) {
      if (spot.isFree()) {
        spot.assignVehicle(vehicle);
        spot.setFree(false);
        break;
      }
    }

    availableSpots.put(spotType, availableSpots.get(spotType) - 1);
  }

  public void freeParkingSlot(Vehicle vehicle) {
    for (String spotType : availableSpots.keySet()) {
      for (ParkingSpot spot : spots.get(spotType)) {
        if (Objects.nonNull(spot.getVehicle()) && spot.getVehicle().equals(vehicle)) {
          spot.removeVehicle();
          availableSpots.put(spotType, availableSpots.get(spotType) + 1);
          return;
        }
      }
    }

    System.out.println("Vehicle Is Not Present in System !!!");
  }
}
