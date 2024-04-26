public class GameController {
    private final GameConfig config;
    private final GameState state;

    GameController(GameConfig config, GameState state) {
        this.config = config;
        this.state = state;
    }

    private boolean isPlayerAtSnakeHead() {
        return false;
    }

    private boolean isPlayerAtLadderBottom() {
        return false;
    }

    private boolean isGameEnded() {
        return true;
    }

    public void play() {
        Board board = config.getBoard();
        Dice dice = config.getDice();
        Player player = state.getPlayer();

        do {
            int step = dice.roll();
            int playerPosition = player.getPosition();

            player.setPosition(playerPosition + step);

            if (isPlayerAtSnakeHead()) {
                int tail = board.getSnakeTail(player.getPosition());

                player.setPosition(tail);
            } else if (isPlayerAtLadderBottom()) {
                int top = board.getLadderTop(player.getPosition());

                player.setPosition(top);
            }
        } while (!isGameEnded());
    }
}
