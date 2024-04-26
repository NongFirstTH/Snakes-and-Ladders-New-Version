public class GameController {
    private final GameConfig gameConfig;
    private final GameState gameState;

    GameController(GameConfig gameConfig, GameState gameState) {
        this.gameConfig = gameConfig;
        this.gameState = gameState;
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
        Board board = gameConfig.getBoard();
        Dice dice = gameConfig.getDice();
        Player player = gameState.getPlayer();

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
