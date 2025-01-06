package sixmax06.javafx.tennis;

public class Contatore {
    private int punteggio, set;
    private int maxPunteggio;
    private final String[] punteggioPrint = {"0", "15", "30", "40", "50"};

    public Contatore() {
        this.punteggio = 0;
        this.set = 0;
        this.maxPunteggio = 4;
    }

    public void incrementaPunteggio() throws VittoriaSet {
        punteggio++;

        if (punteggio >= maxPunteggio) {
            set++;
            punteggio = 0;
            throw new VittoriaSet();
        }
    }

    public void decrementaPunteggio() {
        if (set == 0 && punteggio == 0) return;
        punteggio--;

        if (punteggio < 0) {
            set--;
            punteggio = 3;
        }
    }

    public void attivaVantaggio() {
        maxPunteggio = 5;
    }

    public void resetVantaggio() {
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
        set = 0;
        punteggio = 0;
    }

    @Override
    public String toString() {
        String print = set + " | ";

        if (punteggio >= 4) print += "VAN";
        else print += punteggioPrint[punteggio];

        return print;
    }
}
