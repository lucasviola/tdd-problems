package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;
    private HashMap<Integer,String> matchMap;
    private int playCounter;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.matchMap = new HashMap<Integer, String>();
        this.playCounter = 0;
    }

    public void start() {
        this.activePlayer = firstPlayer;
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

    }

    public Player whosTurnIsIt() {
        return this.activePlayer;
    }

    public int getPlayCounter() {
        return playCounter;
    }
}
