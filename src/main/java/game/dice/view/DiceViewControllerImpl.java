package game.dice.view;

import java.util.Optional;

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

    /**
     * duration of jump animation in milliseconds.
     */
    public static final int JUMP_DURATION = 500;
    /**
     * height of jump in pixels.
     */
    public static final int JUMP_HEIGHT = 170;

    private DiceController controller;
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
    public final void setController(final GenericController controller) {
        if (controller instanceof DiceControllerImpl) {
            this.controller = (DiceController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceController");
        }
    }

    @FXML
    public final void nextStep() {
        if (this.end) {
            this.controller.returnToGame();
        } else {
            Optional<Integer> roll = this.controller.getLastResult();
            if (roll.isPresent()) {
                this.jumpToDice(roll.get());
            }
            this.end = true;
        }
    }

    public final void jumpToDice(final int roll) {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(player);
        transition.setDuration(Duration.millis(JUMP_DURATION));
        transition.setByY(-JUMP_HEIGHT);
        transition.setOnFinished(e -> {
            diceText.setText(Integer.toString(roll));
            transition.setByY(JUMP_HEIGHT);
            transition.setOnFinished(null);
            transition.play();
        });
        transition.play();
    }

    @FXML
    public final void initialize(final Color color) {
        this.playerBody.setFill(color);
        this.playerHead.setFill(color);
    }
}
