public class Game {
    private final GameConfig gameConfig;
    private final GameLogic gameLogic;

    Game(GameConfig gameConfig, GameLogic gameLogic) {
        this.gameConfig = gameConfig;
        this.gameLogic = gameLogic;
    }

    public GameConfig getGameConfig() {
        return gameConfig;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }
}
