package sixmax06.javafx.tennis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class TennisController {
    private Giocatore g1, g2;

    @FXML
    private Label[] lblG1, lblG2;

    @FXML
    protected void initialize() {
        lblG1 = new Label[6];
        lblG2 = new Label[6];
        g1 = new Giocatore("Jannik Sinner");
        g2 = new Giocatore("Novak Djokovic");
    }

    public void btnAumentaG1OnClick(ActionEvent event) {

    }

    public void btnDiminuisciG1OnClick(ActionEvent event) {

    }

    public void btnAumentaG2OnClick(ActionEvent event) {

    }

    public void btnDiminuisciG2OnClick(ActionEvent event) {

    }


}