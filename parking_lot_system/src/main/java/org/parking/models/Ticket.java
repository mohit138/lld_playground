package org.parking.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Ticket {
    static int cnt=1;
    int id;
    Vehicle vehicle;
    Slot slot;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    boolean isActive;
    @Setter
    Integer fees;


    public Ticket(Vehicle vehicle, Slot slot){
        id = cnt;
        cnt++;
        this.vehicle = vehicle;
        this.slot = slot;
        entryTime = LocalDateTime.now();
        isActive=true;
        fees = null;
    }

    public void makeInactive(){
        this.exitTime = LocalDateTime.now();
        this.isActive = false;
    }
}
