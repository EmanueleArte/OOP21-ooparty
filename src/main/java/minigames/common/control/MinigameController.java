package minigames.common.control;

import java.util.List;

/**
 * This interface models a minigame controller.
 * 
 */
public interface MinigameController {

    /**
     * This method returns the results of the minigame.
     * 
     * @return the list of players ordered by their score in the minigame (from
     *         higher to lower)
     */
    List<?> getGameResults();

}
