module sixmax06.javafx.codicefiscale {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens sixmax06.javafx.codicefiscale to javafx.fxml;
    exports sixmax06.javafx.codicefiscale;
}