package minigames.common;

import java.util.List;
import java.util.Map;

public abstract class MinigameAbstr<U> implements Minigame<U> {

	private final List<U> players;
	private Map<U, Integer> playersClassification;

	public MinigameAbstr(final List<U> players) {
		this.players = players;
	}

	@Override
	public List<U> runGame() {
		
		return this.gameResults();
	}

	@Override
	public List<U> gameResults() {
		
		return null;
	}
	
	/**
     * This method manages the draws at the end of the minigame
     * @return a list of players ordered by their classification in the minigame and draws already managed
	 */
	private List<U> playoff() {
		return null;
	}
	
}
