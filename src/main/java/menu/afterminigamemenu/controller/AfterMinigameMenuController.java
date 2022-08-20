package menu.afterminigamemenu.controller;

import java.util.List;

import game.player.Player;
import menu.common.controller.MenuController;

/**
 * Interface for the after minigame menu controller.
 */
public interface AfterMinigameMenuController extends MenuController {

    /**
     * Calls the view controller to make the after minigame menu scene.
     * @param players the sorted list of the players
     */
    void makeLeaderboard(List<Player> players);

    /**
     * Calls the view controller to make the end of the game scene.
     * @param players the sorted list of the players
     */
    void makeEndGameLeaderboard(List<Player> players);

}
