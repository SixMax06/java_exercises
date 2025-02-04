package sixmax06.javafx.codicefiscale;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class CodiceFiscale {
    private String cognome, nome, dataNascita, siglaComune, carattereControllo;
    private String codiceFiscale;
    private final ArrayList<Character> vocali = new ArrayList<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
    private final char[] lettereMesi = {'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'};

    public CodiceFiscale() {
        cognome = "";
        nome = "";
        dataNascita = "";
        siglaComune = "";
        carattereControllo = "";
        codiceFiscale = "";
    }

    public void calcolaCognome(String cognome) {
        this.cognome = "";

        int contaConsonanti = 0;
        for (int i = 0; i < cognome.length(); i++) {
            char c = cognome.charAt(i);
            if (!vocali.contains(c)) {
                contaConsonanti++;
                this.cognome += c;
            }
            if (contaConsonanti == 3) break;
        }

        if (contaConsonanti < 3) {
            for (int i = 0; i < cognome.length(); i++) {
                char c = cognome.charAt(i);
                if (vocali.contains(c)) {
                    this.cognome += c;
                    contaConsonanti++;
                }
                if (contaConsonanti == 3) break;
            }
        }

        if (contaConsonanti == 2) this.cognome += "X";
        if (contaConsonanti == 1) this.cognome += "XX";

        this.cognome = this.cognome.toUpperCase();
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
            if (contaConsonanti == 4) break;
        }

        if (contaConsonanti < 3) {
            contaConsonanti = 0;
            this.nome = "";
            for (int i = 0; i < nome.length(); i++) {
                char c = nome.charAt(i);
                if (!vocali.contains(c)) {
                    contaConsonanti++;
                    this.nome += c;
                }
                if (contaConsonanti == 3) break;
            }
        }

        if (contaConsonanti < 3) {
            for (int i = 0; i < nome.length(); i++) {
                char c = nome.charAt(i);
                if (vocali.contains(c)) {
                    this.nome += c;
                    contaConsonanti++;
                }
                if (contaConsonanti == 3) break;
            }
        }

        if (contaConsonanti == 2) this.nome += "X";
        if (contaConsonanti == 1) this.nome += "XX";

        this.nome = this.nome.toUpperCase();
    }

    public void calcolaDataNascita(int giorno, int mese, int anno, boolean genere) {
        String siglaAnno = String.valueOf(anno).substring(2, 4);

        char siglaMese = lettereMesi[mese - 1];

        String siglaGiorno;
        if (genere) siglaGiorno = String.valueOf(giorno + 40);
        else if (giorno >= 10) siglaGiorno = String.valueOf(giorno);
        else siglaGiorno = "0" + giorno;

        this.dataNascita = siglaAnno + siglaMese + siglaGiorno;
    }

    public void calcolaSiglaComune(TreeMap<String, String> comuni, String comune) {
        if (comuni.containsKey(comune)) this.siglaComune = comuni.get(comune);
    }

    public void calcolaCarattereControllo() {
    }

    public void calcolaCodiceFiscale() {
        this.codiceFiscale = this.cognome + this.nome + this.dataNascita + this.siglaComune + carattereControllo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

}
