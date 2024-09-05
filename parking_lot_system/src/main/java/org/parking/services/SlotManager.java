package org.parking.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.parking.models.Slot;
import org.parking.models.SlotStorage;
import org.parking.models.enums.SlotType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class SlotManager {

    SlotStorage slotStorage = SlotStorage.getInstance();

    public synchronized Slot getSlot(SlotType slotType) throws Exception {
        if(!slotStorage.hasSlot(slotType)){
            throw new Exception("No Slot Available");
        }
        Slot slotToAssign = slotStorage.getAvailableSlots().get(slotType).iterator().next();
        slotStorage.getAvailableSlots().get(slotType).remove(slotToAssign);
        slotStorage.getOccupiedSlots().get(slotType).add(slotToAssign);
        slotToAssign.occupy();
        return slotToAssign;
    }

    public void freeSlot(Slot slot) throws Exception {
        if(slot==null){
            throw new Exception("Invalid Slot");
        }
        slot.vacate();
        slotStorage.getOccupiedSlots().get(slot.getSlotType()).remove(slot);
        slotStorage.getAvailableSlots().get(slot.getSlotType()).add(slot);
    }
}
