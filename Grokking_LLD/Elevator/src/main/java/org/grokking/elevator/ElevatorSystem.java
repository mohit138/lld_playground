package org.grokking.elevator;

import org.grokking.elevator.dispatcher.Dispatcher;
import org.grokking.elevator.dispatcher.FirstComeFirstServeDispatcher;
import org.grokking.elevator.enums.Direction;

public class ElevatorSystem {
    private Building building;
    private Dispatcher dispatcher;

    private static ElevatorSystem system = null;

    private ElevatorSystem(){
        building = Building.getInstance();
        dispatcher = new FirstComeFirstServeDispatcher();
    }

    public static ElevatorSystem getInstance(){
        if(system==null){
            system = new ElevatorSystem();
        }
        return system;
    }

    public void monitoring(){

    }

    public void dispatcher(Floor sourceFloor, Direction dir){
        ElevatorCar carToMove = dispatcher.getDispatchCar(sourceFloor, dir);
    }

}
