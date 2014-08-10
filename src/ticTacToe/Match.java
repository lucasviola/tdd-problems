package ticTacToe;

public class Match {
    private Player firstPlayer;
    private Player secondPlayer;

    public Match(Player firstPlayer, Player secondPlayer) {

        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void start() {

    }

    public void nextMove() {

    }

    public Player whosTurnIsIt() {
        return this.secondPlayer;
    }
}
