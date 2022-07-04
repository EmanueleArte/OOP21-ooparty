package minigames.common.view;

import java.util.List;

import utils.graphics.StageManager;

/**
 * Implementation of {@link MinigameView}.
 */
public abstract class MinigameViewAbstr<S, U> implements MinigameView<S, U> {

	protected final StageManager<S> stageManager;
	
	public MinigameViewAbstr(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@Override
	public abstract void startMinigame(final List<U> players);

}
