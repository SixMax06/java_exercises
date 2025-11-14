public class Condensatore extends ComponenteElettrico {
    public Condensatore(String nome, int valore) {
        super(nome, valore, "Farad");
    }

    @Override
    public ComplexNumber getImpedenza() {
        return new ComplexNumber(0, (double) 1 / valore);
    }
}
