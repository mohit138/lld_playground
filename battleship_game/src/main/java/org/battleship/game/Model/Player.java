package org.battleship.game.Model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Player {
    // can use AtoimicInteger for thread safety
    static int counter=0;
    private int id;
    private String name;
    private PlayerType playerType;
    private Map<Integer,Ship> ships;
    private int activeShips;
    private boolean isWinner;

    public Player(String name, PlayerType playerType){
        this.id = counter;
        counter++;
        this.name = name;
        this.playerType = playerType;
        ships = new HashMap<>();
        isWinner = false;
        activeShips = 0;
    }

    public void addShip(Ship ship){
        ships.put(ship.getId(), ship);
        activeShips++;
    }

    public void destroyShip(int shipId){
        Ship shipToDestroy = ships.get(shipId);
        shipToDestroy.setDestroyed(true);
        ships.put(shipId, shipToDestroy);
        activeShips--;
    }
}
