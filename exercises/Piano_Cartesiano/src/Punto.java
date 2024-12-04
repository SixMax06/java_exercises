public class Punto {
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanzaPuntoOrigine(){
        return Math.sqrt(Math.pow(this.x, 2f) + Math.pow(this.y, 2f));
    }

    public double distanzaPuntoPunto(Punto p){
        return Math.sqrt(Math.pow(p.getX() - this.x, 2f) + Math.pow(p.getY() - this.y, 2f));
    }

    public Punto puntoMedio(Punto p){
        double xP, yP;
        xP = (p.getX() + this.x) / 2;
        yP = (p.getY() + this.y) / 2;
        return new Punto(xP, yP);
    }

    public void ruotaPuntoPunto(double angolo, Punto p){
        double raggio = this.distanzaPuntoPunto(p);
        double angoloOrigine = Math.atan2(this.getY() - p.getY(), this.getX() - p.getX());
        this.x = (double)Math.round((raggio * Math.cos(angoloOrigine + Math.toRadians(angolo)) * 1000000)) / 1000000 + p.getX();
        this.y = (double)Math.round((raggio * Math.sin(angoloOrigine + Math.toRadians(angolo)) * 1000000)) / 1000000 + p.getY();
    }

    public void ruotaPuntoOrigine(double angolo){
        ruotaPuntoPunto(angolo, new Punto(0,0));
    }

    @Override
    public String toString() {
        return "Punto{x=" + x + ", y=" + y + "}";
    }

}

