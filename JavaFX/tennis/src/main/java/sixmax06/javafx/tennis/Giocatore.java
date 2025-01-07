package sixmax06.javafx.tennis;

public class Giocatore {
    private Contatore[] set;
    private final String nome;
    private int setVinti, maxSet;

    public Giocatore(String nome) {
        this.nome = nome;
        setVinti = 0;
        this.maxSet = 6;
        set = new Contatore[5];
        for (int i = 0; i < set.length; i++) set[i] = new Contatore();
    }

    public void incrementa(int index) throws VittoriaSet, VittoriaGame, Vittoria {
        if (set[index] != null) {
            try {
                set[index].incrementaPunteggio();
            } catch (VittoriaGame vittoriaGame) {
                if (set[index].getGame() == maxSet) {
                    setVinti++;
                    if (setVinti == 3) {
                        throw new Vittoria();
                    }
                    throw new VittoriaSet();
                }
                throw new VittoriaGame();
            }
        }
    }

    public void decrementa(int index) {
        if (set[index] != null) {
            set[index].decrementaPunteggio();
        }
    }

    public void attivaVantaggio(int index) {
        if (set[index] != null) {
            set[index].attivaVantaggio();
        }
    }

    public void resetVantaggio(int index) {
        if (set[index] != null) {
            set[index].resetVantaggio();
        }
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio(int index) {
        return set[index].getPunteggio();
    }

    public String printGame(int index) {
        return set[index].toString();
    }

    public void resetPunteggio(int index) {
        set[index].resetPunteggio();
    }

    public void resetGiocatore() {
        setVinti = 0;
        for (Contatore c : set) c.resetContatore();
    }
}
