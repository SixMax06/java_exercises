package sixmax06.javafx.tennis;

public class Giocatore {
    private Contatore[] game;
    private final String nome;
    private int gameVinti;

    public Giocatore(String nome) {
        this.nome = nome;
        game = new Contatore[5];
        gameVinti = 0;
    }

    public int incrementa(int index) {
        Contatore conta = game[index];

        if (conta != null) {
            conta.incrementaPunteggio();

            if (conta.getSet() == 6) {
                gameVinti++;
                return index + 1;
            }

        }
        return index;
    }

    public void decrementa(int index) {
        Contatore conta = game[index];

        if (conta != null) {
            conta.decrementaPunteggio();
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
