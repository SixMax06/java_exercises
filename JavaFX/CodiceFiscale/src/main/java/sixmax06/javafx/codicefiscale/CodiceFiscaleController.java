package sixmax06.javafx.codicefiscale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class CodiceFiscaleController {
    private CodiceFiscale cf;
    private TreeMap<String, String> comuni;

    @FXML
    public TextField txtfCognome, txtfNome;

    @FXML
    public RadioButton rdbGenereMaschio, rdbGenereFemmina;

    @FXML
    public ToggleGroup rdbGroupGenere;

    @FXML
    public ComboBox<String> cbbLuogoNascita;

    @FXML
    public DatePicker dtpDataNascita;

    @FXML
    public Button btnCalcolaCodiceFiscale;

    @FXML
    public Label lblCodiceFiscale;

    public void initialize() {
        this.comuni = new TreeMap<>();

        try {
            FileReader fr = new FileReader("lista_comuni.csv");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                comuni.put(split[0], split[1]);
            }

            cbbLuogoNascita.getItems().addAll(comuni.keySet());

            br.close(); fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(10001);

        } catch (IOException e) {
            System.out.println("Error reading file");
            System.exit(10002);
        }

        this.cf = new CodiceFiscale();
    }

    public void btnCalcolaCodiceFiscaleOnClick(ActionEvent actionEvent) {
        String[] dn = this.dtpDataNascita.getValue().toString().split("-");
        int[] dataNascita = new int[]{Integer.parseInt(dn[0]), Integer.parseInt(dn[1]), Integer.parseInt(dn[2])};
        boolean genere;

        if (rdbGenereMaschio.isSelected()) genere = false;
        else genere = rdbGenereFemmina.isSelected();

        this.cf.calcolaCognome(txtfCognome.getText());
        this.cf.calcolaNome(txtfNome.getText());
        this.cf.calcolaDataNascita(dataNascita[2], dataNascita[1], dataNascita[0], genere);
        this.cf.calcolaSiglaComune(comuni, cbbLuogoNascita.getValue());
        this.cf.calcolaCodiceFiscale();
        lblCodiceFiscale.setText(cf.getCodiceFiscale());
    }

}