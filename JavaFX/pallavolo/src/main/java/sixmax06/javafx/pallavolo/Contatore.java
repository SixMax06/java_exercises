package sixmax06.javafx.pallavolo;

public class Contatore {
    private int set;
    private int punteggio;
    private final int MAX;

    public Contatore(int max) {
        this.set = 0;
        this.punteggio = 0;
        this.MAX = max;
    }

    public void incrementa() {
        this.punteggio++;
        this.set += this.punteggio / MAX;
        this.punteggio %= this.MAX;
    }

    @Override
    public String toString() {
        return "Set: " + this.set + "\nPunteggio: " + this.punteggio;
    }
}
