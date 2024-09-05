package org.parking;

import org.parking.models.Slot;
import org.parking.models.SlotStorage;
import org.parking.models.enums.SlotType;
import org.parking.models.implementations.slots.LargeSlot;
import org.parking.models.implementations.slots.MediumSlot;
import org.parking.models.implementations.slots.SmallSlot;
import org.parking.services.SlotManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        SlotManager slotManager = new SlotManager();
        slotManager.getSlotStorage().addSlot(new SmallSlot());
        slotManager.getSlotStorage().addSlot(new MediumSlot());
        slotManager.getSlotStorage().addSlot(new SmallSlot());
        slotManager.getSlotStorage().addSlot(new MediumSlot());
        slotManager.getSlotStorage().addSlot(new LargeSlot());

        SlotStorage.getInstance().printAllAvailableSlots();
        Slot bikeSlot = null;
        try {
            bikeSlot = slotManager.getSlot(SlotType.SMALL);
        } catch (Exception e) {
            System.out.println("What are you doing !!");
        }
        System.out.println();
        System.out.println(bikeSlot);
        System.out.println();
        SlotStorage.getInstance().printAllAvailableSlots();
        try {
            slotManager.freeSlot(bikeSlot);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        SlotStorage.getInstance().printAllAvailableSlots();
    }
}