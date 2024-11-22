package org.grokking.elevator.buttons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElevatorButton extends Button{
    private int destinationFloorNumber;

    @Override
    public boolean isPressed() {
        return false;
    }
}
