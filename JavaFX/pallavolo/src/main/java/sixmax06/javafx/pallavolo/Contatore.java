package sixmax06.javafx.pallavolo;

public class Contatore {
    private int set;
    private int punteggio;
    private int MAX;
    private boolean vittoria;

    public Contatore(int max) {
        this.set = 0;
        this.punteggio = 0;
        this.MAX = max;
        this.vittoria = false;
    }

    public void incrementa() {
        this.punteggio++;
        if (this.punteggio == MAX) {
            this.punteggio = 0;
            this.set++;
            this.vittoria = true;
        }
    }

    public int getPunteggio() {
        return this.punteggio;
    }

    public int getMAX() {
        return this.MAX;
    }

    public void setMAX(int max) {
        this.MAX = max;
    }

    public boolean isVittoria() {
        return this.vittoria;
    }

    public void resetVittoria() {
        this.vittoria = false;
    }

    public void resetPunteggio() {
        this.punteggio = 0;
    }

    public void reset() {
        this.set = 0;
        this.punteggio = 0;
        this.vittoria = false;
    }

    @Override
    public String toString() {
        return "Set: " + this.set + "\nPunteggio: " + this.punteggio;
    }
}
