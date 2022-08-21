package game.gamehandler.controller;

import java.util.List;

import game.player.Player;
import game.map.GameMap;

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

    List<Player> getPlayers();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();

    List<Player> getLeaderboard();

    void pauseMenu();

    /**
     * Checks if a {@link Player} is dead and if he is, it makes him respawn.
     * 
     * @param p the {@link Player} that has to be checked
     */
    void checkPlayerDeath(Player p);

    List<Player> getTurnOrder();

    /**
     * Shows the after minigame menu.
     */
    void showAfterMinigameMenu();

    /**
     * Ends the game.
     */
    void endGame();
}
