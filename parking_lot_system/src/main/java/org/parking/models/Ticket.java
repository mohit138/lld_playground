package org.parking.models;

import lombok.Getter;
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


    public Ticket(Vehicle vehicle, Slot slot){
        id = cnt;
        cnt++;
        this.vehicle = vehicle;
        this.slot = slot;
        entryTime = LocalDateTime.now();
        isActive=true;
    }

    public void makeInactive(){
        this.exitTime = LocalDateTime.now();
        this.isActive = false;
    }
}
