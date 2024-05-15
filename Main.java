
import java.util.LinkedList;
import java.util.Queue;

import controller.SnakesLaddersGameController;
import models.Player;
import view.SnakesLaddersView;

public class Main {
    static SnakesLaddersView snakesLaddersView = new SnakesLaddersView();

    public static Queue<Player> createPlayersQueue(String[] playersNames) {
        Queue<Player> playersQueue = new LinkedList<>();

        for (String playersName : playersNames) {
            playersQueue.add(new Player(playersName));
        }

        return playersQueue;
    }

    public static boolean isPlayAgain() {
        return snakesLaddersView.askIfWantToPlayAgain().equalsIgnoreCase("yes");
    }

    public static Queue<Player> setupPlayersBeforePlayGame() {
        return createPlayersQueue(
                snakesLaddersView.askNameOfPlayers(
                        snakesLaddersView.askNumberOfPlayers()));
    }

    public static void playGame(Queue<Player> players) {
        SnakesLaddersGameController snakesLaddersGameController = new SnakesLaddersGameController(snakesLaddersView);

        snakesLaddersGameController.play(players);
    }

    public static void main(String[] args) {
        do {
            playGame(setupPlayersBeforePlayGame());
        } while (isPlayAgain());
    }
}
