package models;

import java.util.Queue;
import view.WhilePlayGameUI;

public class SnakesLaddersGameLogic {
    private final Dice dice;
    private final Board board;
    private final WhilePlayGameUI whilePlayGameUI;

    public SnakesLaddersGameLogic(WhilePlayGameUI whilePlayGameUI) {
        this.whilePlayGameUI = whilePlayGameUI;
        dice = new Dice(6);
        board = new Board();
    }

    public Player playUntilGetWinner(Queue<Player> players) {
        GameState gameState = new GameState(players, 0);

        while (true) {
            Player currentPlayer = gameState.getCurrentPlayer();

            whilePlayGameUI.printGameState(playRound(gameState));

            if (isGameEnded(currentPlayer.getPosition())) {
                break;
            }

            changeTurn(gameState);
        }

        return gameState.getCurrentPlayer();
    }

    private GameState playRound(GameState gameState) {
        Player currentPlayer = gameState.getCurrentPlayer();

        whilePlayGameUI.recieveEnterFromCurrentPlayer(currentPlayer);

        int diceResult = rollDice();
        int newPlayerPosition = calculateNewPlayerPosition(currentPlayer.getPosition(), diceResult);

        currentPlayer.setPosition(newPlayerPosition);
        gameState.setDiceResult(diceResult);

        return gameState;
    }

    private void changeTurn(GameState gameState) {
        Queue<Player> players = gameState.getPlayers();
        Player currentPlayer = players.poll();

        players.add(currentPlayer);
    }

    private boolean isGameEnded(int playerPosition) {
        return playerPosition >= board.getGoal();
    }

    private int rollDice() {
        return dice.roll();
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
