package org.tictactoe;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Move {
    // We do not add the player for current move, because board keeps track of current player.
    Integer i;
    Integer j;
}
