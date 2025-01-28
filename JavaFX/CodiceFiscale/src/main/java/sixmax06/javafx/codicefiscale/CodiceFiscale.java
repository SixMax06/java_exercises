package sixmax06.javafx.codicefiscale;

import java.util.ArrayList;
import java.util.Arrays;

public class CodiceFiscale {
    private String cognome, nome, dataNascita, siglaComune, carattereControllo;
    private String codiceFiscale;
    private final ArrayList<Character> vocali = new ArrayList<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

    public CodiceFiscale() {
        cognome = "";
        nome = "";
        dataNascita = "";
        siglaComune = "";
        carattereControllo = "";
        codiceFiscale = "";
    }

    public CodiceFiscale(String cognome, String nome, int giornoNascita, int meseNascita, int annoNascita, String siglaComune) {
        calcolaCognome(cognome);
        calcolaNome(nome);
    }

    public void calcolaCognome(String cognome) {
        this.cognome = "";
        for (int i = 0; i < cognome.length(); i++) {
            char c = cognome.charAt(i);
            if (vocali.contains(c)) this.cognome += c;
        }
    }

    public void calcolaNome(String nome) {
        this.nome = "";
        int contaConsonanti = 0;
        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);
            if (!vocali.contains(c)) {
                contaConsonanti++;
                if (contaConsonanti != 2) this.nome += c;
            }
        }
    }

}
