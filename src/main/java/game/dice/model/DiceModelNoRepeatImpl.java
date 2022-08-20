package game.dice.model;

/**
 * Extension of the {@link DiceModelImpl class}.
 */
public class DiceModelNoRepeatImpl extends DiceModelImpl {

    @Override
    public final int rollDice() {
        if (this.getResultsList().size() == MAX_RESULT) {
            return 0;
        }
        int result;
        do {
            result = this.getRandom().nextInt(MAX_RESULT) + 1;
        } while (this.getResultsList().contains(result));
        this.setResult(result);
        return result;
    }
}
