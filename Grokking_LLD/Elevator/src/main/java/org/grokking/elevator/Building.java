package org.grokking.elevator;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Building {
    private List<Floor> floors;
    private List<ElevatorCar> elevators;

    private Building(){
        floors = new ArrayList<>();
        elevators = new ArrayList<>();
    }

    private static Building building = null;
    public static Building getInstance(){
        if(building==null){
            building = new Building();
        }
        return building;
    }
}
