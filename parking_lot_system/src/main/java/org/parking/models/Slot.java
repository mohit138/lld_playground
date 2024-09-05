package org.parking.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.parking.models.enums.SlotType;

/*
    Using an abstarct class for Slot, because implementation of occupying and vacating slot will be same across all.
    So, we can implement things here, and create Specific slots as per need
*/
@Getter
@ToString
public abstract class Slot {
    static int cnt=1;
    int id;
    SlotType slotType;
    boolean isOccupied;

    public Slot(SlotType slotType){
        id = cnt;
        cnt++;
        this.slotType = slotType;
        isOccupied=false;
    }

    public void occupy(){
        isOccupied=true;
    }
    public void vacate(){
        isOccupied=false;
    }


}
