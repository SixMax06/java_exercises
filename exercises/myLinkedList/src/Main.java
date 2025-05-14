public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(3);
<<<<<<< Updated upstream
        System.out.println(list);
=======
        list.addFirst(5);
        list.addFirst(7);
        list.addFirst(9);
>>>>>>> Stashed changes

        list.insertOnes();
        System.out.println(list);
        System.out.println(list.getSize());
    }
}