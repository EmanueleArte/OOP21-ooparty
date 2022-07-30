package minigames.whoriskswins.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    @FXML
    private Rectangle block;

    /**
     * Builds a new {@link WhoRisksWinsViewControllerImpl}.
     */
    public WhoRisksWinsViewControllerImpl() {
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
            this.wrwController.stopBlockFall(this.blockCoordinates.getY(), this.playerCoordinates.getY());
        }
    }

    /**
     * This method resets the block position.
     */
    private void resetBlock() {
        this.block.yProperty().set(this.blockCoordinates.getY());
    }

    /**
     * Setter for the falling speed of the block.
     */
    private void setBlockFallingSpeed() {
        this.wrwController.getFallingSpeed();
    }

}
