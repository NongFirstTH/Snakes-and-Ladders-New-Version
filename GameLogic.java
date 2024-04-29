import java.util.Map;

public class GameLogic {
    public boolean isPlayerAtSnakeHead(int playerPosition, Map<Integer, Snake> snakes) {
        return snakes.containsKey(playerPosition);
    }

    public boolean isPlayerAtLadderBottom(int playerPosition, Map<Integer, Ladder> ladders) {
        return ladders.containsKey(playerPosition);
    }

    public boolean isGameEnded(int playerPosition, int destination) {
        return playerPosition >= destination;
    }
}
