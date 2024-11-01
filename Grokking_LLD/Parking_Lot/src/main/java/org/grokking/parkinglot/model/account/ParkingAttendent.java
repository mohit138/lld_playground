package org.grokking.parkinglot.model.account;

public class ParkingAttendent extends Account {
  @Override
  public boolean resetPassword() {
    return false;
  }

  public boolean processTicket(int ticketNo) {
    return true;
  }
}
