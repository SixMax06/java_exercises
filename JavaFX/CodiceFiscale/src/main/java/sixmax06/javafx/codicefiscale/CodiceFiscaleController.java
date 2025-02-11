package sixmax06.javafx.codicefiscale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class CodiceFiscaleController {
    private CodiceFiscale cf;

    @FXML
    public TextField txtfCognome, txtfNome;

    @FXML
    public RadioButton rdbGenereMaschio, rdbGenereFemmina;

    @FXML
    public ToggleGroup rdbGroupGenere;

    @FXML
    public ComboBox<String> cbbLuogoNascita;

    @FXML
    public CheckBox ckbEstero;

    @FXML
    public DatePicker dtpDataNascita;

    @FXML
    public Button btnCalcolaCodiceFiscale;

    @FXML
    public Label lblCodiceFiscale;

    public void initialize() {
        this.cf = new CodiceFiscale();
        cbbLuogoNascita.getItems().addAll(this.cf.getComuni().keySet());
    }

    public void ckbEsteroOnAction() {
        cbbLuogoNascita.getItems().clear();

        if (ckbEstero.isSelected()) cbbLuogoNascita.getItems().addAll(this.cf.getStatiEsteri().keySet());
        else cbbLuogoNascita.getItems().addAll(this.cf.getComuni().keySet());
    }

    public void btnCalcolaCodiceFiscaleOnClick() {
        try {
            String[] dn = this.dtpDataNascita.getValue().toString().split("-");
            int[] dataNascita = new int[]{Integer.parseInt(dn[0]), Integer.parseInt(dn[1]), Integer.parseInt(dn[2])};
            boolean genere = rdbGenereFemmina.isSelected();

            this.cf.calcolaCognome(txtfCognome.getText());
            this.cf.calcolaNome(txtfNome.getText());
            this.cf.calcolaDataNascita(dataNascita[2], dataNascita[1], dataNascita[0], genere);
            this.cf.calcolaSiglaComunePaese(cbbLuogoNascita.getValue().toUpperCase(), ckbEstero.isSelected());
            this.cf.calcolaCodiceFiscale();
            lblCodiceFiscale.setText(cf.getCodiceFiscale());

        } catch (Exception e) {
            lblCodiceFiscale.setText("Errore. Controlla che i dati siano corretti");
        }
    }

    public void btnCopiaAppuntiOnClick() {
        StringSelection selection = new StringSelection(this.cf.getCodiceFiscale());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}