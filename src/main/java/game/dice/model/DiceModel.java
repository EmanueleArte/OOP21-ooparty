package game.dice.model;

import java.util.List;

public interface DiceModel<P> {

	int rollDice(P player);
	
	List<Integer> rollDices(List<P> players);

    void returnToGame();
}
