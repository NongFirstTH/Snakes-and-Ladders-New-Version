package controller;

import java.util.Queue;
import models.Board;
import models.Dice;
import models.GameState;
import models.Player;
import view.SnakesLaddersView;

public class SnakesLaddersGameController {
    private final Dice dice;
    private final Board board;
    private final SnakesLaddersView snakesLaddersView;

    public SnakesLaddersGameController(SnakesLaddersView snakesLaddersView) {
        this.snakesLaddersView = snakesLaddersView;
        dice = new Dice(6);
        board = new Board();
    }

    public void play(Queue<Player> players) {
        GameState gameState = new GameState(players, 0);

        while (true) {
            Player currentPlayer = gameState.getCurrentPlayer();

            snakesLaddersView.printGameState(playRound(gameState));

            if (isGameEnded(currentPlayer.getPosition())) {
                break;
            }

            changeTurn(gameState);
        }

        snakesLaddersView.printWinner(gameState.getCurrentPlayer());
    }

    private GameState playRound(GameState gameState) {
        Player currentPlayer = gameState.getCurrentPlayer();

        snakesLaddersView.recieveEnterFromCurrentPlayer(currentPlayer);

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
