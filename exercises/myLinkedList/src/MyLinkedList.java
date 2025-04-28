public class MyLinkedList {

     private static class Node {
        public Node next;
        public int value;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int n) {
        this.head = new Node(n, this.head);
        this.size++;
    }

    public void add(int n, int index) {
        if (index < 0 || index > this.size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.addFirst(n);
            return;
        }

        Node target = this.head;
        for (int i = 1; i < index; i++)
            target = target.next;

        target.next = new Node(n, target.next);
        this.size++;
    }

    public void addLast(int n) {
        this.add(n, this.size);
        this.size++;
    }

    public void removeFirst() {
        if (this.size > 0) {
            this.head = this.head.next;
            this.size--;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.removeFirst();
            return;
        }

        Node target = this.head;
        for (int i = 1; i < index; i++) {
            target = target.next;
        }
        target.next = target.next.next;
        this.size--;
    }

    public void removeLast() {
        if (this.size > 0) {
            remove(this.size - 1);
        }
    }

    public int getFirst() {
        return this.head.value;
    }

    public int get(int index) {
        if (index < 0 || index > this.size - 1)
            throw new IndexOutOfBoundsException();

        Node target = this.head;
        for (int i = 0; i < index; i++)
            target = target.next;

        return target.value;
    }

    public int getLast() {
        return this.get(this.size - 1);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.size == 0)
            return "[]";

        StringBuilder output = new StringBuilder();
        output.append("[");

        Node temp = head;

        while (temp != null) {
            output.append(temp).append(", ");
            temp = temp.next;
        }

        output = new StringBuilder(output.substring(0, output.length() - 2));

        output.append("]");

        return output.toString();
    }
}
