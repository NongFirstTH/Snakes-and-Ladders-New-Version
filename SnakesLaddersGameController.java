public class SnakesLaddersGameController {
    private final Player[] players;
    private final Dice dice;
    private final Board board;

    SnakesLaddersGameController(Player[] players) {
        this.players = players;
        dice = new Dice(6);
        board = new Board();
    }

    public void play() {
        int currentPlayerIndex = 0;
        Player currentPlayer = players[currentPlayerIndex];

        while (true) {
            playRound(currentPlayer);
            
            if (isGameEnded(currentPlayer.getPosition())) {
                break;
            }
            
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
            currentPlayer = players[currentPlayerIndex];
        }
    }

    private void playRound(Player currentPlayer) {
        int step = rollDice();
        int newPlayerPosition = calculateNewPlayerPosition(currentPlayer.getPosition(), step);

        currentPlayer.setPosition(newPlayerPosition);
    }
    
    private boolean isGameEnded(int playerPosition) {
        return playerPosition >= board.getGoal();
    }

    private int rollDice() {
        return dice.roll();
    }

    private int getNextPlayerIndex(int previousIndex) {
        return (previousIndex + 1) % players.length;
    }

    private int calculateNewPlayerPosition(int currentPosition, int step) {
        int newPlayerPosition = currentPosition + step;

        if (isPlayerAtTeleporterCell(newPlayerPosition)) {
            newPlayerPosition = getTeleportDestination(newPlayerPosition);
        }

        return newPlayerPosition;
    }

    private boolean isPlayerAtTeleporterCell(int playerPosition) {
        return board.isTeleporterCell(playerPosition);
    }

    private int getTeleportDestination(int playerPosition) {
        return board.getTeleportDestination(playerPosition);
    }
}
