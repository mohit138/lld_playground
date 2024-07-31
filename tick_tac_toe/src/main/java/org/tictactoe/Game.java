package org.tictactoe;

import lombok.Getter;
import org.tictactoe.Exceptions.IllegalMoveException;
import org.tictactoe.enums.Player;
import org.tictactoe.enums.Result;

import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class Game {
    static Integer gameCounter=0;

    //IDE suggested to make final. And it also makes sense
    private final Integer gameId;
    private final Board board;
    private final User firstPlayer;
    private final User secondPlayer;
    ArrayList<Move> movesPlayed;

    Game(User firstPlayer, User secondPlayer){
        gameId = gameCounter;
        gameCounter++;
//        board = new Board();
        board = new OptimalBoard();
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        movesPlayed = new ArrayList<>();
    }

    void initialize(){
        Scanner scn = new Scanner(System.in);
        while(board.getResult().equals(Result.UNDECIDED)){
            System.out.println(getCurrentPlayerName()+", please enter your co-ordinates(0 indexed)");
            int i = scn.nextInt();
            int j = scn.nextInt();
            Move currentMove = new Move(i,j);
            try {
                board.makeMove(currentMove);
                board.printBoard();
                movesPlayed.addLast(currentMove);
            } catch (IllegalMoveException e) {
                System.out.println("Incorrect Move! - "+e.getMessage());
            }

        }

        System.out.println("Result is : "+board.getResult());

    }

    private String getCurrentPlayerName(){
        if(board.getCurrentPlayer().equals(Player.FIRST)){
            return firstPlayer.getUserName();
        }else{
            return secondPlayer.getUserName();
        }
    }
}
