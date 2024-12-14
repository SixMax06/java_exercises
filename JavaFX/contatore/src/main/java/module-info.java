module sixmax06.javafx.contatore {
    requires javafx.controls;
    requires javafx.fxml;


    opens sixmax06.javafx.contatore to javafx.fxml;
    exports sixmax06.javafx.contatore;
}