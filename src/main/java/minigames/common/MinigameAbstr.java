package minigames.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
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
	
	/**
     * @return a map with players as keys and their score as values
	 */
	public Map<U, Integer> getPlayersClassification() {
		return this.playersClassification;
	}
	
	/**
     * This method sets the map of players associated to their scores.
     * @param playersClassification
     * 			a map with players as keys and their score as values
	 */
	public void setPlayersClassification(final Map<U, Integer> playersClassification) {
		this.playersClassification = playersClassification;
	}

	@Override
	abstract public List<U> runGame();

	@Override
	public List<U> gameResults() {
		
		return this.sortPlayersByScore();
	}
	
	@Override
	public void scoreMapper(final U player, final Integer score) {
		this.playersClassification.put(player, score);
	}
	
	/**
     * This method manages the draws at the end of the minigame.
     * @return a list of players ordered by their classification in the minigame and draws already managed
	 */
	private List<U> playoff() {
		return null;
	}
	
	/**
     * This method orders the list of players by their score (higher to lower).
     * @return a list of players ordered by their score
	 */
	private List<U> sortPlayersByScore() {
		return this.playersClassification.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))
				.keySet()
				.stream()
				.collect(Collectors.toList());
	}
	
}
