package minigames.mastermind.model;

import java.util.List;

import minigames.common.model.MinigameModelAbstr;
import utils.graphics.StageManager;

public class MastermindModelImpl<S, U> extends MinigameModelAbstr<S, U> {

	public MastermindModelImpl(final List<U> players, final StageManager<S> s) {
		super(players, s);
	}

	@Override
	public void runGame() {
		// TODO Auto-generated method stub
		
	}

}
