package org.parking.services;

import org.parking.models.Slot;
import org.parking.models.Ticket;
import org.parking.models.Vehicle;
import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;
import org.parking.models.implementations.slots.LargeSlot;
import org.parking.models.implementations.slots.MediumSlot;
import org.parking.models.implementations.slots.SmallSlot;

import java.util.Arrays;
import java.util.HashMap;

public class ParkingManager {
    SlotManager slotManager;
    TicketManager ticketManager;
    HashMap<VehicleType, Boolean> hasVehicleTypeSpace;

    public ParkingManager(){
        slotManager = new SlotManager();
        ticketManager = new TicketManager(slotManager);
        hasVehicleTypeSpace = new HashMap<>();
        Arrays.stream(VehicleType.values()).forEach(vehicleType -> hasVehicleTypeSpace.put(vehicleType, true));
    }

    public boolean hasAvailableSlot(VehicleType vehicleType){
        return hasVehicleTypeSpace.get(vehicleType);
    }

    private Slot createNewSlotBySlotType(SlotType slotType){
        return switch (slotType){
            case SlotType.SMALL -> new SmallSlot();
            case MEDIUM -> new MediumSlot();
            case LARGE -> new LargeSlot();
        };
    }

    public void createParkingSlots(SlotType slotType, Integer quantity){
        for(int slotNo = 1; slotNo<=quantity ;slotNo++){
            Slot slotToAdd = createNewSlotBySlotType(slotType);
            slotManager.getSlotStorage().addSlot(slotToAdd);
        }
    }

    public Ticket registerVehicleAndGenerateTicket(String numberPlate, VehicleType vehicleType) throws Exception {
        Vehicle vehicle = new Vehicle(numberPlate, vehicleType);
        Ticket ticket =  ticketManager.generateTicket(vehicle);
        if(!slotManager.getSlotStorage().hasSlot(ticket.getSlot().getSlotType())){
            hasVehicleTypeSpace.put(vehicleType, false);
        }
        return ticket;
    }

    public Integer getFeeForTicketId(Integer ticketId) throws Exception{
        Ticket userTicket = ticketManager.getTicketStorage().getTicketById(ticketId);
        if(slotManager.getSlotStorage().hasSlot(userTicket.getSlot().getSlotType())){
            hasVehicleTypeSpace.put(userTicket.getVehicle().getVehicleType(), true);
        }
        return ticketManager.getParkingFee(userTicket);
    }

    public void printAvailableTickets(){
        ticketManager.getTicketStorage().printAllAvailableTickets();
    }

    public Ticket getTicketDetails(Integer ticketId) throws Exception {
        return ticketManager.getTicketStorage().getTicketById(ticketId);
    }
}
