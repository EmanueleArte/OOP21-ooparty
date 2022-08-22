package game.common.model;

import java.util.List;

import game.player.Player;

/**
 * This interface models the game model.
 */
public interface GameModel {

    /**
     * This method runs the game as long as there are turns to do.
     * 
     * @return true if there is another turn to play
     */
    boolean runGame();

    /**
     * Getter for the list of players.
     * 
     * @return the list of players
     */
    List<Player> getPlayers();

    /**
     * Getter for the current player.
     * 
     * @return the current player if exists
     */
    Player getCurrPlayer();

}
