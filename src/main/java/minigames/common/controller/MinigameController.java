package minigames.common.controller;

import java.util.List;

import utils.controller.GenericController;

/**
 * Extension of {@link GenericController}.
 */
public interface MinigameController extends GenericController {

    /**
     * This method returns the results of the minigame.
     * 
     * @return the list of players ordered by their score in the minigame (from
     *         higher to lower)
     */
    List<?> getGameResults();

    /**
     * This method starts the minigame.
     */
    void startGame();

}
