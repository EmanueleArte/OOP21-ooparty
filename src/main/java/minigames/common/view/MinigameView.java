package minigames.common.view;

import java.util.List;

/**
 * This interface models a minigame view.
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public interface MinigameView<S, U> {
	
	/**
	 * This method creates the minigame scene.
	 */
	void startMinigame(List<U> players);

}
