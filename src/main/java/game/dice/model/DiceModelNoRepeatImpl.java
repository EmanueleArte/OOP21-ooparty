package game.dice.model;

import utils.graphics.controller.StageManager;

public class DiceModelNoRepeatImpl extends DiceModelImpl {

    public DiceModelNoRepeatImpl(final StageManager<?> s) {
        super(s);
    }

    @Override
    public final void rollDice() {
        if (this.getResultsList().size() == MAX_RESULT) {
            return;
        }
        int result;
        do {
            result = this.getRandom().nextInt(MAX_RESULT) + 1;
        } while (this.getResultsList().contains(result));
        this.setResult(result);
    }
}
