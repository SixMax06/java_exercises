package sixmax06.javafx.tennis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class TennisController {
    private Giocatore g1, g2;
    private int gameInCorso = 1;

    @FXML
    private Label lblNomeG1, lblNomeG2;

    @FXML
    private Label lblSet1G1, lblSet1G2;

    @FXML
    private Label lblSet2G1, lblSet2G2;

    @FXML
    private Label lblSet3G1, lblSet3G2;

    @FXML
    private Label lblSet4G1, lblSet4G2;

    @FXML
    private Label lblSet5G1, lblSet5G2;

    @FXML
    private Label[] lblG1, lblG2;

    @FXML
    public void initialize() {
        lblG1 = new Label[]{lblSet1G1, lblSet2G1, lblSet3G1, lblSet4G1, lblSet5G1};
        lblG2 = new Label[]{lblSet1G2, lblSet2G2, lblSet3G2, lblSet4G2, lblSet5G2};
        g1 = new Giocatore("Jannik Sinner"); g2 = new Giocatore("Novak Djokovic");

        lblNomeG1 = new Label(); lblNomeG2 = new Label();
        primaStampa();
    }

    public void primaStampa() {
        lblNomeG1.setText(g1.getNome()); lblNomeG2.setText(g2.getNome());
    }

    public void btnAumentaG1OnClick(ActionEvent event) {
        gameInCorso = g1.incrementa(gameInCorso);
        lblG1[gameInCorso].setText(g1.printGame(gameInCorso));
    }

    public void btnDiminuisciG1OnClick(ActionEvent event) {
        g1.decrementa(gameInCorso - 1);
        lblG1[gameInCorso].setText(g1.printGame(gameInCorso - 1));
    }

    public void btnAumentaG2OnClick(ActionEvent event) {
        gameInCorso = g2.incrementa(gameInCorso - 1);
        lblG2[gameInCorso].setText(g2.printGame(gameInCorso - 1));
    }

    public void btnDiminuisciG2OnClick(ActionEvent event) {
        g2.decrementa(gameInCorso - 1);
        lblG2[gameInCorso].setText(g2.printGame(gameInCorso - 1));
    }

    public void btnResetOnClick(ActionEvent event) {
        g1.resetGiocatore(); g2.resetGiocatore();
    }

}