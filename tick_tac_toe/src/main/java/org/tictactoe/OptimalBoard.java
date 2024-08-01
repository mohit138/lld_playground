package org.tictactoe;

import static java.lang.Math.abs;

public class OptimalBoard extends Board{
    protected int[] rowCount;
    protected int[] colCount;
    protected Integer diagCount;
    protected Integer reverseDiagCount;

    OptimalBoard(){
        super();
        initOptimalBoard();
    }

    OptimalBoard(Integer boardSize){
        super(boardSize);
        initOptimalBoard();
    }

    void initOptimalBoard(){
        rowCount = new int[boardSize];
        colCount = new int[boardSize];
        diagCount=0;
        reverseDiagCount=0;
    }

    /**
     * Implement the O(1) logic here for
     * @param move
     * @return
     */
    // TODO: implement optimal way to process winner
    @Override
    protected boolean isCurrentPlayerWinner(Move move) {
        rowCount[move.i] += board[move.i][move.j];
        colCount[move.j] += board[move.i][move.j];
        if(move.i.equals(move.j)){
            diagCount+=board[move.i][move.j];
        }
        if(move.i + move.j == boardSize - 1){
            reverseDiagCount+=board[move.i][move.j];
        }
        return (abs(rowCount[move.i])==boardSize||
                abs(colCount[move.j])==boardSize||
                diagCount==boardSize||
                reverseDiagCount==boardSize);
    }

}
