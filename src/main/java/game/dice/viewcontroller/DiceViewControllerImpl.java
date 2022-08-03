package game.dice.viewcontroller;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.GenericViewController;
import utils.controller.GenericController;

public class DiceViewControllerImpl implements GenericViewController {
    private DiceController<?> controller;
    private boolean end = false;

    @FXML
    private Group player;
    @FXML
    private Polygon playerBody;
    @FXML
    private Circle playerHead;
    @FXML
    private Text diceText;

    @Override
    public void setController(final GenericController controller) {
        if (controller instanceof DiceControllerImpl) {
            this.controller = (DiceController<?>) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceController");
        }
    }

    @FXML
    public void nextStep() {
        if (this.end) {
            this.controller.returnToGame();
        } else {
            this.controller.rollDice();
            this.jumpToDice(this.controller.getResult());
            this.end = true;
        }
    }

    public void jumpToDice(final int roll) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(player);
        transition.setDuration(Duration.millis(500));
        transition.setByY(-170);
        transition.setOnFinished(e -> {
            diceText.setText(Integer.toString(roll));
            transition.setByY(170);
            transition.setOnFinished(null);
            transition.play();
        });
        transition.play();
    }

    public void initialize(final Color color) {
        this.playerBody.setFill(color);
        this.playerHead.setFill(color);
    }
}
