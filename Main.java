import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static int askNumberOfPlayer() {
        System.out.print("Enter number of players: ");
        int numberOfPlayer = scanner.nextInt();
        scanner.nextLine();

        return numberOfPlayer;
    }

    public static String[] askNameOfPlayer(int numberOfPlayer) {
        String[] playersNames = new String[numberOfPlayer];

        for (int playerIndex = 0; playerIndex < numberOfPlayer; playerIndex++) {
            System.out.printf("Player %d: ", playerIndex + 1);
            playersNames[playerIndex] = scanner.nextLine();
        }
        
        return playersNames;
    }

    
    public static Player[] createPlayer(String[] playerNames) {
        int numberOfPlayer = playerNames.length;
        Player[] players = new Player[numberOfPlayer];

        for (int playerIndex = 0; playerIndex < playerNames.length; playerIndex++) {
            players[playerIndex] = new Player(playerNames[playerIndex]);
        }
     
        return players;
    }

    public static String askIsYouWantPlayAgain() {
        String answer;

        System.out.print("Do you want to play again? (yes/no) ");

        answer = scanner.nextLine();

        return answer;
    }

    public static boolean isPlayerPlayAgain(String answer) {
        return answer.equalsIgnoreCase("yes");
    }
    public static void main(String[] args) {
        do {
            Player[] players = createPlayer(askNameOfPlayer(askNumberOfPlayer()));
            SnakesAndLaddersGameController controller = new SnakesAndLaddersGameController(players);
        
            controller.play(); 

        } while (isPlayerPlayAgain(askIsYouWantPlayAgain()));
    }
}
