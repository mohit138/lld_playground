package org.battleship.game;

import org.battleship.game.Controller.GameController;
import org.battleship.game.Model.BattleShipGame;
import org.battleship.game.Model.Coordinate;
import org.battleship.game.Model.PlayerType;

public class GameLoop {
    GameController controller = new GameController();
    void playGame(){
        try{
            BattleShipGame game = controller.initGame(6,"P1","P2");
            controller.addShipForPlayer(0,0,1, PlayerType.PLAYER1, game);
            controller.addShipForPlayer(3,3,1, PlayerType.PLAYER2, game);
            controller.addShipForPlayer(0,3,1, PlayerType.PLAYER1, game);
            controller.addShipForPlayer(3,0,1, PlayerType.PLAYER2, game);
            game.printBoard();
            System.out.println();
//            game.hitTargetCoordinate(new Coordinate(3,3));
//            game.changePlayer();
//            game.printBoard();
//            System.out.println();
//            game.hitTargetCoordinate(new Coordinate(0,1));
//            game.changePlayer();
//            game.printBoard();
//            System.out.println();
            while(!game.isGameOver()){
                System.out.println(""+game.getActivePlayer()+" Making Move : ");
                controller.makeMove(game);
                game.printBoard();
            }
            System.out.println("GAME OVER");
            System.out.println(game.getWinner().getName()+" WON THE GAME!");


        } catch (Exception e){
            System.out.println(e.toString());
        }

    }
}
