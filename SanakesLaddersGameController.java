import java.util.LinkedList;

public class SanakesLaddersGameController {
    private final Board board;
    private final Dice dice;
    private final int numberOfPlayer;
    private final Player[] players;

    SanakesLaddersGameController(int numberOfPlayer) {
        this.board = new Board();
        this.dice = new Dice(6);
        this.numberOfPlayer = numberOfPlayer;
        this.players = new Player[numberOfPlayer];

        for (int indexPlayer = 0; indexPlayer < numberOfPlayer; indexPlayer++) {
            players[indexPlayer] = new Player();
        }
    }

    public int rollDice() {
        return dice.roll();
    }

    public boolean isPlayerAtSnakeHead(int playerPosition) {
        return board.getSnakes().containsKey(playerPosition);
    }

    public boolean isPlayerAtLadderBottom(int playerPosition) {
        return board.getLadders().containsKey(playerPosition);
    }

    public boolean isGameEnded(int playerPosition, int destination) {
        return playerPosition >= destination;
    }

    private int getNextPlayerIndex(int previousIndex) {
        return (previousIndex + 1) % numberOfPlayer;
    }

    public void play() {
        int currentPlayerIndex = 0;
        Player currentPlayer = players[currentPlayerIndex];

        while (!isGameEnded(currentPlayer.getPosition(), board.getDestination())) {
            playRound(currentPlayer);

            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
            currentPlayer = players[currentPlayerIndex];
        }
    }

    public void playRound(Player currentPlayer) {
        int step = rollDice();

        currentPlayer.setPosition(calculatePlayerNewPosition(currentPlayer.getPosition(), step));
        printGame(step);
    }

    public int calculatePlayerNewPosition(int currentPosition, int step) {
        int newPlayerPosition = currentPosition + step;

        if (isPlayerAtSnakeHead(newPlayerPosition)) {
            newPlayerPosition = board.getSnakeTail(newPlayerPosition);
        } else if (isPlayerAtLadderBottom(newPlayerPosition)) {
            newPlayerPosition = board.getLadderTop(newPlayerPosition);
        }

        return newPlayerPosition;
    }

    private void printGame(int step) {
        System.out.println("------------------------");
        System.out.println("Roll dice result : " + step);
        System.out.println("Player position : " + players[0].getPosition());
    }
}
