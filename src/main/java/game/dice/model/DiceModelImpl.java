package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import game.player.Player;
import utils.graphics.controller.StageManager;

public class DiceModelImpl implements DiceModel {

    /**
     * The maximum valid result of the dice roll.
     */
    protected static final int MAX_RESULT = 6;

    private final Random rand;
    private final StageManager<?> stageManager;
    private Optional<Integer> lastResult;
    private Optional<Integer> total;
    private final List<Integer> resultsList;

    public DiceModelImpl(final StageManager<?> s) {
        this.stageManager = s;
        rand = new Random();
        this.lastResult = Optional.empty();
        this.total = Optional.empty();
        this.resultsList = new ArrayList<>();
    }

    @Override
    public void rollDice() {
        int result = this.rand.nextInt(DiceModelImpl.MAX_RESULT) + 1;
        this.setResult(result);
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.lastResult;
    }

    @Override
    public final void reset() {
        this.lastResult = Optional.empty();
        this.total = Optional.empty();
        this.resultsList.clear();
    }

    @Override
    public final List<Integer> getResultsList() {
        return this.resultsList;
    }

    @Override
    public final Optional<Integer> getTotal() {
        return this.total;
    }

    protected final void setResult(final int result) {
        this.lastResult = Optional.of(result);
        this.resultsList.add(result);
        this.total.ifPresentOrElse(v -> {
            this.total = Optional.of(v + result);
        }, () -> {
            this.total = Optional.of(result);
        });
    }

    protected final Random getRandom() {
        return this.rand;
    }
}
