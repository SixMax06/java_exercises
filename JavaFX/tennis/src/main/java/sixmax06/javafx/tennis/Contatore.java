package sixmax06.javafx.tennis;

public class Contatore {
    private int punteggio, set;

    public Contatore() {
        this.punteggio = 0;
        this.set = 0;
    }

    public void incrementaPunteggio() {
        punteggio++;

        if (punteggio == 4) {
            set++;
            punteggio = 0;
        }
    }

    public void decrementaPunteggio() {
        punteggio--;

        if (punteggio < 0) {
            set--;
            punteggio = 3;
        }
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getSet() {
        return set;
    }

    public void resetContatore() {
        set = 0; punteggio = 0;
    }

    @Override
    public String toString() {
        return set + " | " + punteggio;
    }
}
