public class Main {
    public static void main(String[] args) {
        Resistore r = new Resistore("R1", 100);
        System.out.println(r);
        System.out.println(r.getImpedenza());
    }
}