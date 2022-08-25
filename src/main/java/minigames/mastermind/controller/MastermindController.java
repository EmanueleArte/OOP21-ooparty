package minigames.mastermind.controller;

import minigames.common.controller.MinigameController;

/**
 * This interface models the Mastermind controller. Specialization of {@link MinigameController}.
 */
public interface MastermindController extends MinigameController {

    /**
     * This method sets the maximum number of attempts.
     * 
     * @param maxAttempts the maximum number of attempts
     */
    void setMaxAttempts(int maxAttempts);

    /**
     * This method checks the attempt of the player.
     * 
     * @param attempt the input
     */
    void doAttempt(String attempt);

}
