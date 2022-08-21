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
     */
    void initializeScene(List<GenericPowerup> powerups);

    /**
     * This method makes the controller close the scene and return to the game.
     */
    void close();

    /**
     * This method sets the available target buttons for the currently selected
     * power-up.
     */
    void setTargetsList(GenericPowerup powerup, List<Player> players, Player currentPlayer);

}