import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Gioco game = new Gioco("schede.txt");
        game.gameLoop();
        System.exit(0);
    }
}
