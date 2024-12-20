package sixmax06.javafx.tennis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TennisController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}