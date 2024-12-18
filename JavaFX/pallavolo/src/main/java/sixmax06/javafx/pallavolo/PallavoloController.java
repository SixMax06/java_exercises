package sixmax06.javafx.pallavolo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;


public class PallavoloController {
    private Contatore casa, trasferta;
    private final int MAX = 25;

    @FXML
    private Label lblCasa, lblTrasferta;

    @FXML
    public void initialize() {
        this.casa = new Contatore(MAX);
        this.trasferta = new Contatore(MAX);
        this.lblCasa.setText(casa.toString());
        this.lblTrasferta.setText(trasferta.toString());
    }

    private void checkVantaggio() {
        if (this.casa.getPunteggio() == this.casa.getMAX() - 1 && this.trasferta.getPunteggio() == this.trasferta.getMAX() - 1) {
            this.casa.setMAX(this.casa.getMAX() + 1); this.trasferta.setMAX(this.trasferta.getMAX() + 1);
        }
    }

    public void btnCasaOnClick(ActionEvent actionEvent) {
        this.casa.incrementa();
        if (this.casa.isVittoria()) {
            this.trasferta.resetPunteggio();
            this.casa.resetVittoria();
            this.casa.setMAX(this.MAX); this.trasferta.setMAX(this.MAX);
            this.lblTrasferta.setText(trasferta.toString());
        }
        this.checkVantaggio();
        this.lblCasa.setText(casa.toString());
    }

    public void btnTrasfertaOnClick(ActionEvent actionEvent) {
        this.trasferta.incrementa();
        if (this.trasferta.isVittoria()) {
            this.casa.resetPunteggio();
            this.trasferta.resetVittoria();
            this.casa.setMAX(this.MAX); this.trasferta.setMAX(this.MAX);
            this.lblCasa.setText(casa.toString());
        }
        this.checkVantaggio();
        this.lblTrasferta.setText(trasferta.toString());
    }

    public void btnResetOnClick(ActionEvent actionEvent) {
        this.casa.reset(); this.trasferta.reset();
        this.lblCasa.setText(casa.toString()); this.lblTrasferta.setText(trasferta.toString());
    }
}