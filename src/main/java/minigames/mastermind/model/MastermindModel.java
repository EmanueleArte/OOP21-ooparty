package minigames.mastermind.model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * This interface models the mastermind model.
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MastermindModel<S, U> {

	/**
	 * This method sets the input field.
	 * @param inputField the {@link TextField} where a player puts
	 * 			his input
	 */
	void setInputField(TextField inputField);
	
	/**
	 * This method sets the notice label.
	 * @param noticeLabel the {@link Label} where is shown a notice
	 */
	void setNotice(Label noticeLabel);
	
	/**
	 * This method clears the notice label.
	 */
	void clearNotice();
	
}
