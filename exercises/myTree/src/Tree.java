import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {

    private static class Node {
        int data;
        LinkedList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new LinkedList<>();
        }
    }

    private Node root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public Tree(int n) {
        root = new Node(n);
        size = 1;
    }

    private Node findNode(int searchData, Node current) {
        if (current == null)
            return null;

        if (current.data == searchData)
            return current;

        for (Node child : current.children) {
            Node found = findNode(searchData, child);
            if (found != null)
                return found;
        }

        return null;
    }

    public boolean add(int n, int father) {
        Node found = findNode(father, root);

        if (found == null)
            return false;

        found.children.add(new Node(n));
        size++;
        return true;
    }

    private static String anticipatedVisitR(Node father) {
        StringBuilder result = new StringBuilder();
        result.append(father.data);

        for (Node child : father.children)
            anticipatedVisitR(child);

        return result.toString();
    }

    public String anticipatedVisit() {
        if (root != null)
            return anticipatedVisitR(root);
    }

    private static void differedVisitR(Node father) {
        for (Node child : father.children)
            differedVisitR(child);

        System.out.print(father.data + " ");
    }

    public void differedVisit() {
        if (root != null)
            differedVisitR(root);
    }

    public int getMax() {
        String elements = this.anticipatedVisit();
        ArrayList<Integer> elementsArray = new ArrayList<>(List.of(elements.split(" ")));
    }
}
