public abstract class Figura {
    protected double posX, posY;
    protected String colore;

    public Figura(double posX, double posY, String colore) {
        this.posX = posX;
        this.posY = posY;
        this.colore = colore;
    }

    public void sposta(double dx, double dy) {
        this.posX += dx;
        this.posY += dy;
    }

    public abstract double getPerimetro();

    @Override
    public String toString() {
        return "posX: " + posX + ", posY: " + posY + ", colore: " + colore;
    }
}
