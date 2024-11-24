package org.grokking.elevator.dispatcher;

import org.grokking.elevator.ElevatorCar;
import org.grokking.elevator.Floor;
import org.grokking.elevator.enums.Direction;

/**
 * Shortest Seek Time First (SSTF) is an algorithm in which the passenger who is closest to the elevator car would get the elevator car.
 * This algorithm is considered better than FCFS since less elevator movement is required as compared to the FCFS algorithm.
 * This algorithm also results in an increased throughput. However, there is a loophole in this method where it always chooses the minimum distant passengers and ignore the farther ones completely.
 * To implement this algorithm, we can use a priority queue, min-heap, or an array data structure.
 * TODO: implement
 */
public class ShortestSeekTimeFirstDispatcher extends Dispatcher{
    @Override
    public ElevatorCar getDispatchCar(Floor sourceFloor, Direction direction) {
        return null;
    }
}
