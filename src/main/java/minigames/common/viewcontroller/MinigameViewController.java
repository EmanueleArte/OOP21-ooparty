package minigames.common.viewcontroller;

import utils.GenericViewController;

/**
 * This interface models a minigame view controller.
 */
public interface MinigameViewController extends GenericViewController {

    /**
     * This method starts the minigame next turn.
     */
    void startNextTurn();

}
