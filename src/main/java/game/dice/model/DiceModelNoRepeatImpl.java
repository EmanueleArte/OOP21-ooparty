package game.dice.model;

public class DiceModelNoRepeatImpl extends DiceModelImpl {

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
