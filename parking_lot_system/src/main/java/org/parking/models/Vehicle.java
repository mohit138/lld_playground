package org.parking.models;

import lombok.Setter;
import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    static int cnt=1;
    int id;
    String numberPlate;
    VehicleType vehicleType;
    ArrayList<SlotType> possibleSlots = new ArrayList<>(List.of(SlotType.SMALL));
    @Setter
    int slotId;


    public Vehicle(int id, String numberPlate, VehicleType vehicleType) {
        this.id = cnt;
        cnt++;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }
}
