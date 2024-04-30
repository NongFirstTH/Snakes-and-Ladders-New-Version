import java.util.LinkedList;

public class GameState {
    private final int numberOfPlayer = 1;
    private final LinkedList<Player> players;
    private int turn = 1;

    GameState() {
        this.players = new LinkedList<>();

        while (players.size() < numberOfPlayer) {
            players.add(new Player());
        }
    }

    public Player getCurrentPlayer() {
        return players.get((turn - 1) % numberOfPlayer);
    }

    public void nextTurn() {
        turn++;
    }

    public void printGameState() {
        System.out.println("------------------------------------");
        System.out.println("Turn : " + turn);

        for (int playerIndex = 0; playerIndex < numberOfPlayer; playerIndex++) {
            System.out.println("Player" + (playerIndex + 1) + "'s position : " + getCurrentPlayer().getPosition());
        }
    }
}
