package menu.afterminigamemenu.view;

import java.util.List;

import game.player.Player;
import utils.view.GenericViewController;

public interface AfterMinigameMenuViewController extends GenericViewController {

    /**
     * Initializes the scene components.
     */
    void makeLeaderboard(List<Player> players);

}
