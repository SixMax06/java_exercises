public class Rettangolo extends Figura {
    private double base, altezza;

    public Rettangolo(double base, double altezza) {
        super(0, 0, "Bianco");
        this.base = base;
        this.altezza = altezza;
    }

    public Rettangolo(double posX, double posY, String colore, double base, double altezza) {
        super(posX, posY, colore);
        this.base = base;
        this.altezza = altezza;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public double getPerimetro() {
        return (this.base + this.altezza) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + " | base: " + base + " , altezza: " + altezza;
    }
}
