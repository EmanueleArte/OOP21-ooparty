package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.player.Player;
import utils.view.GenericViewController;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import game.map.GameMap;

public interface GameHandlerController {

    /**
     * Starts the game, creating the scene.
     */
    void start();

    /**
     * Returns the current turn number.
     * 
     * @return int representing the current turn.
     */
    int getTurnNumber();

    /**
     * Calls the nextStep() function of the model.
     * 
     * @return int representing new turn progress
     */
    //int nextStep();

    /**
     * Calls the nextPlayerTurnStep() function of the model.
     * 
     * @return int representing new players' turn progress
     */
    //int nextPlayerTurnStep();
    Optional<TurnProgress> nextStep();

    Optional<PlayerTurnProgress> nextPlayerTurnStep();

    /**
     * Returns the player who's currently playing, if there's one.
     * 
     * @return an Optional containing the current player.
     */
    Optional<Player> getCurrentPlayer();

    List<Player> getPlayers();

    /**
     * 
     * @return the {@link GameMap} of the current game
     */
    GameMap getGameMap();

    List<Player> getLeaderboard();

    void pauseMenu();

    /**
     * Checks if a {@link Player} is dead and if he is, it makes him respawn.
     * @param p the {@link Player} that has to be checked 
     */
    void checkPlayerDeath(Player p);

    List<Player> getTurnOrder();

    /**
     * Shows the after minigame menu.
     */
    void showAfterMinigameMenu();
}
