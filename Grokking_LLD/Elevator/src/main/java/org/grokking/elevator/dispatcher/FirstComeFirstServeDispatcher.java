package org.grokking.elevator.dispatcher;

import org.grokking.elevator.ElevatorCar;
import org.grokking.elevator.Floor;
import org.grokking.elevator.enums.Direction;

public class FirstComeFirstServeDispatcher extends Dispatcher{
    @Override
    public ElevatorCar getDispatchCar(Floor sourceFloor, Direction direction) {
        // find a car which is either idle or going in same direction and moving towards passenger
        return cars.getFirst();
    }
}
