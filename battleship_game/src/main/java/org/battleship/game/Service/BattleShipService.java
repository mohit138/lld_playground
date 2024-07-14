package org.battleship.game.Service;

import org.battleship.game.Exception.BoardSizeException;
import org.battleship.game.Exception.ShipCoordinateException;
import org.battleship.game.Model.*;
import org.battleship.game.Service.TargetStrategy.RandomTargetStrategy;
import org.battleship.game.Service.TargetStrategy.TargetStrategyInterface;

import java.util.Random;

public class BattleShipService {

    public BattleShipGame initGame(int boardSize, Player player1, Player player2) throws BoardSizeException {
        if(boardSize%2!=0){
            throw new BoardSizeException();
        }
        return new BattleShipGame(boardSize, player1, player2);
    }

    public void addShip(Coordinate coordinate, int size, PlayerType playerType, BattleShipGame game) throws ShipCoordinateException {
        if(!isValidCoordinate(coordinate,size,playerType,game)){
            throw new ShipCoordinateException();
        }
        Ship ship = new Ship(coordinate,size,false);
        game.addShipForPlayer(playerType, ship);
    }

    public void makeMove(BattleShipGame game){
        TargetStrategyInterface targetStrategy = new RandomTargetStrategy();
        Coordinate targetCoordinate = targetStrategy.getValidTargetCoordinate(game);
        System.out.println("Targeting : "+targetCoordinate.getRow()+ " " + targetCoordinate.getCol());
        game.hitTargetCoordinate(targetCoordinate);
        game.changePlayer();
    }

    private boolean isValidCoordinate(Coordinate coordinate, int size,PlayerType playerType, BattleShipGame game){
        int row = coordinate.getRow();
        int column = coordinate.getCol();
        return ((game.withinBound(new Coordinate(row,column),playerType))&&
                (game.withinBound(new Coordinate(row+size,column),playerType))&&
                (game.withinBound(new Coordinate(row,column+size),playerType))&&
                (game.withinBound(new Coordinate(row+size,column+size),playerType)));
    }
}
