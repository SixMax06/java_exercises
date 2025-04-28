public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(7);
        list.addFirst(9);
        System.out.println(list.getLast());
        list.remove(0);
        System.out.println(list);
    }
}