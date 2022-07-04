package minigames.common.view;

/**
 * This interface models a minigame view.
 * @param <S> the scenes of the stage
 */
public interface MinigameView<S> {
	
	/**
	 * This method creates the minigame scene.
	 */
	void startMinigame();

}
