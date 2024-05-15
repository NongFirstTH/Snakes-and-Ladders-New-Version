package models;
import java.util.Random;

public class Dice {
    private final int numberOfFaces;

    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int roll() {
        Random random = new Random();
        int diceResult = random.nextInt(numberOfFaces) + 1;

        return diceResult;
    }
}
