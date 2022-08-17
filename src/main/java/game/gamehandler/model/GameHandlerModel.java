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

    void playTurn(Player player);

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
     * @return int representing new turn progress
     */
    Optional<TurnProgress> nextStep();

    /**
     * This method makes players' turn go to the next step.
     * 
     * @return int representing new player turn progress.
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
}
