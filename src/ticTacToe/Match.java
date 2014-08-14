package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;
    private HashMap<Integer,String> matchMap;
    private int playCounter;
    private String status;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.matchMap = new HashMap<Integer, String>();
        this.playCounter = 0;
    }

    public void start() {
        this.activePlayer = firstPlayer;
        status = "On going";
    }

    public HashMap<Integer, String> getMatchMap() {
        return matchMap;
    }

    public void nextMove() {

        if(this.activePlayer.equals(firstPlayer)){
            this.activePlayer = secondPlayer;
            matchMap.put(0, String.valueOf(secondPlayer.getSymbol()));
        } else{
            this.activePlayer = firstPlayer;
            matchMap.put(1, String.valueOf(firstPlayer.getSymbol()));
        }

        playCounter++;

        if(playCounter >= 9){
            this.status = "finished";
        }

    }

    public Player whosTurnIsIt() {
        return this.activePlayer;
    }

    public int getPlayCounter() {
        return playCounter;
    }

    public String getStatus() {
        return status;
    }
}
