package org.grokking.elevator.panels;

import lombok.Getter;
import lombok.Setter;
import org.grokking.elevator.buttons.ElevatorButton;

import java.util.List;

@Getter
@Setter
public class ElevatorPanel {
    private List<ElevatorButton> floorButtons;
    private ElevatorButton openDoor;
    private ElevatorButton closeDoor;
}
