public class GameController {
    private final Game game;
    private final GameState gameState;

    GameController(Game game, GameState gameState) {
        this.game = game;
        this.gameState = gameState;
    }

    public void play() {
        GameConfig gameConfig = game.getGameConfig();
        GameLogic gameLogic = game.getGameLogic();
        Board board = gameConfig.getBoard();
        Dice dice = gameConfig.getDice();
        Player player = gameState.getCurrentPlayer();

        do {
            int step = dice.roll();
            int playerPosition = player.getPosition();

            player.setPosition(playerPosition + step);

            if (gameLogic.isPlayerAtSnakeHead(player, board.getSnakes())) {
                int tail = board.getSnakeTail(player.getPosition());

                player.setPosition(tail);
            } else if (gameLogic.isPlayerAtLadderBottom(player, board.getLadders())) {
                int top = board.getLadderTop(player.getPosition());

                player.setPosition(top);
            }

            gameState.nextTurn();
        } while (!gameLogic.isGameEnded(player, board.getDestination()));
    }
}
