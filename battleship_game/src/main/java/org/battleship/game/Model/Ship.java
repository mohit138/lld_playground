package org.battleship.game.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Ship {
    // can use AtoimicInteger for thread safety
    static int counter=0;

    private int id;
    private Coordinate coordinate;
    private int size;
    private boolean isDestroyed;

    public Ship(Coordinate coordinate, int size, boolean isDestroyed) {
        this.id = counter;
        counter++;
        this.coordinate = coordinate;
        this.size = size;
        this.isDestroyed = isDestroyed;
    }
}
