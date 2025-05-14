public class Resistore extends ComponenteElettrico{
    public Resistore(String nome, int valore) {
        super(nome, valore, "Ohm");
    }

    @Override
    public ComplexNumber getImpedenza() {
        return new ComplexNumber(valore, 0);
    }
}
