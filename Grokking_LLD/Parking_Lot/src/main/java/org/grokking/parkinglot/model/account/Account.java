package org.grokking.parkinglot.model.account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.grokking.parkinglot.enums.AccountStatus;
import org.grokking.parkinglot.model.Person;

@Getter
@Setter
@ToString
public abstract class Account {
  private String username;
  private String password;
  private Person person;
  private AccountStatus status;

  public abstract boolean resetPassword();
}
