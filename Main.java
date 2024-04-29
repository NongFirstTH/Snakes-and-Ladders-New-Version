public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Dice dice = new Dice(6);

        GameConfig gameConfig = new GameConfig(board, dice);
        GameLogic gameLogic = new GameLogic();

        Game game = new Game(gameConfig, gameLogic);
        GameState gameState = new GameState();
        
        GameController gameController = new GameController(game, gameState);
        
        gameController.play();
    }

}