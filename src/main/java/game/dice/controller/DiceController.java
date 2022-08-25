package game.dice.controller;

import game.dice.model.DiceModel;

/**
 * This interface models the dice controller.
 */
public interface DiceController {

    /**
     * This method starts a dice scene for every roll result present in the model.
     */
    void start();

    /**
     * This method makes the dice scene go the next step. If a dice scene is over,
     * the next one is played. If all the dice scenes are over, the game goes back
     * to the previous scene.
     */
    void nextStep();

    /**
     * Getter for the model of the dice.
     * 
     * @return {@link DiceModel} of this dice controller
     */
    DiceModel getModel();
}
