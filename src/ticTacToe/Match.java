package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;
    private HashMap<String,String> matchMap;
    private int playCounter;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.matchMap = new HashMap<String, String>();
        this.playCounter = 0;
    }

    public void start() {
        this.activePlayer = firstPlayer;
    }

    public HashMap<String, String> getMatchMap() {
        return matchMap;
    }

    public void nextMove() {
        String field = "nullable";
        if(playCounter == 0){ field = "firstField";  }
        else if(playCounter == 1){ field = "secondField"; }

        if(this.activePlayer.equals(firstPlayer)){
            this.activePlayer = secondPlayer;
            matchMap.put(field, String.valueOf(secondPlayer.getSymbol()));
        } else{
            this.activePlayer = firstPlayer;
            matchMap.put(field, String.valueOf(firstPlayer.getSymbol()));
        }

        playCounter++;

    }

    public Player whosTurnIsIt() {
        return this.activePlayer;
    }
}
