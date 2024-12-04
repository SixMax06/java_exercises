import java.util.ArrayList;

/**
 * Classe BloccoNote : Definisce una lista di note (Nota)
 */
public class BloccoNote {
    private ArrayList<Nota> listaNote;
    private String nome;

    /**
     * Costruttore : Inizializza un BloccoNote vuoto con un nome passato come parametro
     * @param newNome
     */
    public BloccoNote(String newNome) {
        this.nome = newNome;
        this.listaNote = new ArrayList<>();
    }

    /**
     * Costruttore di copia : Inizializza un BloccoNote uguale ad un altro passato come parametro
     * @param newBloccoNote
     */
    public BloccoNote(BloccoNote newBloccoNote) {
        this.nome = newBloccoNote.nome;
        this.listaNote = newBloccoNote.listaNote;
    }

    /**
     * Aggiunge una nota (passata come parametro) al blocco note
     * @param newNota
     */
    public void aggiungiNota(Nota newNota) {
        this.listaNote.add(newNota);
    }

    /**
     * Ritorna il numero di note del blocco note
     * @return listaNote.size()
     */
    public int quante() {
        return this.listaNote.size();
    }

    /**
     * Ritorna un array di note (Nota) con la stessa importanza (passata come parametro) |
     * Ritorna "null" se imp minore di 1 o maggiore di 5 oppure se listaNoteImp.isEmpty() == True
     * @param imp
     * @return listaNoteImp
     */
    public ArrayList<Nota> getNotePerImportanza(int imp) {
        if (imp < 1 || imp > 5) return null;
        ArrayList<Nota> listaNoteImp = new ArrayList<>();
        for (Nota nota : this.listaNote)
            if(nota.getImportanza() == imp)
                listaNoteImp.add(nota);

        if (listaNoteImp.isEmpty()) return null;
        return listaNoteImp;
    }

    /**
     * Metodo toString per stampare un BloccoNote
     * @return String
     */
    @Override
    public String toString() {
        String s = "Blocco Note : " + this.nome + "\nElenco Note: \n";
        for (Nota nota : this.listaNote)
            s += "- " + nota + "\n";
        return s;
    }
}
