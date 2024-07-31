package org.tictactoe;

public class OptimalBoard extends Board{
    /**
     * Implement the O(1) logic here for
     * @param move
     * @return
     */
    // TODO: implement optimal way to process winner
    @Override
    protected boolean isCurrentPlayerWinner(Move move) {
        return super.isCurrentPlayerWinner(move);
    }

    // TODO: implement optimal way to process draw
    @Override
    protected void checkAndDeclareIfDraw() {
        super.checkAndDeclareIfDraw();
    }
}
