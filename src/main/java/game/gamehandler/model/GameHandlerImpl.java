package game.gamehandler.model;

import java.util.List;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.player.Player;
import game.powerup.DoubleDicePowerup;
import utils.graphics.StageManager;

public class GameHandlerImpl<S> implements GameHandler {

	private StageManager<S> stageManager;
	private final DiceModel dice;

	private final int turnsNumber;
	private final List<Player> players;

	public GameHandlerImpl(final StageManager<S> s, List<Player> players) {
		this.stageManager = s;
		this.dice = new DiceModelImpl();
		this.turnsNumber = 10;
		this.players = players;
	}

	@Override
	public void start() {
		for (int turn = 1; turn <= turnsNumber; turn++) {
			System.out.println("\n-- TURNO " + turn);
			players.forEach(p -> {
				playTurn(p);
			});
			playMinigame();
			showLeaderboard();
		}
	}

	@Override
	public void playTurn(Player player) {
		System.out.println("\nTurno di " + player.getName() + " - posizione: " + player.getPosition());
		player.addPowerup(new DoubleDicePowerup());
		player.usePowerup(player.getPowerupsList().get(0));
		int movement = 0;
		for (int i = 0; i < player.getDicesNumber(); i++) {
			int roll = dice.rollDice(player);
			System.out.println("Lancio del dado: " + roll);
			movement += roll;
		}
		player.moveForward(movement);
		System.out.println("Nuova posizione: " + player.getPosition());
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
