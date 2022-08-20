package game.map;

import java.util.List;

import game.player.Player;
import utils.enums.MapLayout;

/**
 * Interface for the game map.
 */
public interface GameMap {

    /**
     * 
     * @return the list of the map's squares
     */
    List<GameMapSquare> getSquares();

    /**
     * 
     * @param p the {@link Player} you want to know the position
     * @return the player p's position
     */
    GameMapSquare getPlayerPosition(Player p);

    /**
     * Returns the layout of the map.
     * @return map layout
     */
    MapLayout getLayout();

    /**
     * Puts all the players in the starting square if they are not already on the map.
     * @param players the list of the players to be put in the starting square
     */
    void initializePlayers(List<Player> players);

}
