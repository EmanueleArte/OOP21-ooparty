package game.dice.model;

import java.util.List;

public interface DiceModel<P> {

    void rollDice();

    List<Integer> rollDices(List<P> players);

    void returnToGame();

    int getResult();
}
