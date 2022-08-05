package game.dice.model;

import java.util.Random;

import utils.graphics.stagemanager.StageManager;

public class DiceModelImpl<P> implements DiceModel<P> {

    /**
     * 
     */
    protected static final int MAX_RESULT = 6;

    private final Random rand;
    private final StageManager<?> stageManager;
    private int result;

    public DiceModelImpl(final StageManager<?> s) {
        this.stageManager = s;
        rand = new Random();
    }

    @Override
    public void rollDice() {
        this.result = rand.nextInt(DiceModelImpl.MAX_RESULT) + 1;
    }

    @Override
    public final void returnToGame() {
        this.stageManager.popScene();
    }

    @Override
    public final int getResult() {
        return this.result;
    }

    protected final void setResult(final int result) {
        this.result = result;
    }

    protected final Random getRandom() {
        return this.rand;
    }
}
