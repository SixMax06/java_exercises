public class Studente {
    private String nome;
    private String cognome;
    private float altezza;
    private float peso;

    public Studente(String nome, String cognome, float altezza, float peso) {
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

    @Override
    public String toString() {
        return "Nome: " + nome + "\tCognome: " + cognome + "\tAltezza: " + altezza + "\tPeso: " + peso;
    }
}
