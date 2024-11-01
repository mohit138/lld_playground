package org.grokking.parkinglot.model.vehicle;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.grokking.parkinglot.model.ParkingTicket;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class Vehicle {
  private String liscenseNo;

  Vehicle(String licenceNo) {
    this.liscenseNo = licenceNo;
  }

  public abstract void assignVehicle(ParkingTicket ticket);
}
