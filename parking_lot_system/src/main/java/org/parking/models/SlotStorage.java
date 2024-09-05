package org.parking.models;

import lombok.Getter;
import lombok.ToString;
import org.parking.models.enums.SlotType;

import java.util.HashMap;
import java.util.HashSet;

@Getter
public class SlotStorage {

    static SlotStorage slotStorage = null;

    private HashMap<SlotType, HashSet<Slot>> availableSlots;
    private HashMap<SlotType, HashSet<Slot>> occupiedSlots;

    private SlotStorage(){
        availableSlots = new HashMap<>();
        occupiedSlots = new HashMap<>();
        for(SlotType slotType:SlotType.values()){
            availableSlots.put(slotType, new HashSet<>());
            occupiedSlots.put(slotType, new HashSet<>());
        }
    }

    public static SlotStorage getInstance(){
        if(slotStorage==null){
            slotStorage = new SlotStorage();
        }

        return slotStorage;
    }

    public void addSlot(Slot slot){
        availableSlots.get(slot.getSlotType()).add(slot);
    }

    public boolean hasSlot(SlotType slotType){
        return !availableSlots.get(slotType).isEmpty();
    }

    public void printAllAvailableSlots(){
        System.out.println("Available Slots : ");
        availableSlots.forEach((slotType, slot)->{
            System.out.println("For Slot Type "+slotType);
            System.out.println(slot.toString());
        });

        System.out.println("Occupied Slots : ");
        occupiedSlots.forEach((slotType, slot)->{
            System.out.println("For Slot Type "+slotType);
            System.out.println(slot.toString());
        });
    }
}
