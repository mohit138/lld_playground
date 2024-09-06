package org.parking.models;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class TicketStorage {
    static TicketStorage ticketStorage = null;

    private HashMap<Integer, Ticket> activeTickets;
    private HashMap<Integer, Ticket> inActiveTickets;

    private TicketStorage(){
        activeTickets = new HashMap<>();
        inActiveTickets = new HashMap<>();
    }

    public static TicketStorage getInstance(){
        if(ticketStorage==null){
            ticketStorage = new TicketStorage();
        }

        return ticketStorage;
    }

    public Ticket getTicketById(Integer ticketId) throws Exception {
        if(activeTickets.containsKey(ticketId)){
            return activeTickets.get(ticketId);
        }
        if(inActiveTickets.containsKey(ticketId)){
            return inActiveTickets.get(ticketId);
        }
        throw new Exception("Invalid TicketId.");
    }

    public void addTicket(Ticket ticket) throws Exception {
        if(activeTickets.containsKey(ticket.getId())){
            throw new Exception("Ticket is already active");
        }
        activeTickets.put(ticket.getId(), ticket);
    }

    public void makeTicketInactive(Integer ticketId) throws Exception {
        if(!activeTickets.containsKey(ticketId)){
            throw new Exception("Invalid Ticket: Ticket not an Active Ticket.");
        }
        if(inActiveTickets.containsKey(ticketId)){
            throw new Exception("Invalid Ticket: Ticket is already an Inactive Ticket.");
        }
        Ticket ticket = activeTickets.get(ticketId);
        ticket.makeInactive();
        activeTickets.remove(ticketId);
        inActiveTickets.put(ticketId, ticket);
    }

    public void addFeesToTicket(Integer ticketId, Integer fees){
        if(activeTickets.containsKey(ticketId)){
            activeTickets.get(ticketId).setFees(fees);
        }
        if(inActiveTickets.containsKey(ticketId)){
            inActiveTickets.get(ticketId).setFees(fees);
        }
    }

    public void printAllAvailableTickets(){
        activeTickets.forEach((ticketId, ticket)->{
            System.out.println("Ticket ID - "+ticketId);
            System.out.println(ticket);
        });
    }
}
