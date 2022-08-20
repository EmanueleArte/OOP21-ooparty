package game.dice.view;

import javafx.scene.paint.Color;
import utils.view.GenericViewController;

public interface DiceViewController extends GenericViewController {

	void nextStep();

	void jumpToDice(int roll);

	void initialize(Color color, String text);

}