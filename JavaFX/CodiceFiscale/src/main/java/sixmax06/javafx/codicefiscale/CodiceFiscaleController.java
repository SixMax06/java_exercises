package sixmax06.javafx.codicefiscale;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

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
    public DatePicker dtpDataNascita;

    @FXML
    public ComboBox<String> cbbLuogoNascita;

    @FXML
    public CheckBox ckbEstero;

    @FXML
    public Button btnCalcolaCodiceFiscale, btnCopiaAppunti;

    @FXML
    public Label lblCodiceFiscale;

    public void initialize() {
        this.cf = new CodiceFiscale();
        cbbLuogoNascita.getItems().addAll(this.cf.getComuni().keySet());

        cbbLuogoNascita.getEditor().setFont(new Font("System", 20));
        dtpDataNascita.getEditor().setFont(new Font("System", 20));
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
            lblCodiceFiscale.setText("Dati inseriti non corretti");
        }
    }

    public void btnCopiaAppuntiOnClick() {
        StringSelection selection = new StringSelection(this.cf.getCodiceFiscale());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }
}