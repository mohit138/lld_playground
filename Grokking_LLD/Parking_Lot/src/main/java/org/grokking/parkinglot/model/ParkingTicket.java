package org.grokking.parkinglot.model;

import java.time.LocalDateTime;
import lombok.*;
import org.grokking.parkinglot.Entrance;
import org.grokking.parkinglot.Exit;
import org.grokking.parkinglot.model.payment.Payment;
import org.grokking.parkinglot.model.vehicle.Vehicle;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ParkingTicket {
  static int cnt = 1000;
  private int ticketNo;
  private LocalDateTime timestamp;
  private LocalDateTime exitTime;
  private double amount;
  private boolean status;

  public ParkingTicket(Vehicle vehicle) {
    ticketNo = cnt;
    cnt++;
    timestamp = LocalDateTime.now();
    status = true;
    this.vehicle = vehicle;
  }

  private Vehicle vehicle;
  private Payment payment;
  private Entrance entry;
  private Exit exit;
}
