package org.grokking.parkinglot;

import lombok.Getter;

@Getter
public class DisplayBoard {

  private int id;

  DisplayBoard(int id) {
    this.id = id;
  }

  void showFreeSlots() {
    SpotManager spotManager = ParkingLot.getInstance().getSpotManager();
    for (String spotType : spotManager.availableSpots.keySet()) {
      System.out.println(
          "For " + spotType + " we have - " + spotManager.availableSpots.get(spotType) + " slots.");
    }
  }
}
