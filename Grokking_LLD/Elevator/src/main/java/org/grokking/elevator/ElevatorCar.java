package org.grokking.elevator;

import org.grokking.elevator.enums.ElevatorState;
import org.grokking.elevator.panels.ElevatorPanel;
import org.grokking.elevator.utils.Display;
import org.grokking.elevator.utils.Door;

public class ElevatorCar {
    private int id;
    private Door door;
    private ElevatorState state;
    private ElevatorPanel panel;
    private Display display;

    public void move(Floor floor){ // will move towards the desired floor

    }

    public void stop(){

    }

    public void openDoor(){}

    public void closeDoor(){}

}
