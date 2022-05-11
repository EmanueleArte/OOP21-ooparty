package minigames.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
	private void scoreMapper(final U player, final Integer score) {
		this.playersClassification.put(player, score);
	}
	
	/**
     * This method orders the list of players by their score (higher to lower).
     * @return a list of players ordered by their score
	 */
	private List<U> sortPlayersByScore() {
		return this.playersClassification.entrySet().stream()
				.sorted((a, b) -> {
					if(a.getValue() >= b.getValue()) {
						return -1;
					} else {
						return 1;
					}
				})
				//.flatMap(player -> player.getKey())
				.collect(Collectors.toMap(player -> player.getKey(), player -> player.getValue()))
				.keySet()
				.stream()
				.toList();
	}
	
}
