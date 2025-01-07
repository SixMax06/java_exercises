package sixmax06.javafx.tennis;

public class Contatore {
    private int punteggio, game;
    private int maxPunteggio;
    private final String[] punteggioPrint = {"0", "15", "30", "40", "50"};

    public Contatore() {
        this.punteggio = 0;
        this.game = 0;
        this.maxPunteggio = 4;
    }

    public void incrementaPunteggio() throws VittoriaGame {
        punteggio++;

        if (punteggio >= maxPunteggio) {
            game++;
            punteggio = 0;
            throw new VittoriaGame();
        }
    }

    public void decrementaPunteggio() {
        if (game == 0 && punteggio == 0) return;
        punteggio--;

        if (punteggio < 0) {
            game--;
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

    public int getGame() {
        return game;
    }

    public void resetPunteggio() {
        punteggio = 0;
    }

    public void resetContatore() {
        game = 0;
        punteggio = 0;
    }

    @Override
    public String toString() {
        String print = game + " | ";

        if (punteggio >= 4) print += "VAN";
        else print += punteggioPrint[punteggio];

        return print;
    }
}
