package menu.powerupmenu.view;

import java.util.List;

import game.player.Player;
import game.powerup.GenericPowerup;
import utils.view.GenericViewController;

/**
 * Interface for the view controller of the power-up menu.
 */
public interface PowerupMenuViewController extends GenericViewController {

    /**
     * This method initializes the scene of the power-up menu.
     * 
     * @param powerups the {@link List} of the current player's power-ups
     */
    void initializeScene(List<GenericPowerup> powerups);

    /**
     * This method makes the controller close the scene and return to the game.
     */
    void close();

    /**
     * This method sets the available target buttons for the currently selected
     * power-up.
     * 
     * @param powerup       the selected {@link GenericPowerup}
     * @param players       the {@link List} of the players in the game
     * @param currentPlayer the current {@link Player}
     */
    void setTargetsList(GenericPowerup powerup, List<Player> players, Player currentPlayer);

}
