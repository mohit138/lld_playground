package org.battleship.game.Service.TargetStrategy;

import org.battleship.game.Model.BattleShipGame;
import org.battleship.game.Model.Coordinate;
import org.battleship.game.Model.PlayerType;

import java.util.Random;

public class RandomTargetStrategy implements TargetStrategyInterface{
    @Override
    public Coordinate getValidTargetCoordinate(BattleShipGame game) {
        Random randomGen = new Random();
        Coordinate targetCoordinate = new Coordinate();
        boolean foundValidTarget = false;
        while(!foundValidTarget){
            targetCoordinate.setCol(randomGen.nextInt(game.getBoardSize()));
            targetCoordinate.setRow(randomGen.nextInt(game.getBoardSize()/2) + ((game.getActivePlayer().equals(PlayerType.PLAYER1))?(game.getBoardSize()/2):(0)));
            foundValidTarget = !game.isAlreadyBombed(targetCoordinate);
        }
        return targetCoordinate;
    }
}
