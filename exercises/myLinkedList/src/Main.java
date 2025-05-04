public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(3);
        System.out.println(list);

        list.insertOnes();
        System.out.println(list);
    }
}