package minigames.common.control;

import java.util.List;

/**
 * This interface models a minigame controller.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MinigameController<S, U> {

    /**
     * This method returns the results of the minigame.
     * 
     * @return the list of players ordered by their score in the minigame (from higher to lower)
     */
    List<U> getGameResults();

}
