package models;
public class Board {
    private int numberOfCells;
    private final Cell[] cells;

    public Board() {
        numberOfCells = 100;

        cells = new Cell[numberOfCells];

        for (int cellIndex = 0; cellIndex < numberOfCells; cellIndex++) {
            cells[cellIndex] = new Cell();
        }

        setLadders();
        setSnakes();
    }

    public int getGoal() {
        return numberOfCells;
    }

    public boolean isTeleporterCell(int cellPosition) {
        if (cellPosition >= numberOfCells) {
            return false;
        }

        int cellIndex = cellPosition - 1;

        return cells[cellIndex].isTeleporter();
    }

    public int getTeleportDestination(int sourcePosition) {
        int cellIndex = sourcePosition - 1;

        return cells[cellIndex].getTeleportDestination();
    }

    private void setLadders() {
        Teleporter ladder1 = new Ladder(2, 39);
        Teleporter ladder2 = new Ladder(6, 14);
        Teleporter ladder3 = new Ladder(28, 53);
        Teleporter ladder4 = new Ladder(57, 78);
        Teleporter ladder5 = new Ladder(74, 95);

        cells[ladder1.getSource() - 1].setTeleporter(ladder1);
        cells[ladder2.getSource() - 1].setTeleporter(ladder2);
        cells[ladder3.getSource() - 1].setTeleporter(ladder3);
        cells[ladder4.getSource() - 1].setTeleporter(ladder4);
        cells[ladder5.getSource() - 1].setTeleporter(ladder5);
    }

    private void setSnakes() {
        Teleporter snake1 = new Snake(23, 3);
        Teleporter snake2 = new Snake(46, 26);
        Teleporter snake3 = new Snake(59, 43);
        Teleporter snake4 = new Snake(73, 54);
        Teleporter snake5 = new Snake(91, 50);
        Teleporter snake6 = new Snake(98, 65);

        cells[snake1.getSource() - 1].setTeleporter(snake1);
        cells[snake2.getSource() - 1].setTeleporter(snake2);
        cells[snake3.getSource() - 1].setTeleporter(snake3);
        cells[snake4.getSource() - 1].setTeleporter(snake4);
        cells[snake5.getSource() - 1].setTeleporter(snake5);
        cells[snake6.getSource() - 1].setTeleporter(snake6);
    }
}
