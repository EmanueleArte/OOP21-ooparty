package game.dice.controller;

import java.util.Optional;

import game.player.Player;

/**
 * This interface model the dice controller.
 */
public interface DiceController {

    /**
     * Rolls the dice generating a random result and starting the scene of the dice
     * roll.
     * 
     * @param p {@link Player} the player who is rolling the dice
     * @return int containing the result of the roll
     */
    int rollDice(Player p);

    /**
     * Getter for the result of the last roll.
     * 
     * @return {@link Optional} containing the result of the last roll.
     */
    Optional<Integer> getLastResult();

    /**
     * Getter for the sum of all the rolls of the dice.
     * 
     * @return int representing the sum of all the rolls of the dice.
     */
    int getTotal();

    /**
     * Resets the model of the dice to the default state.
     */
    void reset();

    /**
     * Closes the dice scene and returns to the previous one.
     */
    void returnToGame();
}
