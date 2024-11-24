package org.grokking.elevator;

import lombok.Getter;
import lombok.Setter;
import org.grokking.elevator.panels.HallPanel;
import org.grokking.elevator.utils.Display;

import java.util.List;

@Getter
@Setter
public class Floor {
    private List<Display> displays;
    private List<HallPanel> panels;

    private boolean isBottom;
    private boolean isTop;

    public boolean isBottomMost(){
        return isBottom;
    }

    public boolean isTopMost(){
        return isTop;
    }
}
