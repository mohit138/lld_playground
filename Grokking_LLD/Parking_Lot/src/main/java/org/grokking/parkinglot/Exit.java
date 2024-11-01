package org.grokking.parkinglot;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.grokking.parkinglot.enums.PaymentStatus;
import org.grokking.parkinglot.model.ParkingTicket;
import org.grokking.parkinglot.model.payment.Card;
import org.grokking.parkinglot.model.payment.Cash;
import org.grokking.parkinglot.model.payment.Payment;
import org.grokking.parkinglot.model.vehicle.Vehicle;

@Getter
@AllArgsConstructor
public class Exit {
  private int id;

  public void validateTicket(ParkingTicket ticket) {}

  public void processExit(String liscenseNo, boolean isCardPayment) {
    // get ticket from liscense no.
    ParkingTicket ticket = ParkingLot.getInstance().getTickets().get(liscenseNo);
    ticket.setExit(this);
    ticket.setExitTime(LocalDateTime.now());
    Vehicle currentVehicle = ticket.getVehicle();
    // free up slot
    ParkingLot.getInstance().getSpotManager().freeParkingSlot(currentVehicle);

    // calculate price
    ticket.setAmount(ParkingLot.getInstance().getParkingRate().calculate(ticket));

    Payment payment;
    // process payment.
    if (isCardPayment) {
      payment = new Card();
    } else {
      payment = new Cash();
    }
    payment.setTimestamp(LocalDateTime.now());
    payment.setAmount(ticket.getAmount());

    ticket.setPayment(payment);
    ticket.getPayment().initiateTransaction();

    ticket.getPayment().setStatus(PaymentStatus.COMPLETED);

    // close ticket
    ticket.setStatus(false);
    ParkingLot.getInstance().getTickets().put(liscenseNo, ticket);
  }
}
