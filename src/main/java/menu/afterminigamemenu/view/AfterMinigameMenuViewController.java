package menu.afterminigamemenu.view;

import java.util.List;

import game.player.Player;
import utils.view.GenericViewController;

/**
 * Interface for the after minigame menu viewcontroller.
 */
public interface AfterMinigameMenuViewController extends GenericViewController {

    /**
     * Makes the after minigame leaderboard.
     * 
     * @param players the sorted list of the players
     */
    void makeLeaderboard(List<Player> players);

    /**
     * Makes the end of the game leaderboard.
     * 
     * @param players the sorted list of the players
     */
    void makeEndGameLeaderboard(List<Player> players);

}
