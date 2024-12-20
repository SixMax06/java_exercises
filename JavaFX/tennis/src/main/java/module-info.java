module sixmax06.javafx.tennis {
    requires javafx.controls;
    requires javafx.fxml;


    opens sixmax06.javafx.tennis to javafx.fxml;
    exports sixmax06.javafx.tennis;
}