package minigames.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class MinigameAbstr<U> implements Minigame<U> {

	private final List<U> players;
	private Map<U, Integer> playersClassification;


	public MinigameAbstr(final List<U> players) {
		this.players = players;
		this.playersClassification = new HashMap<>();
	}
	
	public MinigameAbstr() {
		this(null);
	}
	
	public Map<U, Integer> getPlayersClassification() {
		return this.playersClassification;
	}
	
	public void setPlayersClassification(final Map<U, Integer> playersClassification) {
		this.playersClassification = playersClassification;
	}

	@Override
	public List<U> runGame() {
		
		return this.gameResults();
	}

	@Override
	public List<U> gameResults() {
		
		return this.sortPlayersByScore();
	}
	
	/**
     * This method manages the draws at the end of the minigame.
     * @return a list of players ordered by their classification in the minigame and draws already managed
	 */
	private List<U> playoff() {
		return null;
	}
	
	/**
     * This method associates a player to his score.
     * @param player
     * 			the current player
     * @param score
     * 			the score of the player at the minigame
	 */
	public void scoreMapper(final U player, final Integer score) {
		this.playersClassification.put(player, score);
	}
	
	/**
     * This method orders the list of players by their score (higher to lower).
     * @return a list of players ordered by their score
	 */
	private List<U> sortPlayersByScore() {
		return this.playersClassification.entrySet().stream()
				/*.sorted((a, b) -> {
					if(a.getValue() >= b.getValue()) {
						return -1;
					} else {
						return 1;
					}
				})*/
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))
				.keySet()
				.stream()
				.toList();
	}
	
}
