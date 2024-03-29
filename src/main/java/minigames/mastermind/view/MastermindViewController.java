package minigames.mastermind.view;

import minigames.common.view.MinigameViewController;

/**
 * This interface models the Mastermind view controller. Specialization of
 * {@link MinigameViewController}.
 */
public interface MastermindViewController extends MinigameViewController {

    /**
     * This method shows the attempt done if it is valid.
     * 
     * @param attemptDone the attempt string, it is empty if the attempt is invalid
     */
    void showAttemptDone(String attemptDone);

    /**
     * This method shows the results of the turn.
     * 
     * @param win       is true if the player has guessed
     * @param lose      is true if the player ended the turns without guessing
     * @param score     the score of the player
     * @param solution  the 4-digit number to guess
     * @param nAttempts the number of attempts done
     */
    void showTurnResults(boolean win, boolean lose, int score, String solution, int nAttempts);

}
