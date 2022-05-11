package minigames.common;

import java.util.List;

/*
 * This interface models a generic minigame, which has to be implemented
 * in the main game
 */
public interface Minigame<U> {
	
	/**
     * This method runs the minigame
	 * @return gameResults() output
	 */
	List<U> runGame();

    /**
     * This method manages the draws at the end of the minigame
     * @return a list of players ordered by their classification in the minigame and draws already managed
	 */
    List<U> playoff();
	
	/**
     * This method returns the results of the minigame that are necessary for points assignment, etc...
	 * @return a list of players ordered by their classification in the minigame with no draws
	 */
	List<U> gameResults();

}
