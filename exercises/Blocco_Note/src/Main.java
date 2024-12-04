public class Main {
    public static void main(String[] args) {
        BloccoNote bloccoNote = new BloccoNote("Scuola");
        bloccoNote.aggiungiNota(new Nota("prova1", 2));
        bloccoNote.aggiungiNota(new Nota("prova2", 3));
        bloccoNote.aggiungiNota(new Nota("prova3", 4));
        System.out.println(bloccoNote);
        System.out.println(bloccoNote.quante());
        System.out.println(bloccoNote.getNotePerImportanza(2));
    }
}
