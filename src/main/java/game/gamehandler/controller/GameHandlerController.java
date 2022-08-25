package game.gamehandler.controller;

import game.player.Player;

/**
 * This interface models the game handler controller of the game.
 */
public interface GameHandlerController {

    /**
     * Starts the game, creating the scene.
     */
    void start();

    /**
     * Makes the model go to the next step of the game and updates the
     * viewController accordingly.
     */
    void nextStep();

    /**
     * Starts the pause menu.
     */
    void pauseMenu();

    /**
     * Checks if a {@link Player} is dead and if he is, it makes him respawn.
     * 
     * @param p the {@link Player} that has to be checked
     */
    void checkPlayerDeath(Player p);

    /**
     * Shows the after minigame menu.
     */
    void showAfterMinigameMenu();

    /**
     * Ends the game.
     */
    void endGame();
}
