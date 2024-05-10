import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Player[] players;

    public static int askNumberOfPlayers() {
        System.out.print("Enter number of players: ");

        int numberOfPlayer = scanner.nextInt();
        scanner.nextLine();

        return numberOfPlayer;
    }

    public static String[] askNameOfPlayers(int numberOfPlayer) {
        String[] playersName = new String[numberOfPlayer];

        for (int playerIndex = 0; playerIndex < numberOfPlayer; playerIndex++) {
            System.out.printf("Player %d: ", playerIndex + 1);
            playersName[playerIndex] = scanner.nextLine();
        }

        return playersName;
    }

    public static Player[] createPlayers(String[] playersName) {
        int numberOfPlayer = playersName.length;
        Player[] players = new Player[numberOfPlayer];

        for (int playerIndex = 0; playerIndex < numberOfPlayer; playerIndex++) {
            players[playerIndex] = new Player(playersName[playerIndex]);
        }

        return players;
    }

    public static String askIfWantToPlayAgain() {
        System.out.print("Do you want to play again? (yes/no) ");

        String answer = scanner.nextLine();

        return answer;
    }

    public static boolean isPlayAgain() {
        return askIfWantToPlayAgain().equalsIgnoreCase("yes");
    }

    public static void setupPlayersBeforePlayGame() {
        players = createPlayers(askNameOfPlayers(askNumberOfPlayers()));
    }

    public static void playGame() {
        SnakesLaddersGameController snakesLaddersGameController = new SnakesLaddersGameController(players);

        snakesLaddersGameController.play();
    }

    public static void main(String[] args) {
        do {
            setupPlayersBeforePlayGame();
            playGame();
        } while (isPlayAgain());
    }
}
