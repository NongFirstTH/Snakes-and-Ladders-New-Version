package models;
public class Ladder implements Teleporter {
    private final int bottom;
    private final int top;

    public Ladder(int bottom, int top) {
        this.bottom = bottom;
        this.top = top;
    }

    @Override
    public int getSource() {
        return bottom;
    }

    @Override
    public int getDestination() {
        return top;
    }
}
