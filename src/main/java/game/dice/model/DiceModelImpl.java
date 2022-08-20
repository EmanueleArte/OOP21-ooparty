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

    protected final void setResult(final int result) {
        this.lastResult = Optional.of(result);
        this.resultsList.add(result);
    }

    protected final List<Integer> getResultsList() {
        return this.resultsList;
    }

    protected final Random getRandom() {
        return this.rand;
    }
}
