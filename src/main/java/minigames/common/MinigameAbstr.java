package minigames.common;

import java.util.List;

public abstract class MinigameAbstr<U> implements Minigame<U> {

	private final List<U> players;

	public MinigameAbstr(final List<U> players) {
		this.players = players;
	}

	@Override
	public List<U> runGame() {
		return null;
	}

	@Override
	public List<U> playoff() {
		return null;
	}

	@Override
	public List<U> gameResults() {
		return null;
	}
	
}
