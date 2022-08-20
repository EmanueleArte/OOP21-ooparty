package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
    private final List<Integer> resultsList;

    /**
     * Builds a {@link DiceModelImpl}.
     */
    public DiceModelImpl() {
        rand = new Random();
        this.lastResult = Optional.empty();
        this.resultsList = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int rollDice() {
        int result = this.rand.nextInt(DiceModelImpl.MAX_RESULT) + 1;
        this.setResult(result);
        return result;
    }

    @Override
    public final void reset() {
        this.lastResult = Optional.empty();
        this.resultsList.clear();
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.lastResult;
    }

    @Override
    public final int getTotal() {
        return this.resultsList.stream().reduce(0, Integer::sum);
    }

    /**
     * Sets the {@link Optional} containing the last result.
     * 
     * @param result the value of the last roll
     */
    protected void setResult(final int result) {
        this.lastResult = Optional.of(result);
        this.resultsList.add(result);
    }

    /**
     * Getter for the {@link List} containing the previous rolls.
     * 
     * @return a list containing the previous rolls
     */
    protected List<Integer> getResultsList() {
        return this.resultsList;
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
