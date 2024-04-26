public class GameState {
    private Player player;
    private int turn = 1;

    GameState() {
        player = new Player();
    }

    public Player getPlayer() {
        return player;
    }
}
