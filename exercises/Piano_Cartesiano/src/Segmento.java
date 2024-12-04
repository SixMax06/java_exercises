public class Segmento {
    private Punto p1, p2;

    public Segmento(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void traslaSegmento(double x, double y) {
        p1.setX(p1.getX() + x); p1.setY(p1.getY() + y);
        p2.setX(p2.getX() + x); p2.setY(p2.getY() + y);
    }

    public boolean checkIntersezione(Segmento seg) {

        int o1 = orientamentoPunti(p1, p2, seg.p1);
        int o2 = orientamentoPunti(p1, p2, seg.p2);
        int o3 = orientamentoPunti(seg.p1, seg.p2, p1);
        int o4 = orientamentoPunti(seg.p1, seg.p2, p2);

        return (o1 != o2 && o3 != o4);
    }

    private int orientamentoPunti(Punto p1, Punto p2, Punto r) {
        double val = (p2.getY() - p1.getY()) * (r.getX() - p2.getX()) -
                (p2.getX() - p1.getX()) * (r.getY() - p2.getY());

        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    public void ruotaSegmentoOrigine(double angolo) {
        p1.ruotaPuntoOrigine(angolo); p2.ruotaPuntoOrigine(angolo);
    }

    public void ruotaSegmentoPunto(double angolo, Punto punto) {
        p1.ruotaPuntoPunto(angolo, punto); p2.ruotaPuntoPunto(angolo, punto);
    }

    @Override
    public String toString() {
        return "Segmento [ p1= " + p1 + ", p2= " + p2 + " ]";
    }
}
