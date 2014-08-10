package ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;
    private HashMap<String,String> matchMap;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.matchMap = new HashMap<String, String>();
    }

    public void start() {
        this.activePlayer = firstPlayer;
    }

    public HashMap<String, String> getMatchMap() {
        return matchMap;
    }

    public void nextMove() {

        if(this.activePlayer.equals(firstPlayer)){
            this.activePlayer = secondPlayer;
            matchMap.put("firstField", String.valueOf(secondPlayer.getSymbol()));
        } else{
            this.activePlayer = firstPlayer;
            matchMap.put("firstField", String.valueOf(firstPlayer.getSymbol()));
        }



    }

    public Player whosTurnIsIt() {
        return this.activePlayer;
    }
}
