package org.parking.controller;

import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;
import org.parking.services.ParkingManager;

import java.util.Objects;

public class ParkingController {
    ParkingManager parkingManager = new ParkingManager();

    public boolean isSlotAvailable(VehicleType vehicleType){
        return parkingManager.hasAvailableSlot(vehicleType);
    }

    public void addSlots(SlotType slotType, Integer quantity){
        parkingManager.createParkingSlots(slotType, quantity);
    }

    public void printAllActiveTickets(){
        parkingManager.printAvailableTickets();
    }

    public String printTicketDetails(Integer ticketId){
        String response;
        try {
            response = parkingManager.getTicketDetails(ticketId).toString();
        } catch (Exception e) {
            response = "Invalid Ticket ID";
        }
        return response;
    }

    public String registerAndEnterVehicle(String numberPlate, VehicleType vehicleType){
        String response;
        try{
            response = "For "+numberPlate+", Ticket ID = "+parkingManager.registerVehicleAndGenerateTicket(numberPlate, vehicleType).getId();
        } catch (Exception e) {
            response = "Could Not create ticket. Check if slots are free";
        }
        return response;
    }

    public String exitVehicleAndGiveFees(Integer ticketId){
        String response;
        try {
            response = parkingManager.getFeeForTicketId(ticketId).toString();
        } catch (Exception e) {
            response = "Error in vehicle exiting.";
            System.out.println(e.getMessage());
        }
        return response;
    }

    public String getFeesForTicketId(Integer ticketId){
        String response;
        try {
            Integer fees = parkingManager.getTicketDetails(ticketId).getFees();
            if(Objects.isNull(fees)){
                response = "NO fees generated yet";
            }else{
                response = "Fees for Ticket ID  ("+ticketId+") is - "+fees.toString();
            }
        } catch (Exception e) {
            response = "Invalid Ticket ID";
        }
        return response;
    }

}
