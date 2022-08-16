package minigames.memo.model;

import java.util.List;

import minigames.common.model.MinigameModelAbstr;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link MemoModel} and extension of
 * {@link MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public class MemoModelImpl<S, U> extends MinigameModelAbstr<S, U> implements MemoModel<S, U> {

	public MemoModelImpl(List<U> players, StageManager<S> s) {
		super(players, s);
	}

	@Override
	public boolean runGame() {
		return false;
	}

}
