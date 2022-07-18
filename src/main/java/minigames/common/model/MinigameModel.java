package minigames.common.model;

import java.util.List;
import java.util.ListIterator;

import utils.graphics.StageManager;

/**
 * This interface models a minigame model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MinigameModel<S, U> {

    /**
     * This method runs the minigame.
     */
    void runGame();

    /**
     * This method returns the results of the minigame that are necessary for points
     * assignment, etc...
     * 
     * @return a list of players ordered by their classification in the minigame
     *         with no draws
     */
    List<U> gameResults();

    /**
     * This method associates a player to his score.
     * 
     * @param player the current {@link game.player.Player}
     * @param score  the score of the player at the minigame
     */
    void scoreMapper(U player, Integer score);

    /**
     * Getter for the {@link StageManager}.
     * 
     * @return the stage manager
     */
    StageManager<S> getStageManager();

    /**
     * Getter for the list of {@link game.player.Player}.
     * 
     * @return the list of players
     */
    List<U> getPlayers();

}
