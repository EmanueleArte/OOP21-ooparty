package game.dice.view;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.util.Duration;
import utils.controller.GenericController;
import utils.view.GenericViewController;

/**
 * Implementation of {@link DiceViewController}.
 */
public class DiceViewControllerImpl implements GenericViewController, DiceViewController {

    /**
     * Duration of jump animation in milliseconds.
     */
    public static final int JUMP_DURATION = 500;
    /**
     * Height of jump in pixels.
     */
    public static final int JUMP_HEIGHT = 170;

    private int result;
    private DiceController controller;

    @FXML
    private Group player;
    @FXML
    private Polygon playerBody;
    @FXML
    private Circle playerHead;
    @FXML
    private Text diceText;
    @FXML
    private Text label;

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof DiceControllerImpl) {
            this.controller = (DiceController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of DiceController");
        }
    }

    /**
     * This method gets called when a key is pressed in this scene.
     * 
     * @param ke the {@link KeyEvent}
     */
    @FXML
    protected final void onKeyPressed(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.SPACE)) {
            this.controller.nextStep();
        }
    }

    /**
     * This method gets called when the mouse clicks on this scene.
     */
    @FXML
    protected final void onClick() {
        this.controller.nextStep();
    }

    @Override
    public final void jumpToDice() {
        TranslateTransition transition = new TranslateTransition();
        transition.setNode(player);
        transition.setDuration(Duration.millis(JUMP_DURATION));
        transition.setByY(-JUMP_HEIGHT);
        transition.setOnFinished(e -> {
            diceText.setText(Integer.toString(this.result));
            transition.setByY(JUMP_HEIGHT);
            transition.setOnFinished(null);
            transition.play();
        });
        transition.play();
    }

    @Override
    public final void initialize(final int result, final Color color, final String text) {
        this.result = result;
        this.playerBody.setFill(color);
        this.playerHead.setFill(color);
        this.label.setText(text);
    }
}
