package minigames.memo.model;

import minigames.common.model.MinigameModel;

/**
 * This interface models the minigame {@code memo}'s model.
 * This interface is a specialization of {@link MinigameModel}
 *
 * @param <S> the scenes of the stage
 */
public interface MemoModel<S> extends MinigameModel<S> {
	
	boolean isOver();
	
	int chooseCard(final int index) ;
	
	void changeTurn();
}
