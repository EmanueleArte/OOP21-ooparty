package game.gamehandler.model;

import java.util.List;
import java.util.Optional;

import game.map.GameMap;
import game.player.Player;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;

/**
 * This interface models the game handler model.
 */
public interface GameHandlerModel {

    /**
     * This method selects a minigame and plays it.
     */
    void playMinigame();

    /**
     * This method returns the players in the game.
     * 
     * @return a list containing the players in the game
     */
    List<Player> getPlayers();

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
     * This method ends the game and returns to main menu.
     */
    void endGame();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();

    /**
     * This method returns the leaderboard after a player's turn ends.
     * @return an ordered list of players
     */
    List<Player> getLeaderboard();

    /**
     * This method returns the turn order.
     * @return an ordered list of players representing the turn order
     */
    List<Player> getTurnOrder();
}
