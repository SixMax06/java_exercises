public class Studente {
    private String nome, cognome;
    private float altezza, peso;
    private final static float ALTO = 170.0f;

    public Studente (String nome, String cognome, float altezza, float peso) {
        this.nome = nome;
        this.cognome = cognome;
        this.altezza = altezza;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltezza() {
        return altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String valutaAltezza(){
        if (this.altezza > ALTO) return "alto";
        if (this.altezza < ALTO) return "basso";
        return null;
    }

    public float getBMI(){
        return this.peso / (float)Math.pow(this.altezza, 2);
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\tCognome: " + this.cognome + "\tAltezza: " + this.altezza + "\tPeso: " + this.peso;
    }

}
