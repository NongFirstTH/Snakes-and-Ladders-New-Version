public class Board {
    private final int destination;
    private final Snake[] snakes;
    private final Ladder[] ladders;

    public Board(int destination, Snake[] snakes, Ladder[] ladders) {
        this.destination = destination;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSnakeTail(int position) {
        return 0;
    }

    public int getLadderTop(int position) {
        return 0;
    }

    public int getDestination() {
        return destination;
    }

    public Snake[] getSnakes() {
        return snakes;
    }

    public Ladder[] getLadders() {
        return ladders;
    }
}
