package game.gamehandler.model;

import java.util.List;
import java.util.Optional;

import game.map.GameMap;
import game.player.Player;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.model.GenericModel;

/**
 * This interface models the game handler model.
 */
public interface GameHandlerModel extends GenericModel {

    /**
     * This method returns the players in the game.
     * 
     * @return a list containing the players in the game
     */
    List<Player> getPlayers();

    /**
     * Sets the players list.
     * 
     * @param players {@link List} of players
     */
    void setPlayers(List<Player> players);

    /**
     * This method makes the turn advance to the next step.
     * 
     * @return Optional containing new turn
     */
    Optional<TurnProgress> nextStep();

    /**
     * This method makes players' turn go to the next step.
     * 
     * @return Optional containing new player turn
     */
    Optional<PlayerTurnProgress> nextPlayerTurnStep();

    /**
     * This method returns the player currently playing, if there's one.
     * 
     * @return Optional containing the player who's currently playing
     */
    Optional<Player> getCurrentPlayer();

    /**
     * This method returns the current turn number.
     * 
     * @return current turn number
     */
    int getTurnNumber();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();

    /**
     * This method returns the leaderboard after a player's turn ends.
     * 
     * @return an ordered list of players
     */
    List<Player> getLeaderboard();

    /**
     * Checks if a {@link Player} is dead and if he is, it makes him respawn.
     * 
     * @param p the {@link Player} that has to be checked
     */
    void checkPlayerDeath(Player p);

    /**
     * This method returns the turn order.
     * 
     * @return an ordered list of players representing the turn order
     */
    List<Player> getTurnOrder();
}
