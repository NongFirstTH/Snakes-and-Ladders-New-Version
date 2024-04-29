import java.util.LinkedList;

public class GameState {
    private final int numberOfPlayer;
    private final LinkedList<Player> players;
    private int turn = 1;

    GameState() {
        this.players = new LinkedList<>();
        this.numberOfPlayer = players.size();
    }

    public Player getCurrentPlayer() {
        return players.get((turn - 1) % numberOfPlayer);
    }

    public void nextTurn() {
        turn++;
    }
}
