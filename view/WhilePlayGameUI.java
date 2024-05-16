package view;

import java.util.Scanner;
import models.GameState;
import models.Player;

public class WhilePlayGameUI {
    
    public void printGameState(GameState gameState) {
        Player currentPlayer = gameState.getCurrentPlayer();
        String name = currentPlayer.getName();
        
        System.out.println("-------------------------------------------------");
        System.out.println(name + " roll dice = " + gameState.getDiceResult());
        System.out.println(name + " move to " + gameState.getCurrentPlayer().getPosition());
        System.out.println("-------------------------------------------------");
    }
    
    public void recieveEnterFromCurrentPlayer(Player currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print(currentPlayer.getName() + " press enter to roll a dice: ");

        scanner.nextLine();
    }
}
