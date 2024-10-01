public class Studente {
    private String nome, cognome;
    private float altezza, peso;

    public String valutaAltezza() {
        if (this.altezza < 150) return "basso";
        if (this.altezza >= 150 && this.altezza < 170) return "medio";
        if (this.altezza >= 170) return "alto";
        return null;
    }

    public float getBMI() {
        return this.peso / (float) Math.pow(this.altezza / 100.0f, 2);
    }
}
