package view;

import java.util.Scanner;

public class BeforePlayGameUI {
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
}
