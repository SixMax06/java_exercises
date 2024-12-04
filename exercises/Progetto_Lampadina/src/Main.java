public class Main {
    public static void inizializzaLampadine(Lampadina[] v){
        for (int i = 0; i < v.length; i++) {
            v[i] = new Lampadina(80);
            v[i].setNome("Lampadina_" + (i+1));
        }
    }

    public static void stampaLampadine(SistemaDomotico s){
        System.out.println(s);
    }

    public static Lampadina[] tornaAccese(Lampadina[] v){
        Lampadina[] accese;
        int conta = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null && v[i].isAcceso()){
                conta++;
            }
        }
        accese = new Lampadina[conta];
        int j = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != null && v[i].isAcceso()){
                accese[j] = v[i];
                j++;
            }
        }
        return accese;
    }

    public static void main(String[] args) {
        final int MAX = 100;
        SistemaDomotico sistemaDomotico = new SistemaDomotico(MAX);
        inizializzaLampadine(sistemaDomotico.getLampadine());
        Lampadina l1 = new Lampadina(8.0f, "01");
        Lampadina l2 = new Lampadina(20.0f, "02");
        Lampadina l3 = new Lampadina(10.0f, "03");
        sistemaDomotico.aggiungi(l1);
        sistemaDomotico.aggiungi(l2);
        sistemaDomotico.aggiungi(l3);
        sistemaDomotico.accendi("01");
        stampaLampadine(sistemaDomotico);

    }
}