package org.battleship.game.Controller;

import org.battleship.game.Exception.BoardSizeException;
import org.battleship.game.Exception.ShipCoordinateException;
import org.battleship.game.Model.BattleShipGame;
import org.battleship.game.Model.Coordinate;
import org.battleship.game.Model.Player;
import org.battleship.game.Model.PlayerType;
import org.battleship.game.Service.BattleShipService;

public class GameController {

    private BattleShipService battleShipService;

    public GameController(){
        battleShipService = new BattleShipService();
    }

    public BattleShipGame initGame(int boardSize, String player1Name, String player2Name) throws BoardSizeException {
        Player player1 = new Player(player1Name, PlayerType.PLAYER1);
        Player player2 = new Player(player2Name, PlayerType.PLAYER2);
        return battleShipService.initGame(boardSize,player1,player2);
    }

    public void addShipForPlayer(int row, int column, int size, PlayerType playerType, BattleShipGame game) throws ShipCoordinateException {
        battleShipService.addShip(new Coordinate(row, column), size, playerType, game);
    }

    public void makeMove(BattleShipGame game){
        battleShipService.makeMove(game);
    }


}
