public class MyLinkedList {

     private static class Node {
        public Node next;
        public Object value;

        public Node(Object value, Node next) {
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

    public void addFirst(Object n) {
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

    public Object getFirst() {
        return this.head.value;
    }

    public Object get(int index) {
        if (index < 0 || index > this.size - 1)
            throw new IndexOutOfBoundsException();

        Node target = this.head;
        for (int i = 0; i < index; i++)
            target = target.next;

        return target.value;
    }

<<<<<<< Updated upstream
    public Object getLast() {
=======
    public void insertOnes() {
        Node target = this.head;
        for (int i = 1; i < this.size; i+=2) {
            target.next = new Node(1, target.next);
            this.size++;
            target = target.next.next;
        }
    }

    public int getLast() {
>>>>>>> Stashed changes
        return this.get(this.size - 1);
    }

    //recent test method
    public void insertOnes() {
        if (this.head == null || this.size == 0)
            return;
        Node target = this.head;
        target.next = new Node(1, target.next);
        target = target.next.next;
        for (int i = 1; i < size - 1; i++) {
            target.next = new Node(1, target.next);
            target = target.next.next;
        }
        size += (size - 1);
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
