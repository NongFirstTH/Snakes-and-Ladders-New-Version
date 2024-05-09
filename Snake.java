public class Snake implements Teleporter {
  private int head;
  private int tail;

  Snake(int head, int tail) {
    this.head = head;
    this.tail = tail;
  }

  @Override
  public int getSource() {
    return head;
  }

  @Override
  public int getDestination() {
    return tail;
  }
}
