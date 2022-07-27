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

    /**
     * This method sets the player label with the current player nickname and color.
     * 
     * @param <U> the player type
     * @param player the current player
     */
    <U> void setPlayerLabelText(U player);

}
