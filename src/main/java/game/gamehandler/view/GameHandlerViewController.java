package game.gamehandler.view;

import java.util.List;

import game.map.GameMap;
import game.player.Player;
import utils.controller.GenericController;

/**
 * Interface for the game handler view controller.
 */
public interface GameHandlerViewController {

    /**
     * Initializes the scene of the game.
     * 
     * @param players    the {@link List} of the players in the game
     * @param controller the {@link GameHandlerController} of the game
     * @param gameMap    the {@link GameMap} of the game
     */
    void initialize(List<Player> players, GenericController controller, GameMap gameMap);

    /**
     * Sets the text of the updates label.
     * 
     * @param text a {@link String} containing the text to write
     */
    void setUpdatesLabel(String text);

    /**
     * Shows the banner with a specified text.
     * 
     * @param text a {@link String} containing the text to write
     */
    void showBanner(String text);

    /**
     * Hides the banner.
     */
    void hideBanner();

    /**
     * Moves the avatar of a player from its old position to its new one.
     * 
     * @param p       the {@link Player} to move
     * @param gameMap the {@link GameMap} of the game
     */
    void movePlayer(Player p, GameMap gameMap);

    /**
     * Updates the game leaderboard.
     * 
     * @param players a {@link List} containing the players of the game
     */
    void updateLeaderboard(List<Player> players);

    /**
     * Updates the turn order.
     * 
     * @param players a {@link List} containing the ordered players
     */
    void updateTurnOrder(List<Player> players);

}
