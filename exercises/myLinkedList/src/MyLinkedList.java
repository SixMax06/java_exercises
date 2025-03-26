public class MyLinkedList {
    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Node n) {
        if (head != null)
            head.next = head;

        head = n;
        this.size++;
    }

    public boolean add(Node n, int index) {
        if (index < 0 || index > this.size)
            return false;

        if (index == 0) {
            this.add(n);
            return true;
        }

        Node target = head;
        for (int i = 1; i < index; i++)
            target = head.next;

        target.next = target;
        target = n;
        this.size++;

        return true;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            output.append(temp).append(", ");
            temp = temp.next;
        }
        return output.toString();
    }
}
