package org.parking;

import org.parking.controller.ParkingController;
import org.parking.models.enums.SlotType;
import org.parking.models.enums.VehicleType;


public class Main {

    public static void main(String[] args) {

        // TESTING

        ParkingController parkingController = new ParkingController();

        try{
            parkingController.addSlots(SlotType.SMALL, 5);
            parkingController.addSlots(SlotType.MEDIUM, 2);
            parkingController.addSlots(SlotType.LARGE, 3);

            System.out.println(parkingController.registerAndEnterVehicle("bike-1", VehicleType.MOTORBIKE));
            System.out.println(parkingController.registerAndEnterVehicle("bike-2", VehicleType.MOTORBIKE));
            System.out.println(parkingController.registerAndEnterVehicle("car-1", VehicleType.CAR));
            System.out.println(parkingController.registerAndEnterVehicle("car-2", VehicleType.CAR));
            System.out.println(parkingController.registerAndEnterVehicle("car-3", VehicleType.CAR));
            System.out.println(parkingController.registerAndEnterVehicle("bus-1", VehicleType.BUS));
            System.out.println(parkingController.registerAndEnterVehicle("bus-2", VehicleType.BUS));

            System.out.println(parkingController.printTicketDetails(2));

            System.out.println(parkingController.isSlotAvailable(VehicleType.MOTORBIKE));
            System.out.println(parkingController.isSlotAvailable(VehicleType.BUS));

            Thread.sleep(125000);
            System.out.println(parkingController.exitVehicleAndGiveFees(7));

            Thread.sleep(65000);
            System.out.println(parkingController.exitVehicleAndGiveFees(2));

            System.out.println(parkingController.getFeesForTicketId(7));
            System.out.println(parkingController.getFeesForTicketId(3));


            parkingController.printAllActiveTickets();

        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }


//        SlotManager slotManager = new SlotManager();
//        slotManager.getSlotStorage().addSlot(new SmallSlot());
//        slotManager.getSlotStorage().addSlot(new MediumSlot());
//        slotManager.getSlotStorage().addSlot(new SmallSlot());
//        slotManager.getSlotStorage().addSlot(new MediumSlot());
//        slotManager.getSlotStorage().addSlot(new LargeSlot());
//
//        SlotStorage.getInstance().printAllAvailableSlots();
//        System.out.println();

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

//        //TICKET MANAGER TEST
//        TicketManager ticketManager = new TicketManager(slotManager);
//        Vehicle vehicle = new Vehicle("abc123", VehicleType.BUS);
//        Ticket ticket;
//        try {
//            ticket = ticketManager.generateTicket(vehicle);
//            SlotStorage.getInstance().printAllAvailableSlots();
//            System.out.println();
//            Thread.sleep(185000);
//            Integer fee = ticketManager.getParkingFee(ticket);
//            System.out.println("Fee is "+fee);
//            System.out.println();
//            System.out.println(ticket);
//            System.out.println();
//            SlotStorage.getInstance().printAllAvailableSlots();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    }

    public static SlotType getSlotType(String typeStr){
        if(typeStr.equals("S")){
            return SlotType.SMALL;
        }else if(typeStr.equals("M")){
            return SlotType.MEDIUM;
        }else{
            return SlotType.LARGE;
        }
    }
    public static VehicleType getVehicleType(String typeStr){
        if(typeStr.equals("M")){
            return VehicleType.MOTORBIKE;
        }else if(typeStr.equals("C")){
            return VehicleType.CAR;
        }else{
            return VehicleType.BUS;
        }
    }
}