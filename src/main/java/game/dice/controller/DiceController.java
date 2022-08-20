package game.dice.controller;

import java.util.Optional;

import game.dice.model.DiceModel;
import game.player.Player;

public interface DiceController {

    /**
     * Rolls the dice generating a random result.
     */
    void rollDice();

    /**
     * Starts the dice screen.
     * 
     * @param p the player that has to roll the dice
     */
    void start(Player p);

    /**
     * Returns the last roll of the dice.
     */
    Optional<Integer> getLastResult();

    /**
     * Closes the dice and returns to the previous screen.
     */
    void returnToGame();

    void reset();

    Optional<Integer> getTotal();
    
    DiceModel getModel();
}
