package org.tictactoe;

public class  Main {
    public static void main(String[] args) {
        User user1 = new User("P1");
        User user2 = new User("P2");
        Game game = new Game(user1, user2);
        game.initialize();
    }
}