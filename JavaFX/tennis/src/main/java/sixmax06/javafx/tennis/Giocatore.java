package sixmax06.javafx.tennis;

public class Giocatore {
    private Contatore[] game;
    private String nome;
    private int gameInCorso, gameVinti;

    public Giocatore(String nome) {
        this.nome = nome;
        game = new Contatore[5];
        gameInCorso = 0;
        gameVinti = 0;
    }



    public String getNome() {
        return nome;
    }
}
