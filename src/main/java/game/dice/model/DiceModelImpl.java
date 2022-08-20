package game.dice.model;

import java.util.Optional;
import java.util.Random;

public class DiceModelImpl implements DiceModel {

    /**
     * The maximum valid result of the dice roll.
     */
    protected static final int MAX_RESULT = 6;

    private final Random rand;
    private Optional<Integer> lastResult;

    public DiceModelImpl() {
        rand = new Random();
        this.lastResult = Optional.empty();
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
    public final Optional<Integer> getLastResult() {
        return this.lastResult;
    }

    @Override
    public final void reset() {
        this.lastResult = Optional.empty();
    }

    protected final void setResult(final int result) {
        this.lastResult = Optional.of(result);
    }

    protected final Random getRandom() {
        return this.rand;
    }
}
