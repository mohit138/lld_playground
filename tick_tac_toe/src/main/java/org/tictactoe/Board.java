package org.tictactoe;

import lombok.Getter;
import org.tictactoe.Exceptions.IllegalMoveException;
import org.tictactoe.enums.Player;
import org.tictactoe.enums.Result;

// NO SETTER ADDED, because we will not set anything in board
@Getter
/**
 * This board is a little in-optimal.
 * It uses O(N) to find if current user is winner
 * It is also not able to detect early draws, and only draws when all squares are filled
 */
public class Board {
    int boardSize;
    int[][] board;
    Result result;
    private Player currentPlayer;

    // temp for primitive draw logic.
    private int moveCount;

    Board(){
        boardSize=3;
        board = new int[boardSize][boardSize];
        // board[][] => 0 - no player, 1 - player 1 played, -1 - player 2 played
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                board[i][j]=0;
            }
        }
        result = Result.UNDECIDED;
        currentPlayer=Player.FIRST;

        moveCount=0;
    }

    void printBoard(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    void makeCurrentPlayerWinner() {
        if(currentPlayer.equals(Player.FIRST)){
            result = Result.FIRST_WINNER;
        }else{
            result = Result.SECOND_WINNER;
        }
    }

    void changeCurrentPlayer() {
        if(currentPlayer.equals(Player.FIRST)){
            currentPlayer = Player.SECOND;
        }else{
            currentPlayer = Player.FIRST;
        }
    }

    private void checkValidMove(Move move) throws IllegalMoveException {
        if(move.i<0 || move.j<0 || move.i>=boardSize || move.j>=boardSize){
            throw new IllegalMoveException("Move is out of bounds!");
        }
        if(board[move.i][move.j]!=0) {
            throw new IllegalMoveException("Square is already occupied!");
        }
    }

    private void boardUpdate(Move move){
        if(currentPlayer.equals(Player.FIRST)){
            board[move.i][move.j] = 1;
        }else{
            board[move.i][move.j] = -1;
        }
    }

    /**
     * This has Linear Time Complexity O(N) for declaring winner.
     * @param move
     * @return
     */
    // made protected so that some child class can make it more optimal
    protected boolean isCurrentPlayerWinner(Move move){
        boolean winRow=true, winCol=true, winDiag=true, winRdiag=true;

        for(int k=0;k<boardSize;k++){
            if(board[k][move.j]!=board[move.i][move.j]){
                winCol=false;
            }
            if(board[move.i][k]!=board[move.i][move.j]){
                winRow=false;
            }
            if(board[k][k]!=board[move.i][move.j]){
                winDiag=false;
            }
            if(board[k][boardSize-1-k]!=board[move.i][move.j]){
                winRdiag=false;
            }
        }

        return (winCol||winDiag||winRdiag||winRow);
    }

    // made protected so that some child class can make it more optimal
    protected void checkAndDeclareIfDraw(){
        moveCount++;
        if(moveCount==boardSize*boardSize){
            result = Result.DRAW;
        }
    }

    // for coment like below, type /** before declaration and press enter.
    /**
     * This function makes move, modifies board, updates Result of game as well as current player.
     * Do check result after calling this function
     *
     * @param move
     * @throws IllegalMoveException
     */
    void makeMove(Move move) throws IllegalMoveException {
        checkValidMove(move);

        boardUpdate(move);

        if(isCurrentPlayerWinner(move)){
            makeCurrentPlayerWinner();
        }else{
            checkAndDeclareIfDraw();
        }

        changeCurrentPlayer();
    }

    // TODO : Implement Later
    void undoMove(Move move){
        // algo

        changeCurrentPlayer();;
    }
}
