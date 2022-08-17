package game.dice.model;

import java.util.Optional;
import java.util.Random;

import utils.graphics.controller.StageManager;

public class DiceModelImpl<P> implements DiceModel<P> {

    /**
     * 
     */
    protected static final int MAX_RESULT = 6;

    private final Random rand;
    private final StageManager<?> stageManager;
    private Optional<Integer> result;

    public DiceModelImpl(final StageManager<?> s) {
        this.stageManager = s;
        rand = new Random();
        this.result = Optional.empty();
    }

    @Override
    public void rollDice() {
        this.setResult(this.rand.nextInt(DiceModelImpl.MAX_RESULT) + 1);
    }

    @Override
    public final void returnToGame() {
        this.stageManager.popScene();
    }

    @Override
    public final Optional<Integer> getLastResult() {
        return this.result;
    }

    protected final void setResult(final int result) {
        this.result = Optional.of(result);
    }

    protected final Random getRandom() {
        return this.rand;
    }
}
