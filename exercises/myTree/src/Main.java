public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(7);
        tree.add(11, 7);
        tree.add(12, 7);
        tree.add(13, 11);
        tree.anticipatedVisit();
        System.out.println();
        tree.differedVisit();
    }
}