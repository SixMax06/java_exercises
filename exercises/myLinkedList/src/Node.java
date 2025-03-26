public class Node {
    public Node next;
    public int value;

    public Node(int value) {
        this.next = null;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
