public class Induttore extends ComponenteElettrico{
    public Induttore(String nome, int valore){
        super(nome, valore, "Henry");
    }

    @Override
    public ComplexNumber getImpedenza() {
        return new ComplexNumber(0, valore);
    }
}
