package minigames.whoriskswins.viewcontroller;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import minigames.common.viewcontroller.MinigameViewControllerAbstr;
import minigames.whoriskswins.controller.WhoRisksWinsController;
import utils.Pair;
import utils.PairImpl;
import utils.controller.GenericController;
import utils.enums.Notice;

/**
 * Extension of {@link MinigameViewControllerAbstr} and implementation of
 * {@link WhoRisksWinsViewController}.
 */
public class WhoRisksWinsViewControllerImpl extends MinigameViewControllerAbstr implements WhoRisksWinsViewController {

    private WhoRisksWinsController wrwController;
    private Pair<Double, Double> blockCoordinates;
    private Pair<Double, Double> playerCoordinates;
    private TranslateTransition blockFall;
    private boolean started;
    @FXML
    private Rectangle block;

    /**
     * Builds a new {@link WhoRisksWinsViewControllerImpl}.
     */
    public WhoRisksWinsViewControllerImpl() {
        this.started = false;
    }

    @FXML
    private void initialize() {
        this.blockCoordinates = new PairImpl<>(this.block.getX(), this.block.getY());
        final double radius = ((Circle) this.getPlayerAvatar().getChildren().get(1)).getRadius();
        this.playerCoordinates = new PairImpl<>(((Circle) this.getPlayerAvatar().getChildren().get(0)).getCenterX(),
                ((Circle) this.getPlayerAvatar().getChildren().get(1)).getCenterY() + radius);
    }

    @Override
    public final void setController(final GenericController controller) {
        this.wrwController = (WhoRisksWinsController) controller;
    }

    @Override
    public final void showTurnResults(final int score) {
        this.showNotice("Your score is " + score + "\n" + Notice.PRESS_ENTER_TO.getNotice() + "continue.");

    }

    @Override
    public final void startNextTurn() {
        if (this.wrwController.nextTurn()) {
            this.resetBlock();
            this.setBlockFallingSpeed();
            this.showNotice(Notice.PRESS_ENTER_TO + "start.");
        }
    }

    @Override
    @FXML
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            if (this.started) {
                this.started = false;
                this.blockFall.stop();
                this.wrwController.stopBlockFall(this.blockCoordinates.getY(), this.playerCoordinates.getY());
            } else {
                this.started = true;
                this.blockFall.play();
            }
        }
    }

    /**
     * This method resets the block position.
     */
    private void resetBlock() {
        this.block.yProperty().set(this.blockCoordinates.getY());
    }

    /**
     * Setter for the falling animation of the block.
     */
    private void setBlockFallingSpeed() {
        this.blockFall = new TranslateTransition();
        this.blockFall.setNode(this.block);
        this.blockFall.setDuration(Duration.millis(this.wrwController.getFallingSpeed()));
        this.blockFall.setByY(this.playerCoordinates.getY());
        this.blockFall.setInterpolator(Interpolator.EASE_IN);
    }

}
