package sixmax06.javafx.pallavolo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class PallavoloController {
    private Contatore casa, trasferta;

    @FXML
    private Label lblCasa, lblTrasferta;

    @FXML
    public void initialize() {
        this.casa = new Contatore(25);
        this.trasferta = new Contatore(25);
        this.lblCasa.setText(casa.toString());
        this.lblTrasferta.setText(trasferta.toString());
    }

    public void btnCasaOnClick(ActionEvent actionEvent) {
        this.casa.incrementa();
        this.lblCasa.setText(casa.toString());
    }

    public void btnTrasfertaOnClick(ActionEvent actionEvent) {
        this.trasferta.incrementa();
        this.lblTrasferta.setText(trasferta.toString());
    }
}