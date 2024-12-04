import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Lampadina> v; //array di lampadine

        //creazione dell'oggetto di tipo ArrayList
        v = new ArrayList<>();
        //da questo momento esiste un oggetto nell'heap che rappresenta un vettore lampadina al momento vuoto

        Lampadina l = new Lampadina();
        v.add(l); //add == push_back di C++
        v.add(1, new Lampadina()); //add ha anche un parametro di index (== insert di C++)

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.get(i));
        }

        //ArrayList ha il suo metodo toString e stampa nella nella forma : [e1, e2, e3, ... , eN]
        System.out.println(v); //toString di ArrayList usa il toString della classe dichiarata nell'array

        for (Lampadina lam : v) {
            System.out.println(lam);
        }

        ArrayList<Integer> li;
    }
}
