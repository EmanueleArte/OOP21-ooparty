package game.dice.view;

import javafx.scene.paint.Color;
import utils.view.GenericViewController;

public interface DiceViewController extends GenericViewController {

    void initialize(int result, Color color, String text);

}