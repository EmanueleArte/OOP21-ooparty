package minigames.whoriskswins.viewcontroller;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import minigames.common.viewcontroller.MinigameViewControllerAbstr;
import minigames.whoriskswins.controller.WhoRisksWinsController;
import utils.GuiUtils;
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
    private boolean fallingStarted;
    private boolean nextTurn;
    @FXML
    private Rectangle block;

    /**
     * Builds a new {@link WhoRisksWinsViewControllerImpl}.
     */
    public WhoRisksWinsViewControllerImpl() {
        this.fallingStarted = false;
        this.nextTurn = true;
    }

    @FXML
    private void initialize() {
        this.blockCoordinates = new PairImpl<>(this.block.getLayoutX(), this.block.getLayoutY());
        this.playerCoordinates = new PairImpl<>(this.getPlayerAvatar().getLayoutX(),
                this.getPlayerAvatar().getBoundsInParent().getMinY());
    }

    @Override
    public final void setController(final GenericController controller) {
        this.wrwController = (WhoRisksWinsController) controller;
        this.startNextTurn();
    }

    @Override
    public final void showTurnResults(final int score) {
        this.showNotice("Your score is " + score + ". " + Notice.PRESS_ENTER_TO.getNotice() + "continue.");
    }

    @Override
    public final void startNextTurn() {
        if (this.wrwController.nextTurn()) {
            GuiUtils.resetPosition(this.block, this.blockCoordinates.getX(), this.blockCoordinates.getY());
            this.setBlockFallingSpeed();
            this.showNotice(Notice.PRESS_ENTER_TO.getNotice() + "start.");
            this.nextTurn = false;
        }
    }

    @Override
    @FXML
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.gameAction();
        }
    }

    /**
     * This methods performs the possible game actions.
     */
    private void gameAction() {
        if (this.fallingStarted) {
            this.nextTurn = true;
            this.fallingStarted = false;
            this.blockFall.stop();
            this.wrwController.stopBlockFall(this.block.getTranslateY() + this.block.getHeight(),
                    this.playerCoordinates.getY());
        } else {
            if (this.nextTurn) {
                this.startNextTurn();
            } else {
                this.fallingStarted = true;
                this.clearNotice();
                this.blockFall.play();
            }
        }
    }

    /**
     * Setter for the falling animation of the block.
     */
    private void setBlockFallingSpeed() {
        this.blockFall = new TranslateTransition();
        this.blockFall.setNode(this.block);
        this.blockFall.setDuration(Duration.millis(this.wrwController.getFallingSpeed()));
        this.blockFall.setToY(this.playerCoordinates.getY() - this.block.getHeight() + 1);
        this.blockFall.setInterpolator(Interpolator.EASE_IN);
        this.blockFall.setOnFinished(e -> this.gameAction());
    }

}
