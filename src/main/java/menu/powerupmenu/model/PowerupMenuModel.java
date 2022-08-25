package menu.powerupmenu.model;

import java.util.List;
import java.util.Optional;

import game.player.Player;

/**
 * Interface for the model of the power-up menu.
 */
public interface PowerupMenuModel {

    /**
     * Getter for the list of the players in the game.
     * 
     * @return a {@link List} containing the Players in the game
     */
    List<Player> getPlayers();

    /**
     * Setter for the current player.
     * 
     * @param currentPlayer the {@link Player} who is currently playing
     */
    void setCurrentPlayer(Player currentPlayer);

    /**
     * Getter for the current player.
     * 
     * @return an {@link Optional} containing the player who's currently playing
     */
    Optional<Player> getCurrentPlayer();

}
