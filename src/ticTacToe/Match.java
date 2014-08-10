package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {
        HashMap<String, String> matchMap = new HashMap<String, String>();
        this.activePlayer = firstPlayer;
    }

    public void nextMove() {

        if(this.activePlayer.equals(firstPlayer)){
            this.activePlayer = secondPlayer;
        } else{
            this.activePlayer = firstPlayer;
        }
    }

    public Player whosTurnIsIt() {
        return this.activePlayer;
    }
}
