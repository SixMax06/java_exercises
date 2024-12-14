module sixmax06.javafx.pallavolo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens sixmax06.javafx.pallavolo to javafx.fxml;
    exports sixmax06.javafx.pallavolo;
}