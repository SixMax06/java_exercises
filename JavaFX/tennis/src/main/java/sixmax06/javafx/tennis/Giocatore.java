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

    public int incrementa(int index) {
        if (game[index] != null) {
            game[index].incrementaPunteggio();

            if (game[index].getSet() == 6) {
                gameVinti++;
                return index + 1;
            }

        }
        return index;
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

    public void resetGiocatore() {
        gameVinti = 0;
        for (Contatore c : game) c.resetContatore();
    }
}
