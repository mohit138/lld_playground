package org.battleship.game.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Block {
    private BlockType type;
    private boolean isBombed;
    private int shipId;

    Block(){
        type = BlockType.OCEAN;
        isBombed = false;
        shipId = -1;
    }

}
