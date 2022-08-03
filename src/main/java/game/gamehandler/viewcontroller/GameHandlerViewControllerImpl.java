package game.gamehandler.viewcontroller;

import game.gamehandler.controller.GameHandlerController;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.controller.GenericController;
import utils.GenericViewController;

public class GameHandlerViewControllerImpl implements GenericViewController {

    private GameHandlerController controller;

    @FXML
    private Group banner;
    @FXML
    private Text bannerText;
    @FXML
    private Circle player1;
    @FXML
    private Circle player2;
    @FXML
    private Circle player3;
    @FXML
    private Circle player4;

    public void movePlayer(int movement) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(player1);
        transition.setDuration(Duration.millis(1000));
        transition.setByX(player1.getLayoutX() + movement * 10);
        transition.play();
    }

    @Override
    public void setController(final GenericController controller) {
        if (controller instanceof GameHandlerController) {
            this.controller = (GameHandlerController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GameHandlerController");
        }
    }

    @FXML
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.nextStep();
        }
    }

    public void nextStep() {
        switch (this.controller.nextStep()) {
        case 0: {
            this.showBanner("Turn " + this.controller.getTurnNumber());
            break;
        }
        case 1: {
            this.hideBanner();
            break;
        }
        case 2: {
            switch (this.controller.nextPlayerTurnStep()) {
            case 0: {
                this.showBanner(this.controller.getCurrentPlayerName() + "'s turn");
                break;
            }
            case 1: {
                this.hideBanner();
                break;
            }
            case 2: {
                //movePlayer(5);
                break;
            }
            default: {

            }
            }
            break;
        }
        default: {

        }
        }
    }

    private void showBanner(final String text) {
        bannerText.setText(text);
        FadeTransition fade = new FadeTransition(Duration.millis(500), banner);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    private void hideBanner() {
        FadeTransition fade = new FadeTransition(Duration.millis(1000), banner);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }
}
