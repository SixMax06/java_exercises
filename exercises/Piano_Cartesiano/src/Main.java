public class Main{
    public static void main(String[] args){
        Punto p = new Punto(10,10);
        System.out.println(p);
        p.ruotaPuntoPunto(100, new Punto(10,10));
        System.out.println(p);
        System.out.println(Math.atan2(10,10));

    }
}