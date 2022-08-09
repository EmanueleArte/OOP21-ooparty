package game.dice.model;

import java.util.ArrayList;
import java.util.List;

import utils.graphics.stagemanager.StageManager;

public class DiceModelNoRepeatImpl<P> extends DiceModelImpl<P> {
    private final List<Integer> resultsList;

    public DiceModelNoRepeatImpl(final StageManager<?> s) {
        super(s);
        this.resultsList = new ArrayList<>();
    }

    @Override
    public final void rollDice() {
        int result;
        do {
            result = this.getRandom().nextInt(DiceModelImpl.MAX_RESULT) + 1;
        } while (this.resultsList.contains(result));
        this.setResult(result);
        this.resultsList.add(result);
    }
}
