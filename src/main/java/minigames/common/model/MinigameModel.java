package minigames.common.model;

import java.util.List;

/**
 * This interface models a minigame model
 */
public interface MinigameModel<S, U> {
	
	/**
     * This method runs the minigame.
	 */
	void runGame();
	
	/**
     * This method returns the results of the minigame that are necessary for points assignment, etc...
	 * @return a list of players ordered by their classification in the minigame with no draws
	 */
	List<U> gameResults();
	
	/**
     * This method associates a player to his score.
     * @param player the current {@link game.player.Player}
     * @param score the score of the player at the minigame
	 */
	void scoreMapper(U player, Integer score);

}
