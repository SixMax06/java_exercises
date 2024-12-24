package sixmax06.javafx.tennis;

public class Giocatore {
    private Contatore[] game;
    private final String nome;
    private int gameVinti;

    public Giocatore(String nome) {
        this.nome = nome;
        gameVinti = 0;
        game = new Contatore[5];
        for (int i = 0; i < game.length; i++) game[i] = new Contatore();
    }

    public void incrementa(int index) throws VittoriaSet, VittoriaGame, Vittoria {
        if (game[index] != null) {
            try {
                game[index].incrementaPunteggio();
            } catch (VittoriaSet vittoriaSet) {
                if (game[index].getSet() == 6) {
                    gameVinti++;
                    if (gameVinti == 3) {
                        throw new Vittoria();
                    }
                    throw new VittoriaGame();
                }
                throw new VittoriaSet();
            }
        }
    }

    public void decrementa(int index) {
        if (game[index] != null) {
            game[index].decrementaPunteggio();
        }
    }

    public String getNome() {
        return nome;
    }

    public String printGame(int index) {
        return game[index].toString();
    }

    public void resetPunteggio(int index) {
        game[index].resetPunteggio();
    }

    public void resetGiocatore() {
        gameVinti = 0;
        for (Contatore c : game) c.resetContatore();
    }
}
