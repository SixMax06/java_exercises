package sixmax06.javafx.contatore;

public class Contatore {
    private int count;
    private final int MAX;

    public Contatore(int m) {
        this.count = 0;
        this.MAX = m;
    }

    public int getCount() {
        return count;
    }

    public void incrementa() {
        this.count++;
        this.count %= MAX;
    }

    public void resetta() {
        this.count = 0;
    }
}
