package org.parking.models;

import lombok.Getter;
import org.parking.models.enums.SlotType;

import java.util.HashMap;
import java.util.HashSet;

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
        activeTickets.remove(ticketId);
        inActiveTickets.put(ticketId, ticket);
    }
}
