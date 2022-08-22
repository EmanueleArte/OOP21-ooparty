package game.dice.view;

import javafx.scene.paint.Color;
import utils.view.GenericViewController;

/**
 * This interface models the view controller of the dice.
 */
public interface DiceViewController extends GenericViewController {

    /**
     * This method initializes the dice scene.
     * 
     * @param result the result to be shown inside the dice
     * @param color  the color of the player who is rolling the dice
     * @param text   the text to write in the label of this scene
     */
    void initialize(int result, Color color, String text);

    /**
     * This method makes the player jump to roll the dice and show the result.
     */
    void jumpToDice();

}
