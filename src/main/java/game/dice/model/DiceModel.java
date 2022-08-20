package game.dice.model;

import java.util.Optional;

public interface DiceModel {

    int rollDice();

    void reset();

    Optional<Integer> getLastResult();
}
