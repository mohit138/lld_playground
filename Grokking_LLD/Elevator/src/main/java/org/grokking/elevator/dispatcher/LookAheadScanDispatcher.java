package org.grokking.elevator.dispatcher;

import org.grokking.elevator.ElevatorCar;
import org.grokking.elevator.Floor;
import org.grokking.elevator.enums.Direction;

/**
 * LOOK is also known as the look-ahead SCAN algorithm. It is an improved version of the SCAN Algorithm.
 * In this algorithm, the elevator car stops when there is no request in front of them. It will move again on the basis of the request.
 * The advantage of this algorithm is that the elevator car does not always go till the end of the building but can change its direction in between.
 * This algorithm can be implemented using a HashMap, TreeMap, or binary search tree data structure.
 * TODO: implement
 */
public class LookAheadScanDispatcher extends Dispatcher{
    @Override
    public ElevatorCar getDispatchCar(Floor sourceFloor, Direction direction) {
        return cars.getFirst();
    }
}
