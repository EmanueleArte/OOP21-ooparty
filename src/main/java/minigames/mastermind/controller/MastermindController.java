package minigames.mastermind.controller;

import minigames.common.controller.MinigameController;

/**
 * Extension of {@link MinigameController}.
 */
public interface MastermindController extends MinigameController {

    /**
     * This method sets the maximum number of attempts.
     * 
     * @param maxAttempts the maximum number of attempts
     */
    void setMaxAttempts(int maxAttempts);

    /**
     * This method starts a new turn.
     * 
     * @return true if there is another player that has to play
     */
    boolean nextTurn();

    /**
     * This method checks the attempt of the player.
     * 
     * @param attempt the input
     */
    void doAttempt(String attempt);

}
