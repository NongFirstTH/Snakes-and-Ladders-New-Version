package models;

import java.util.Queue;

public class GameState {
    private final Queue<Player> players;
    private int diceResult;

    public GameState(Queue<Player> players, int diceResult) {
        this.players = players;
        this.diceResult = diceResult;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.peek();
    }

    public int getDiceResult() {
        return diceResult;
    }

    public void setDiceResult(int diceResult) {
        this.diceResult = diceResult;
    }
}
