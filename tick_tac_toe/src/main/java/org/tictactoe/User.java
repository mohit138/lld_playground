package org.tictactoe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    static Integer counter = 0 ;
    private Integer userId;
    private String userName;
    private Integer gamesWon;
    private Integer gamesLost;

    public User(String userName) {
        this.userId = counter;
        counter++;
        this.userName = userName;
        gamesLost=0;
        gamesWon=0;
    }

    public void incrementWonGame() {
        gamesWon++;
    }

    public void incrementLostGame() {
        gamesLost++;
    }
}
