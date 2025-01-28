package sixmax06.javafx.codicefiscale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class CodiceFiscaleController {
    private String codiceFiscale;

    @FXML
    public TextField txtfCognome, txtfNome;

    @FXML
    public RadioButton rdbGenereMaschio, rdbGenereFemmina;

    @FXML
    public ToggleGroup rdbGroupGenere;

    @FXML
    public ChoiceBox<String> chbLuogoNascita;

    @FXML
    public DatePicker dtpDataNascita;

    @FXML
    public Button btnCalcolaCodiceFiscale;

    @FXML
    public Label lblCodiceFiscale;

    public void initialize() {
        TreeMap<String, String> comuni = new TreeMap<>();

        try {
            FileReader fr = new FileReader("lista_comuni.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                comuni.put(split[0], split[1]);
                chbLuogoNascita.getItems().add(split[0]);
            }

            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);

        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(2);
        }
    }


}