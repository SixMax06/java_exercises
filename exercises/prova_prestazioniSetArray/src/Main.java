import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        TreeSet<Integer> ts = new TreeSet<>();
        HashSet<Integer> hs = new HashSet<>();

        final int N_ELEMENTI = 1000000;
        final int GRANDEZZA = 1000000000;

        for (int i = 0; i < N_ELEMENTI; i++) {
            int n = (int) (Math.random() * GRANDEZZA);
            al.add(n);
            ts.add(n);
            hs.add(n);
        }

        System.out.println(al.size());
        System.out.println(ts.size());
        System.out.println(hs.size());

        ArrayList<Integer> cercati = new ArrayList<>();
        final int N_CERCATI = N_ELEMENTI / 1;

        for (int i = 0; i < N_CERCATI; i++) {
            int n = (int) (Math.random() * GRANDEZZA);
            cercati.add(n);
        }

        //Misura delle prestazioni di un array in ricerca
        long start = System.currentTimeMillis();
        int quanti = 0;

        for (Integer i : cercati) {
            if (al.contains(i)) {
                quanti++;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Found " + quanti + " elements in " + (double)(end - start)/1000 + " seconds");

        //Misura delle prestazoini di un treeset in ricerca
        start = System.currentTimeMillis();
        quanti = 0;

        for (Integer i : cercati) {
            if (ts.contains(i)) {
                quanti++;
            }
        }

        end = System.currentTimeMillis();
        System.out.println("Found " + quanti + " elements in " + (double)(end - start)/1000 + " seconds");

        //Misura delle prestazoini di un treeset in ricerca
        start = System.currentTimeMillis();
        quanti = 0;

        for (Integer i : cercati) {
            if (hs.contains(i)) {
                quanti++;
            }
        }

        end = System.currentTimeMillis();
        System.out.println("Found " + quanti + " elements in " + (double)(end - start)/1000 + " seconds");
    }
}