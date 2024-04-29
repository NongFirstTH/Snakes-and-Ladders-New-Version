import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int destination;
    private final Map<Integer, Snake> snakes;
    private final Map<Integer, Ladder> ladders;

    public Board() {
        this.destination = 100;

        HashMap<Integer, Snake> snakes = new HashMap<>();
        Snake snake1 = new Snake(23, 3);
        Snake snake2 = new Snake(46, 26);
        Snake snake3 = new Snake(59, 43);
        Snake snake4 = new Snake(73, 54);
        Snake snake5 = new Snake(73, 54);
        Snake snake6 = new Snake(91, 50);
        Snake snake7 = new Snake(98, 65);
        snakes.put(snake1.getHead(), snake1);
        snakes.put(snake2.getHead(), snake2);
        snakes.put(snake3.getHead(), snake3);
        snakes.put(snake4.getHead(), snake4);
        snakes.put(snake5.getHead(), snake5);
        snakes.put(snake6.getHead(), snake6);
        snakes.put(snake7.getHead(), snake7);

        HashMap<Integer, Ladder> ladders = new HashMap<>();
        Ladder ladder1 = new Ladder(2, 39);
        Ladder ladder2 = new Ladder(6, 14);
        Ladder ladder3 = new Ladder(28, 53);
        Ladder ladder4 = new Ladder(57, 78);
        Ladder ladder5 = new Ladder(74, 95);
        ladders.put(ladder1.getBottom(), ladder1);
        ladders.put(ladder2.getBottom(), ladder2);
        ladders.put(ladder3.getBottom(), ladder3);
        ladders.put(ladder4.getBottom(), ladder4);
        ladders.put(ladder5.getBottom(), ladder5);

        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSnakeTail(int position) {
        return snakes.get(position).getTail();
    }

    public int getLadderTop(int position) {
        return ladders.get(position).getTop();
    }

    public int getDestination() {
        return destination;
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }
}
