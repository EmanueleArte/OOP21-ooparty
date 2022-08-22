package menu.afterminigamemenu.view;

import java.util.List;

import game.player.Player;
import utils.view.GenericViewController;

/**
 * Interface for the after minigame menu viewcontroller.
 */
public interface AfterMinigameMenuViewController extends GenericViewController {

    /**
     * Initializes the scene components.
     */
    void makeLeaderboard(List<Player> players);

    /**
     * Initializes the scene components to make the end of the game.
     * @param players
     */
    void makeEndGameLeaderboard(List<Player> players);

}
