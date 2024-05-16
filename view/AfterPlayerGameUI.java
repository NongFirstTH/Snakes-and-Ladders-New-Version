package view;

import java.util.Scanner;
import models.Player;

public class AfterPlayerGameUI {
    
    public String askIfWantToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Do you want to play again? (yes/no) ");

        String answer = scanner.nextLine();

        return answer;
    }

    public void printWinner(Player currentPlayer) {
        System.out.println("The winner is " + currentPlayer.getName());
    }
}
