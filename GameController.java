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
        int playerPosition = 1;

        do {
            int step = dice.roll();
            System.out.println("------------------------------------");
            System.out.println("current position : " + playerPosition);
            
            playerPosition = player.getPosition() + step;
        
            System.out.println("roll result : " + step);
            
            player.setPosition(playerPosition);
            
            if (gameLogic.isPlayerAtSnakeHead(playerPosition, board.getSnakes())) {
                playerPosition = board.getSnakeTail(playerPosition);
                
                player.setPosition(playerPosition);
            } else if (gameLogic.isPlayerAtLadderBottom(playerPosition, board.getLadders())) {
                playerPosition = board.getLadderTop(playerPosition);
                
                player.setPosition(playerPosition);
            }
            
            System.out.println("player position : " + playerPosition);
            System.out.println("------------------------------------");

            gameState.nextTurn();
        } while (!gameLogic.isGameEnded(playerPosition, board.getDestination()));
    }
}
