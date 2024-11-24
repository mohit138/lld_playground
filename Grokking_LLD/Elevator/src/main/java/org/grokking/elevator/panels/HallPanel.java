package org.grokking.elevator.panels;

import lombok.Getter;
import lombok.Setter;
import org.grokking.elevator.buttons.HallButton;

@Getter
@Setter
public class HallPanel {
    private HallButton up;
    private HallButton down;
}
