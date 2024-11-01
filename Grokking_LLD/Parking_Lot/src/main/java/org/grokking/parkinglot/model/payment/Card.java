package org.grokking.parkinglot.model.payment;

public class Card extends Payment {
  @Override
  public boolean initiateTransaction() {
    return false;
  }
}
