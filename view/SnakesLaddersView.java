package view;
import java.util.Scanner;

import models.GameState;
import models.Player;

public class SnakesLaddersView {
    private Scanner scanner = new Scanner(System.in);

    public int askNumberOfPlayers() {
        System.out.print("Enter number of players: ");

        int numberOfPlayer = scanner.nextInt();
        scanner.nextLine();

        return numberOfPlayer;
    }

    public String[] askNameOfPlayers(int numberOfPlayer) {
        String[] playersName = new String[numberOfPlayer];

        for (int playerIndex = 0; playerIndex < numberOfPlayer; playerIndex++) {
            System.out.printf("Player %d: ", playerIndex + 1);
            playersName[playerIndex] = scanner.nextLine();
        }

        return playersName;
    }

    public String askIfWantToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no) ");

        String answer = scanner.nextLine();

        return answer;
    }

    public void printGameState(GameState gameState) {
        Player currentPlayer = gameState.getCurrentPlayer();
        String name = currentPlayer.getName();

        System.out.println("-------------------------------------------------");
        System.out.println(name + " roll dice = " + gameState.getDiceResult());
        System.out.println(name + " move to " + gameState.getCurrentPlayer().getPosition());
        System.out.println("-------------------------------------------------");
    }

    public void printCurrentPlayerName(Player currentPlayer) {
        System.out.print(currentPlayer.getName());
    }

    public void recieveEnterFromCurrentPlayer() {
        System.out.print(" press enter to roll a dice: ");

        scanner.nextLine();
    }

    public void printWinner(Player currentPlayer) {
        System.out.println("The winner is " + currentPlayer.getName());
    }
}
