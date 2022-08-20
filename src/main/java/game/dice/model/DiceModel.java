package game.dice.model;

import java.util.List;
import java.util.Optional;

public interface DiceModel {

    void rollDice();

    void reset();

    Optional<Integer> getLastResult();

    List<Integer> getResultsList();

    Optional<Integer> getTotal();
}
