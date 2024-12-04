/**
 * Classe Nota : Definisce una nota con un testo e un grado di importanza (da 1 a 5)
 */
public class Nota {

    private String testo;
    private int importanza;

    /**
     * Costruttore : Inizializza una nota dati un testo ed un grado di importanza
     * @param testo (String)
     * @param importanza (int)
     */
    public Nota(String testo, int importanza) {
        this.testo = testo;
        this.importanza = importanza;
    }

    /**
     * Ritorna il testo della nota
     * @return testo (String)
     */
    public String getTesto() {
        return testo;
    }

    /**
     * Ritorna l'importanza della nota
     * @return importanza (int)
     */
    public int getImportanza() {
        return importanza;
    }

    /**
     * Metodo toString per stampare la Nota
     * @return String
     */
    @Override
    public String toString() {
        return "Importanza " + this.importanza + ": " + this.testo;
    }
}
