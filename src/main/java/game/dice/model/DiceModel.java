package game.dice.model;

import java.util.Optional;

public interface DiceModel<P> {

    void rollDice();

    void returnToGame();

    Optional<Integer> getLastResult();
}
