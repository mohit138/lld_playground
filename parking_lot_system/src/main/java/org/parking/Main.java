package org.parking;

import org.parking.models.Slot;
import org.parking.models.SlotStorage;
import org.parking.models.Ticket;
import org.parking.models.Vehicle;
import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;
import org.parking.models.implementations.slots.LargeSlot;
import org.parking.models.implementations.slots.MediumSlot;
import org.parking.models.implementations.slots.SmallSlot;
import org.parking.services.SlotManager;
import org.parking.services.TicketManager;

import java.lang.invoke.CallSite;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

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
        System.out.println();
//        // SLOT MANAGER TESTING
//        Slot bikeSlot = null;
//        try {
//            bikeSlot = slotManager.getSlot(SlotType.SMALL);
//        } catch (Exception e) {
//            System.out.println("What are you doing !!");
//        }
//        System.out.println();
//        System.out.println(bikeSlot);
//        System.out.println();
//        SlotStorage.getInstance().printAllAvailableSlots();
//        try {
//            slotManager.freeSlot(bikeSlot);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println();
//        SlotStorage.getInstance().printAllAvailableSlots();

        //TICKET MANAGER TEST
        TicketManager ticketManager = new TicketManager(slotManager);
        Vehicle vehicle = new Vehicle("abc123", VehicleType.BUS);
        Ticket ticket;
        try {
            ticket = ticketManager.generateTicket(vehicle);
            SlotStorage.getInstance().printAllAvailableSlots();
            System.out.println();
            Thread.sleep(185000);
            Integer fee = ticketManager.getParkingFee(ticket);
            System.out.println("Fee is "+fee);
            System.out.println();
            System.out.println(ticket);
            System.out.println();
            SlotStorage.getInstance().printAllAvailableSlots();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}