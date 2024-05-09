public class Cell {
    private Teleporter teleporter;

    public void setTeleporter(Teleporter teleporter) {
        this.teleporter = teleporter;
    }

    public boolean isTeleporter() {
        return teleporter != null;
    }

    public int getTeleportDestination() {
        return teleporter.getDestination();
    }
}
