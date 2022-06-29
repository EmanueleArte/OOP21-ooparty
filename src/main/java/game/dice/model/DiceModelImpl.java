package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceModelImpl<P> implements DiceModel<P> {

	private final Random rand;

	public DiceModelImpl(){
		rand = new Random();
	}
	
	@Override
	public int rollDice(P player) {
		return rand.nextInt(6) + 1;
	}

	@Override
	public List<Integer> rollDices(List<P> players) {
		List<Integer> results = new ArrayList<Integer>();
		players.forEach(player -> {
			results.add(rollDice(player));
		});
		return results;
	}

}
