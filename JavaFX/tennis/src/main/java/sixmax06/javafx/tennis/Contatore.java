package sixmax06.javafx.tennis;

public class Contatore {
    private int punteggio, set;
    private int maxPunteggio;
    private final int[] punteggioPrint = {0, 15, 30, 40, 50};

    public Contatore() {
        this.punteggio = 0;
        this.set = 0;
        this.maxPunteggio = 4;
    }

    public void incrementaPunteggio() throws VittoriaSet {
        punteggio++;

        if (punteggio == maxPunteggio) {
            set++;
            punteggio = 0;
            throw new VittoriaSet();
        }
    }

    public void decrementaPunteggio() {
        punteggio--;

        if (punteggio < 0) {
            set--;
            punteggio = 3;
        }
    }

    public void attivaVantaggio() {
        maxPunteggio = 5;
    }

    public void disattivaVantaggio() {
        maxPunteggio = 4;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public int getSet() {
        return set;
    }

    public void resetPunteggio() {
        punteggio = 0;
    }

    public void resetContatore() {
        set = 0; punteggio = 0;
    }

    @Override
    public String toString() {
        return set + " | " + punteggioPrint[punteggio];
    }
}
