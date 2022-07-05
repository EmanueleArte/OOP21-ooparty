package minigames.mastermind.control;

import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.mastermind.model.MastermindModelImpl;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MastermindController}.
 */
public class MastermindControllerImpl<S, U> implements MastermindController<S, U> {

	private final MastermindModelImpl<S, U> mastermindModel;
	@FXML private List<Label> attempts;
	@FXML private TextField inputField;
	@FXML private Label noticeLabel;
	
	public MastermindControllerImpl(final StageManager<S> s, final List<U> players) {
		super();
		this.mastermindModel = new MastermindModelImpl<>(players, s, this.attempts);
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
