package menu.afterminigamemenu.controller;

import java.util.List;

import game.player.Player;
import menu.MenuController;

public interface AfterMinigameMenuController {

    /**
     * Initializes the scene components.
     */
    void makeLeaderboard(List<Player> players);

}
