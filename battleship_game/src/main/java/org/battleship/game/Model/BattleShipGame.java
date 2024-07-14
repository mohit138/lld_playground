package org.battleship.game.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BattleShipGame {
    private int boardSize;
    private ArrayList<ArrayList<Block>> board;
    private Player player1;
    private Player player2;
    private Boundry player1Boundry;
    private Boundry player2Boundry;
    private PlayerType activePlayer;
    private boolean gameOver;

    public BattleShipGame(int boardSize, Player player1, Player player2){
        this.boardSize = boardSize;
        this.player1 = player1;
        this.player2 = player2;
        this.activePlayer = PlayerType.PLAYER1;
        player1Boundry = new Boundry(0,boardSize/2-1, 0, boardSize);
        player2Boundry = new Boundry(boardSize/2, boardSize-1, 0, boardSize);
        board = new ArrayList<>(boardSize);
        for(int row=0;row<boardSize;row++){
            ArrayList<Block> boardRow = new ArrayList<>();
            for(int col=0;col<boardSize;col++){
                boardRow.add(new Block());
            }
            board.add(row, boardRow);
        }
        gameOver = false;
    }

    public void printBoard(){
        for(int row=0;row<boardSize;row++){
            for(int col=0;col<boardSize;col++){
                Block block = board.get(row).get(col);
                String b = (block.getType().equals(BlockType.SHIP))?"S":"O";
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public boolean isAlreadyBombed(Coordinate coordinate){
        return board.get(coordinate.getRow()).get(coordinate.getCol()).isBombed();
    }

    public void hitTargetCoordinate(Coordinate coordinate){
        Block block = board.get(coordinate.getRow()).get(coordinate.getCol());
        if(block.getType().equals(BlockType.SHIP)){
            destroyShipOnCoordinate(coordinate, block.getShipId());
        }else{
            block.setBombed(true);
            board.get(coordinate.getRow()).set(coordinate.getCol(), block);
        }
        if(activePlayer.equals(PlayerType.PLAYER1)){
            gameOver = player1.isWinner();
        }else{
            gameOver = player2.isWinner();
        }
    }

    public void destroyShipOnCoordinate(Coordinate coordinate, int shipId){
        if(activePlayer.equals(PlayerType.PLAYER1)){
            player2.destroyShip(shipId);
            if(player2.getActiveShips()==0){
                player1.setWinner(true);
            }
        }else{
            player1.destroyShip(shipId);
            if(player1.getActiveShips()==0){
                player2.setWinner(true);
            }
        }
        removeShipOnBoardDFS(coordinate);
    }

    /*
    We mark the grid block with destroyed ship as Ocean.
    Traces of sunk ship can be found from player ships info.
    * */
    public void removeShipOnBoardDFS(Coordinate coordinate){
        if(!withinBound(coordinate, (activePlayer.equals(PlayerType.PLAYER1))?PlayerType.PLAYER2:PlayerType.PLAYER1)){
            return;
        }
        Block block = board.get(coordinate.getRow()).get(coordinate.getCol());
        if(block.getType().equals(BlockType.OCEAN)){
            return;
        }
        block.setType(BlockType.OCEAN);
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        board.get(row).set(col, block);
        int[] rowMove = {0,1,0,-1};
        int[] colMove = {1,0,-1,0};
        for(int dir=0;dir<4;dir++){
            removeShipOnBoardDFS(new Coordinate(row+rowMove[dir], col+colMove[dir]));
        }
    }


    public void addShipForPlayer(PlayerType playerType, Ship ship){
        if(playerType.equals(PlayerType.PLAYER1)){
            player1.addShip(ship);
        }else{
            player2.addShip(ship);
        }
        for(int row=ship.getCoordinate().getRow();row<=ship.getCoordinate().getRow()+ship.getSize();row++){
            for(int col=ship.getCoordinate().getCol();col<= ship.getCoordinate().getCol()+ship.getSize();col++){
                board.get(row).set(col, new Block(BlockType.SHIP, false, ship.getId()));
            }
        }
    }

    public boolean withinBound(Coordinate coordinate, PlayerType playerType){
        Boundry boundry = getPlayerBoundry(playerType);
        return (coordinate.getRow()>=boundry.getTop() &&
                coordinate.getRow()<= boundry.getBottom() &&
                coordinate.getCol()>= boundry.getLeft() &&
                coordinate.getCol()<= boundry.getRight());
    }

    public void changePlayer(){
        if(activePlayer.equals(PlayerType.PLAYER1)){
            activePlayer = PlayerType.PLAYER2;
        }else{
            activePlayer = PlayerType.PLAYER1;
        }
    }

    public Player getWinner(){
        if(player1.isWinner()){
            return player1;
        }else{
            return player2;
        }
    }

    private Boundry getPlayerBoundry(PlayerType playerType){
        if(playerType.equals(PlayerType.PLAYER1)){
            return player1Boundry;
        }else{
            return player2Boundry;
        }
    }
}
