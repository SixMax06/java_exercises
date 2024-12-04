import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gioco {
    private ArrayList<Scheda> schede;

    public Gioco(String file_name) throws IOException, WrongFileFormatException {
        schede = new ArrayList();
        FileReader fr;

        try {
            fr = new FileReader(file_name);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        BufferedReader br = new BufferedReader(fr);

        while (br.readLine() != "" && br.readLine() != null) {
            String s = br.readLine();
            if (s != null && s != "") {
                Scheda scheda = new Scheda(s);
                schede.add(scheda);
            }
        }
    }

    public boolean controllaRisposta(int indexScheda, int input) {
        return (schede.get(indexScheda).getRisposta() == input);
    }

    public void gameLoop() {
        boolean exit = false;
        while (!exit) {
            Scanner inp = new Scanner(System.in);
            int index = (int)(Math.random() * schede.size()) + 1;
            Scheda scheda = schede.get(index);
            System.out.println(scheda);
            int risposta = inp.nextInt();

            if (risposta == 0)
                exit = true;
            else {
                if (controllaRisposta(index, risposta)) {
                    System.out.println("Risposta Corretta\n\n");
                }
                else {
                    System.out.println("Risposta Errata\n\n");
                }
            }
        }
    }
}
