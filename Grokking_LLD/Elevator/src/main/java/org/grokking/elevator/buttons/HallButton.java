package org.grokking.elevator.buttons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HallButton extends Button{
    private Direction buttonSign;

    @Override
    public boolean isPressed() {
        return false;
    }
}
