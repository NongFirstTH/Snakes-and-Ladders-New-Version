public class Player {
    private int position = 1;
    private final String name;

    Player(String name) {
        this.name = name;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public int getPosition() {
        return position;
    }
}
