package models;
public class Player {
    private int position = 1;
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
