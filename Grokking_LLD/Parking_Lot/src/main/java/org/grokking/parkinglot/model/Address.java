package org.grokking.parkinglot.model;

import lombok.Data;

@Data
public class Address {
  private String address;
  private String city;
  private int zipcode;
}
