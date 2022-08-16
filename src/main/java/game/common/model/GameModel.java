package game.common.model;

import java.util.List;

import game.player.Player;
import utils.graphics.controller.StageManager;

/**
 * This interface models the game model.
 * 
 * @param <S> the scenes of the stage
 */
public interface GameModel<S> {

    /**
     * This method runs the game as long as there are turns to do.
     * 
     * @return true if there is another turn to play
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
    List<Player> getPlayers();

    /**
     * Getter for the current player.
     * 
     * @return the current player
     */
    Player getCurrPlayer();

}
