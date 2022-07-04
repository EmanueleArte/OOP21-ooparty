package minigames.common.view;

import utils.graphics.StageManager;

/**
 * Implementation of {@link MinigameView}.
 */
public abstract class MinigameViewAbstr<S> implements MinigameView<S> {

	@SuppressWarnings("unused")
	final private StageManager<S> stageManager;
	
	public MinigameViewAbstr(final StageManager<S> s) {
		super();
		this.stageManager = s;
	}

	@Override
	public abstract void startMinigame();

}
