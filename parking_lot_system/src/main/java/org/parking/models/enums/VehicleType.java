package org.parking.models.enums;

import lombok.Getter;

@Getter
public enum VehicleType {
    MOTORBIKE(5, 2),
    CAR(10, 4),
    BUS(15, 5);

    private final int baseFee;
    private final int hourlyFee;

    VehicleType(int baseFee, int hourlyFee){
        this.baseFee = baseFee;
        this.hourlyFee = hourlyFee;
    }
}
