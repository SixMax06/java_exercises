public class SistemaDomotico {
    private final int MAX;
    private Lampadina[] lampadine;
    private int nLampadine;

    public SistemaDomotico(int lunghezza){
        this.lampadine = new Lampadina[lunghezza];
        this.MAX = lunghezza;
        this.nLampadine = 0;
    }

    public Lampadina[] getLampadine() {
        return lampadine;
    }

    public void setLampadine(Lampadina[] lampadine) {
        this.lampadine = lampadine;
    }

    public int getMAX() {
        return MAX;
    }

    public void aggiungi(Lampadina l){
        this.lampadine[nLampadine] = l;
        nLampadine++;
    }

    private Lampadina cerca(String nome){
        for(int i = 0; i < this.nLampadine; i++){
            if(this.lampadine[i].getNome().equals(nome)){
                return this.lampadine[i];
            }
        }
        return null;
    }

    private int cercaPos(String nome){
        for(int i = 0; i < this.nLampadine; i++){
            if(this.lampadine[i].getNome().equals(nome)){
                return i;
            }
        }
        return -1;
    }

    public void accendi(String nome){
        Lampadina l;
        l = this.cerca(nome);
        if(l != null){
            l.accendi();
        }
    }

    public void spegni(String nome){
        Lampadina l;
        l = this.cerca(nome);
        if(l != null){
            l.spegni();
        }
    }

    @Override
    public String toString(){
        String s = "";

        for(int i = 0; i < this.nLampadine; i++)
            if(this.lampadine[i] != null)
                s = s + this.lampadine[i].toString() + "\n";

        return s;
    }
}