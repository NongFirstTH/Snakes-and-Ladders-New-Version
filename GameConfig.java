public class GameConfig {
    private final Board board;
    private final Dice dice;

    public GameConfig(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }
}
