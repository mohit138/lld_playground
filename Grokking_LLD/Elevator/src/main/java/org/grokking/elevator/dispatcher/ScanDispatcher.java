package org.grokking.elevator.dispatcher;

import org.grokking.elevator.ElevatorCar;
import org.grokking.elevator.Floor;
import org.grokking.elevator.enums.Direction;

/**
 * SCAN is also known as the Elevator Algorithm. The elevator car starts from one end of the building and moves towards the other end, servicing requests in between.
 * The advantage of this method is that it serves multiple requests in parallel.
 * However, it results in increased cost as the elevator car only changes its direction at either the top floor, or the lowest floor.
 * The implementation of SCAN can be done using two boolean arrays or a single HashMap, or two priority queues data structures to track the floor where the elevator should stop.
 * TODO: implement
 */
public class ScanDispatcher extends Dispatcher{
    @Override
    public ElevatorCar getDispatchCar(Floor sourceFloor, Direction direction) {
        return null;
    }
}
