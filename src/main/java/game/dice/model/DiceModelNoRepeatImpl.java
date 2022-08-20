package game.dice.model;

import java.util.ArrayList;
import java.util.List;

public class DiceModelNoRepeatImpl extends DiceModelImpl {
    private final List<Integer> resultsList;

    public DiceModelNoRepeatImpl() {
        this.resultsList = new ArrayList<>();
    }

    @Override
    public final int rollDice() {
        if (this.resultsList.size() == MAX_RESULT) {
            return 0;
        }
        int result;
        do {
            result = this.getRandom().nextInt(MAX_RESULT) + 1;
        } while (this.resultsList.contains(result));
        this.setResult(result);
        return result;
    }
}
