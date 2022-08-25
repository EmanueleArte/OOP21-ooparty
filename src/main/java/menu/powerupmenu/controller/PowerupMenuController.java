package menu.powerupmenu.controller;

import game.player.Player;

/**
 * Interface for the power-up menu controller.
 */
public interface PowerupMenuController {

    /**
     * This method starts the power-up menu for a specified player.
     * 
     * @param currentPlayer the {@link Player} who can use a power-up
     */
    void start(Player currentPlayer);

    /**
     * This method closes the menu and returns to the main game.
     */
    void returnToGame();

    /**
     * This method tries to make the current player use a power-up towards a target.
     * It checks if the player actually has that power-up.
     * 
     * @param powerupType the type of power-up to use
     * @param target      the {@link Player} the power-up is used towards
     */
    void usePowerup(String powerupType, String target);

    /**
     * This method makes the scene update the available targets for a power-up.
     * 
     * @param powerupType the type of the selected power-up
     */
    void updateTargetsList(String powerupType);
}
