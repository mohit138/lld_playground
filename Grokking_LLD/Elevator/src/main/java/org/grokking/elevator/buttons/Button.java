package org.grokking.elevator.buttons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Button {
    private boolean status;

    public void pressDown(){

    }

    public abstract boolean isPressed();
}
