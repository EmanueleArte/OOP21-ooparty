package minigames.whoriskswins.viewcontroller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import minigames.common.viewcontroller.MinigameViewControllerAbstr;
import minigames.whoriskswins.controller.WhoRisksWinsController;
import utils.controller.GenericController;
import utils.enums.Notice;

/**
 * Extension of {@link MinigameViewControllerAbstr} and implementation of
 * {@link WhoRisksWinsViewController}.
 */
public class WhoRisksWinsViewControllerImpl extends MinigameViewControllerAbstr implements WhoRisksWinsViewController {

    private WhoRisksWinsController wrwController;

    /**
     * Builds a new {@link WhoRisksWinsViewControllerImpl}.
     */
    public WhoRisksWinsViewControllerImpl() {
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
            this.showNotice(Notice.PRESS_ENTER_TO + "start.");
        }
    }

    @Override
    protected final void onEnter(final KeyEvent ke) {
        if (ke.getCode().equals(KeyCode.ENTER)) {
            this.wrwController.stopBlockFall(0, 0);
        }
    }

}
