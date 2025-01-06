package sixmax06.javafx.tennis;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class TennisController {
    private Giocatore g1, g2;
    private int gameInCorso = 0;
    private boolean vittoria = false;

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
    private Label lblVincitore;

    private Label[] lblG1, lblG2;

    @FXML
    public void initialize() {
        lblG1 = new Label[]{lblSet1G1, lblSet2G1, lblSet3G1, lblSet4G1, lblSet5G1};
        lblG2 = new Label[]{lblSet1G2, lblSet2G2, lblSet3G2, lblSet4G2, lblSet5G2};

        String nomeG1 = "Jannik Sinner";
        String nomeG2 = "Novak Djokovic";

        g1 = new Giocatore(nomeG1);
        g2 = new Giocatore(nomeG2);

        lblNomeG1.setText(nomeG1);
        lblNomeG2.setText(nomeG2);

        stampaTabellone();
    }

    public void attivaVantaggio(int index) {
        g1.attivaVantaggio(index);
        g2.attivaVantaggio(index);
    }

    public void resetVantaggio(int index) {
        g1.resetVantaggio(index);
        g2.resetVantaggio(index);
    }

    public void stampaTabellone() {
        lblG1[gameInCorso].setText(g1.printGame(gameInCorso));
        lblG2[gameInCorso].setText(g2.printGame(gameInCorso));
    }

    public void resetTabellone() {
        lblG1[0].setText(g1.printGame(0));
        lblG2[0].setText(g2.printGame(0));
        for (int i = 1; i < 5; i++) {
            lblG1[i].setText("");
            lblG2[i].setText("");
        }
    }

    public void checkVantaggio() {
        if (g1.getPunteggio(gameInCorso) >= 3 && g2.getPunteggio(gameInCorso) >= 3) {
            if (g1.getPunteggio(gameInCorso) == g2.getPunteggio(gameInCorso)) {
                attivaVantaggio(gameInCorso);
            }
        } else resetVantaggio(gameInCorso);

        if (g1.getPunteggio(gameInCorso) == 4 && g2.getPunteggio(gameInCorso) == 4) {
            g1.decrementa(gameInCorso);
            g2.decrementa(gameInCorso);
        }
    }

    public void btnAumentaG1OnClick(ActionEvent event) {
        if (!vittoria) {
            try {
                g1.incrementa(gameInCorso);
                checkVantaggio();
            } catch (VittoriaSet e) {
                g2.resetPunteggio(gameInCorso);
                resetVantaggio(gameInCorso);
            } catch (VittoriaGame e) {
                g2.resetPunteggio(gameInCorso);
                stampaTabellone();
                gameInCorso++;
            } catch (Vittoria e) {
                vittoria = true;
                lblVincitore.setText(g1.getNome() + " vince la partita!");
            }
        }

        stampaTabellone();
    }

    public void btnDiminuisciG1OnClick(ActionEvent event) {
        if (!vittoria) g1.decrementa(gameInCorso);
        stampaTabellone();
    }

    public void btnAumentaG2OnClick(ActionEvent event) {
        if (!vittoria) {
            try {
                g2.incrementa(gameInCorso);
                checkVantaggio();
            } catch (VittoriaSet e) {
                g1.resetPunteggio(gameInCorso);
                resetVantaggio(gameInCorso);
            } catch (VittoriaGame e) {
                g1.resetPunteggio(gameInCorso);
                stampaTabellone();
                gameInCorso++;
            } catch (Vittoria e) {
                vittoria = true;
                lblVincitore.setText(g2.getNome() + " vince la partita!");
            }
        }

        stampaTabellone();
    }

    public void btnDiminuisciG2OnClick(ActionEvent event) {
        if (!vittoria) g2.decrementa(gameInCorso);
        stampaTabellone();
    }

    public void btnResetOnClick(ActionEvent event) {
        g1.resetGiocatore();
        g2.resetGiocatore();
        gameInCorso = 0;
        vittoria = false;
        lblVincitore.setText("");
        resetTabellone();
    }
}