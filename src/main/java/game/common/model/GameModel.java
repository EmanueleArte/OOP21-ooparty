package game.common.model;

import java.util.List;
import java.util.Map;

import utils.graphics.stagemanager.StageManager;

/**
 * This interface models the game model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the player
 */
public interface GameModel<S, U> {

    /**
     * This method runs the minigame.
     * 
     * @return true if there is another player that has to play
     */
    boolean runGame();

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

    /**
     * Getter for the current player.
     * 
     * @return the current player
     */
    U getCurrPlayer();

    /**
     * Getter for playersClassification.
     * 
     * @return a map with players as keys and their score as values
     */
    Map<U, Integer> getPlayersClassification();

    /**
     * This method sets the map of players associated to their scores.
     * 
     * @param playersClassification a map with players as keys and their score as
     *                              values
     */
    void setPlayersClassification(Map<U, Integer> playersClassification);

}

