package game.common.model;

import java.util.List;

import utils.graphics.controller.StageManager;

/**
 * This interface models the game model.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public interface GameModel<S, U> {

    /**
     * This method runs the game.
     * 
     * @return true if there is another player that has to play
     */
    boolean runGame();

    /**
     * Getter for the {@link StageManager}.
     * 
     * @return the stage manager instance else null
     */
    StageManager<S> getStageManager();

    /**
     * Getter for the list of players.
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

}

