module sixmax06.javafx.prova_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens sixmax06.javafx.prova_javafx to javafx.fxml;
    exports sixmax06.javafx.prova_javafx;
}