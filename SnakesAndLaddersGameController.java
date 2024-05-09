public class SnakesAndLaddersGameController {
    Player[] players;
    Dice dice;
    Board board;

    SnakesAndLaddersGameController(Player[] players) {
        this.players = players;
        dice = new Dice(6);
        board = new Board();
    }
    
    public int rollDice() {
        return dice.roll();
    }

    public boolean isGameEnded(int playerPosition, int destination) {
        return playerPosition >= destination;
    }

    private int getNextPlayerIndex(int previousIndex) {
        return (previousIndex + 1) % players.length;
    }

    public boolean isPlayerAtTeleporterCell(int playerPosition) {
        return board.isTeleporterCell(playerPosition);
    }

    public int getTeleportDestination(int playerPosition) {
        return board.getTeleportDestination(playerPosition);
    }

    public int calculatePlayerNewPosition(int currentPosition, int step) {
        int newPlayerPosition = currentPosition + step;

        if (isPlayerAtTeleporterCell(newPlayerPosition)) {
            newPlayerPosition = getTeleportDestination(newPlayerPosition);
        }

        return newPlayerPosition;
    }

    public void play() {
        int currentPlayerIndex = 0;
        Player currentPlayer = players[currentPlayerIndex];
        boolean isGameEnded = false;

        while (!isGameEnded) {
            playRound(currentPlayer);

            isGameEnded = isGameEnded(currentPlayer.getPosition(), board.getGoal());
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
            currentPlayer = players[currentPlayerIndex];
        }
    }

    public void playRound(Player currentPlayer) {
        int step = rollDice();

        currentPlayer.setPosition(calculatePlayerNewPosition(currentPlayer.getPosition(), step));
    }
}
