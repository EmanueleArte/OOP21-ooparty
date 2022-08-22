package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javafx.util.Pair;

import game.player.Player;

/**
 * Implementation of {@link DiceModel}.
 */
public class DiceModelImpl implements DiceModel {

    /**
     * The maximum valid result of the dice roll.
     */
    protected static final int MAX_RESULT = 6;

    private final Random rand;
    private Optional<Integer> lastResult;
    private final List<Pair<Player, Integer>> results;

    /**
     * Builds a {@link DiceModelImpl}.
     */
    public DiceModelImpl() {
        rand = new Random();
        this.lastResult = Optional.empty();
        this.results = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int rollDice(final Player player) {
        int result = this.rand.nextInt(DiceModelImpl.MAX_RESULT) + 1;
        this.setResult(player, result);
        return result;
    }

    @Override
    public final void reset() {
        this.lastResult = Optional.empty();
        this.results.clear();
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.lastResult;
    }

    @Override
    public final int getTotal() {
        return this.results.stream().map(r -> r.getValue()).reduce(0, Integer::sum);
    }

    /**
     * Sets the {@link Optional} containing the last result.
     * 
     * @param result the value of the last roll
     */
    protected void setResult(final Player player, final int result) {
        this.lastResult = Optional.of(result);
        this.results.add(new Pair<>(player, result));
    }

    /**
     * Getter for the {@link List} containing the previous rolls.
     * 
     * @return a list containing the previous rolls
     */
    public final List<Pair<Player, Integer>> getResults() {
        return this.results;
    }

    /**
     * Getter for the {@link Random} inside this class.
     * 
     * @return the Random
     */
    protected final Random getRandom() {
        return this.rand;
    }
}
