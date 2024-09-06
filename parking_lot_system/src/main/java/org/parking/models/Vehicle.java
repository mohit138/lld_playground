package org.parking.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;
import org.parking.utils.VehicleSlotPermissions;

import java.util.ArrayList;

@Getter
@ToString
public class Vehicle {
    static int cnt=1;
    int id;
    String numberPlate;
    VehicleType vehicleType;
    ArrayList<SlotType> possibleSlots;
    @Setter
    int slotId;


    public Vehicle(String numberPlate, VehicleType vehicleType) {
        this.id = cnt;
        cnt++;
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        possibleSlots = VehicleSlotPermissions.getAllowedSlotTypes(vehicleType);
    }
}
