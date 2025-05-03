public class Cerchio extends Figura {
    private double raggio;

    public Cerchio(double raggio) {
        super(0, 0, "Bianco");
        this.raggio = raggio;
    }

    public Cerchio(double posX, double posY, String colore, double raggio) {
        super(posX, posY, colore);
        this.raggio = raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    @Override
    public double getPerimetro() {
        return 2 * Math.PI * this.raggio;
    }

    @Override
    public String toString() {
        return super.toString() + " | raggio: " + raggio;
    }
}
