package org.parking.utils;

import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public final class VehicleSlotPermissions {

    /*
    List of slot types will give more priority to SlotType in beginning
     */
    public static ArrayList<SlotType> getAllowedSlotTypes(VehicleType vehicleType){
        return switch (vehicleType) {
            case MOTORBIKE -> new ArrayList<>(List.of(SlotType.SMALL));
            case CAR -> new ArrayList<>(List.of(SlotType.MEDIUM, SlotType.LARGE));
            case BUS -> new ArrayList<>(List.of(SlotType.LARGE));
            case null, default -> new ArrayList<>();
        };
    }

}
