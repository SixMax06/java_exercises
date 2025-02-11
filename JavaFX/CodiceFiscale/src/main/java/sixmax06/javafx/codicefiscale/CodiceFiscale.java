package sixmax06.javafx.codicefiscale;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class CodiceFiscale {
    private String cognome, nome, dataNascita, siglaComune, carattereControllo;
    private String codiceFiscale;
    private final ArrayList<Character> vocali;
    private final char[] lettereMesi;
    private final TreeMap<Character, Integer> controlloPari, controlloDispari;
    private final TreeMap<String, String> comuni, statiEsteri;

    public CodiceFiscale() {
        this.cognome = "";
        this.nome = "";
        this.dataNascita = "";
        this.siglaComune = "";
        this.carattereControllo = "";
        this.codiceFiscale = "";

        this.lettereMesi = new char[]{'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'};
        this.vocali = new ArrayList<>(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));

        this.comuni = new TreeMap<>();
        this.statiEsteri = new TreeMap<>();
        this.controlloPari = new TreeMap<>();
        this.controlloDispari = new TreeMap<>();

        try {
            FileReader fr = new FileReader("lista_comuni.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                comuni.put(split[0], split[1]);
            }

            fr = new FileReader("lista_statiEsteri.csv");
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                statiEsteri.put(split[0], split[1]);
            }

            fr = new FileReader("caratteri_dispari.csv");
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                controlloDispari.put(split[0].charAt(0), Integer.parseInt(split[1]));
            }

            fr = new FileReader("caratteri_pari.csv");
            br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                controlloPari.put(split[0].charAt(0), Integer.parseInt(split[1]));
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            System.exit(10001);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(10002);
        }
    }

    public void calcolaCognome(String cognome) throws Exception {
        if (cognome.isEmpty()) throw new Exception();

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

    public void calcolaNome(String nome) throws Exception {
        if (nome.isEmpty()) throw new Exception();

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

    public void calcolaSiglaComunePaese(String paese, boolean estero) throws Exception {
        if (estero) {
            if (statiEsteri.containsKey(paese)) this.siglaComune = statiEsteri.get(paese);
            else throw new Exception();
        } else if (comuni.containsKey(paese)) this.siglaComune = comuni.get(paese);
        else throw new Exception();
    }

    private void calcolaCarattereControllo() {
        int somma = 0;
        for (int i = 0; i < this.codiceFiscale.length(); i++) {
            if (i % 2 == 1) somma += this.controlloPari.get(this.codiceFiscale.charAt(i));
            else somma += this.controlloDispari.get(this.codiceFiscale.charAt(i));
        }
        somma %= 26;
        this.carattereControllo = Character.toString('A' + somma);
    }

    public void calcolaCodiceFiscale() {
        this.codiceFiscale = this.cognome + this.nome + this.dataNascita + this.siglaComune;
        calcolaCarattereControllo();
        this.codiceFiscale += this.carattereControllo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public TreeMap<String, String> getComuni() {
        return this.comuni;
    }

    public TreeMap<String, String> getStatiEsteri() {
        return this.statiEsteri;
    }
}
