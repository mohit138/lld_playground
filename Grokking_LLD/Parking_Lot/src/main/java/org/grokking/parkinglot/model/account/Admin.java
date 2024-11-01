package org.grokking.parkinglot.model.account;

import org.grokking.parkinglot.DisplayBoard;
import org.grokking.parkinglot.Entrance;
import org.grokking.parkinglot.Exit;
import org.grokking.parkinglot.model.parkingspot.ParkingSpot;

public class Admin extends Account {
  @Override
  public boolean resetPassword() {
    return false;
  }

  public boolean addParkingSpot(ParkingSpot spot) {
    return true;
  }

  public boolean addDisplayBoard(DisplayBoard board) {
    return true;
  }

  public boolean addEntrance(Entrance entrance) {
    return true;
  }

  public boolean addExit(Exit exit) {
    return true;
  }
}
