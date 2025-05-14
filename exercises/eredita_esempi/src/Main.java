import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Rettangolo r = new Rettangolo(2, 4);
        System.out.println(r.getPerimetro());
        r.sposta(2, 2);
        System.out.println(r);

        LinkedList<Rettangolo> lr = new LinkedList<>();
        lr.add(r);
        lr.add(new Rettangolo(5, 7, "Blu", 9, 8));
        for (Rettangolo ret : lr)
            ret.sposta(1, 1);
    }
}