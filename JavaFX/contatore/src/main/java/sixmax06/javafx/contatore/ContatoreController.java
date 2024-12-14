package sixmax06.javafx.contatore;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ContatoreController {
    @FXML
    private Label welcomeText;
    private Contatore contatore;

    @FXML
    protected void initialize() {
        contatore = new Contatore(10);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(String.valueOf(contatore.getCount()));
        contatore.incrementa();
    }
}