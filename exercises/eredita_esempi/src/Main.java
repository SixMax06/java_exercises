public class Main {
    public static void main(String[] args) {
        Rettangolo r = new Rettangolo(2, 4);
        System.out.println(r.getPerimetro());
        r.sposta(2, 2);
        System.out.println(r);
    }
}