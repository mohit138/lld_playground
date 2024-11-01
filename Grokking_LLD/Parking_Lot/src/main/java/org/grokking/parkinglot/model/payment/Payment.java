package org.grokking.parkinglot.model.payment;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.grokking.parkinglot.enums.PaymentStatus;

@Getter
@Setter
@ToString
public abstract class Payment {
  private double amount;
  private PaymentStatus status;
  private LocalDateTime timestamp;

  Payment() {
    status = PaymentStatus.PENDING;
  }

  public abstract boolean initiateTransaction();
}
