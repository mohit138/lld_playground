package org.grokking.elevator.dispatcher;

import org.grokking.elevator.ElevatorCar;
import org.grokking.elevator.Floor;
import org.grokking.elevator.enums.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class Dispatcher {
    protected List<ElevatorCar> cars;
    Dispatcher(){
        cars = new ArrayList<>();
    }
    public abstract ElevatorCar getDispatchCar(Floor sourceFloor, Direction direction);
}
