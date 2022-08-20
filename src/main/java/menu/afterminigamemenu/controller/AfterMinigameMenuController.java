package menu.afterminigamemenu.controller;

import java.util.List;

import game.player.Player;
import menu.MenuController;

/**
 * Interface for the after minigame menu controller.
 */
public interface AfterMinigameMenuController {

    /**
     * Initializes the scene components.
     */
    void makeLeaderboard(List<Player> players);

}
