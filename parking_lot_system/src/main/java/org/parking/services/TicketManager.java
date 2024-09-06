package org.parking.services;

import lombok.Getter;
import org.parking.models.*;
import org.parking.utils.Pricing;

import java.util.Objects;

public class TicketManager {

    @Getter
    TicketStorage ticketStorage = TicketStorage.getInstance();

    public TicketManager(SlotManager slotManager){
        this.slotManager = slotManager;
    }

    SlotManager slotManager;

    public Ticket generateTicket(Vehicle vehicle) throws Exception {
        Slot availableSLot = vehicle.getPossibleSlots()
                .stream()
                .filter(slotType -> SlotStorage.getInstance().hasSlot(slotType))
                .findFirst()
                .map(slotType -> slotManager.getSlot(slotType))
                .orElse(null);
        if(Objects.isNull(availableSLot)){
            throw new Exception("No Available Slots for this vehicle type.");
        }

        vehicle.setSlotId(availableSLot.getId());

        Ticket generatedTicket = new Ticket(vehicle, availableSLot);
        ticketStorage.addTicket(generatedTicket);
        return generatedTicket;
    }

    public Integer getParkingFee(Ticket ticket) throws Exception {
        slotManager.freeSlot(ticket.getSlot());
        ticketStorage.makeTicketInactive(ticket.getId());
        Integer fees =  Pricing.calculateFees(ticket);
        ticketStorage.addFeesToTicket(ticket.getId(), fees);
        return fees;
    }

}
