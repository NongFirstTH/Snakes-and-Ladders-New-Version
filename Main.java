import java.util.LinkedList;
import java.util.Queue;

import models.Player;
import models.SnakesLaddersGameLogic;
import view.AfterPlayerGameUI;
import view.BeforePlayGameUI;
import view.WhilePlayGameUI;

public class Main {
    static BeforePlayGameUI beforePlayGameUI = new BeforePlayGameUI();
    static WhilePlayGameUI whilePlayGameUI = new WhilePlayGameUI();
    static AfterPlayerGameUI afterPlayerGameUI = new AfterPlayerGameUI();

    public static void main(String[] args) {
        do {
            playGame(setupPlayersBeforePlayGame());
        } while (isPlayAgain());
    }

    public static Queue<Player> setupPlayersBeforePlayGame() {
        return createPlayersQueue(
                beforePlayGameUI.askNameOfPlayers(
                        beforePlayGameUI.askNumberOfPlayers()));
    }

    public static void playGame(Queue<Player> players) {
        SnakesLaddersGameLogic snakesLaddersGameController = new SnakesLaddersGameLogic(whilePlayGameUI);

        afterPlayerGameUI.printWinner(
            snakesLaddersGameController.playUntilGetWinner(players));
    }

    public static boolean isPlayAgain() {
        return afterPlayerGameUI.askIfWantToPlayAgain().equalsIgnoreCase("yes");
    }

    public static Queue<Player> createPlayersQueue(String[] playersNames) {
        Queue<Player> playersQueue = new LinkedList<>();

        for (String playersName : playersNames) {
            playersQueue.add(new Player(playersName));
        }

        return playersQueue;
    }
}
