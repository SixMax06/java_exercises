package sixmax06.javafx.codicefiscale;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public DatePicker dtpDataNascita;

    @FXML
    public Button btnCalcolaCodiceFiscale;

    @FXML
    public Label lblCodiceFiscale;

    public void initialize() {
        this.cf = new CodiceFiscale();
        cbbLuogoNascita.getItems().addAll(this.cf.getComuni().keySet());
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
        this.cf.calcolaSiglaComune(cbbLuogoNascita.getValue());
        this.cf.calcolaCodiceFiscale();
        lblCodiceFiscale.setText(cf.getCodiceFiscale());
    }

}