package minigames.common.model;

import java.util.List;
import java.util.Map;

import game.common.model.GameModel;

/**
 * This interface models a minigame model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public interface MinigameModel<S, U> extends GameModel<S, U> {

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
     * Getter for the score.
     * 
     * @return the score of a player
     */
    int getScore();

    /**
     * Getter for playersClassification.
     * 
     * @return a map with players as keys and their score as values
     */
    Map<U, Integer> getPlayersClassification();

}
