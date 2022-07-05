package minigames.mastermind.model;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import minigames.common.model.MinigameModelAbstr;
import utils.graphics.StageManager;

public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> {

	private final List<Label> attempts;
	
	public MastermindModelImpl(final List<U> players, final StageManager<S> s, final List<Label> attempts) {
		super(players, s);
		this.attempts = attempts;
	}

	@Override
	public void runGame() {
		// TODO Auto-generated method stub
		
	}

}
