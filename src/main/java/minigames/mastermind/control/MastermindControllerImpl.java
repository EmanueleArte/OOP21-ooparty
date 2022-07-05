package minigames.mastermind.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModel;

/**
 * Implementation of {@link MastermindController}.
 */
public class MastermindControllerImpl<S, U> implements MastermindController<S, U> {

	private MinigameModel<S, U> mastermindModel;
	@FXML private List<Label> playersNicknames;
	@FXML private TextField inputField;
	
	public MastermindControllerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tryGuess() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearNotice() {
		// TODO Auto-generated method stub
		
	}

}
