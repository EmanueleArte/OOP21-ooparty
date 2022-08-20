package game.dice.model;

import java.util.Optional;

/**
 * This interface models the dice model.
 */
public interface DiceModel {

    /**
     * This method makes the dice roll, generating one random result.
     * 
     * @return int containing the result of the roll
     */
    int rollDice();

    /**
     * Resets the dice to default values, deleting everything about the previous
     * rolls.
     */
    void reset();

    /**
     * Getter for the result of the last roll.
     * 
     * @return {@link Optional} containing the result of the last roll
     */
    Optional<Integer> getLastResult();

    /**
     * Getter for the first result in the results list.
     * 
     * @return the first result in the results list
     */
    int popFirstResult();

    /**
     * Getter for the sum of all the previous rolls.
     * 
     * @return the sum of the previous rolls
     */
    int getTotal();
}
