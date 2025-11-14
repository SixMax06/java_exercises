public abstract class ComponenteElettrico {
    protected String nome;
    protected int valore;
    protected String unita;

    protected ComponenteElettrico(String nome, int valore, String unita) {
        this.nome = nome;
        this.valore = valore;
        this.unita = unita;
    }

    public abstract ComplexNumber getImpedenza();

    @Override
    public String toString() {
        return nome + ": " + valore + " " + unita;
    }
}