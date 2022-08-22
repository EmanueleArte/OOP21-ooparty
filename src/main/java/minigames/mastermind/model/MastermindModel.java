package minigames.mastermind.model;

import minigames.common.model.MinigameModel;

/**
 * This interface models the mastermind model and extension of {@link MinigameModel}.
 */
public interface MastermindModel extends MinigameModel {

    /**
     * Getter for win.
     * 
     * @return true if the current player has guessed the 4-digit number
     */
    boolean getWin();

    /**
     * Getter for lose.
     * 
     * @return true if the current player hasn't guessed the 4-digit number and the
     *         attempts are ended
     */
    boolean getLose();

    /**
     * Getter for the number of attempts.
     * 
     * @return the number of attempts
     */
    int getNAttempts();

    /**
     * Getter for the solution.
     * 
     * @return the 4-digit number to guess
     */
    String getSolution();

    /**
     * Setter for the max number of attempts.
     * 
     * @param maxAttempts the maximum number of attempts
     */
    void setMaxAttempts(int maxAttempts);

    /**
     * This method controls the attempt of the player.
     * 
     * @param attempt the player attempt
     * @return the attempt string if the attempt is valid, empty string otherwise
     */
    String doAttempt(String attempt);

}
