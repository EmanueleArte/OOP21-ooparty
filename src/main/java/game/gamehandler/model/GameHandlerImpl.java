package game.gamehandler.model;

import java.util.List;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.map.GameMap;
import game.player.Player;
import utils.graphics.StageManager;

public class GameHandlerImpl<S> implements GameHandler {

	private StageManager<S> stageManager;
	private final DiceModel dice;
	private final GameMap gameMap;

	private final int turnsNumber;
	private final List<Player> players;

	public GameHandlerImpl(final StageManager<S> s, final List<Player> players, final GameMap gameMap) {
		this.stageManager = s;
		this.dice = new DiceModelImpl();
		this.turnsNumber = 10;
		this.players = players;
		this.gameMap = gameMap;
	}

	@Override
	public void start() {
		for (int turn = 1; turn <= turnsNumber; turn++) {
			System.out.println("Turno " + turn);
			players.forEach(p -> {
				playTurn(p);
			});
			playMinigame();
			showLeaderboard();
		}
	}

	@Override
	public void playTurn(Player player) {
		System.out.println("Turno di " + player.getNickname() + " - posizione: "+player.getPosition(this.gameMap));
		int roll = dice.rollDice(player);
		System.out.println("Lancio del dado: " + roll);
		player.moveForward(roll, this.gameMap);
		System.out.println("Nuova posizione: " + player.getPosition(this.gameMap));
	}

	@Override
	public void playMinigame() {
		System.out.println("Minigioco!");
	}

	@Override
	public void showLeaderboard() {
		System.out.println("Classifica");
	}

}
