package game.gamehandler.controller;

import java.util.Optional;

import game.player.Player;

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
    int nextStep();

    /**
     * Calls the nextPlayerTurnStep() function of the model.
     * 
     * @return int representing new players' turn progress
     */
    int nextPlayerTurnStep();

    /**
     * Returns the player who's currently playing, if there's one.
     * 
     * @return an Optional containing the current player.
     */
    Optional<Player> getCurrentPlayer();

}
