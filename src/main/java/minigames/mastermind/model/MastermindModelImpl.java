package minigames.mastermind.model;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModelAbstr;
import utils.graphics.StageManager;

/**
 * Implementation of {@link MastermindModel} and extension of {@link minigames.common.model.MinigameModelAbstr}.
 */
public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> implements MastermindModel<S, U> {

	private final List<Label> attempts;
	
	public MastermindModelImpl(final List<U> players, final StageManager<S> s, final List<Label> attempts) {
		super(players, s);
		this.attempts = attempts;
	}

	@Override
	public void runGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInputField(TextField inputField) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNotice(Label noticeLabel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearNotice() {
		// TODO Auto-generated method stub
		
	}

}
