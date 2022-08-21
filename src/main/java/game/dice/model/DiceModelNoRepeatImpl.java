package game.dice.model;

import java.util.stream.Collectors;

import game.player.Player;

/**
 * Extension of the {@link DiceModelImpl class}.
 */
public class DiceModelNoRepeatImpl extends DiceModelImpl {

    @Override
    public final int rollDice(final Player player) {
        if (this.getResults().size() == MAX_RESULT) {
            throw new RuntimeException("No more results available");
        }
        int result;
        do {
            result = this.getRandom().nextInt(MAX_RESULT) + 1;
        } while (this.getResults().stream().map(r -> r.getY()).collect(Collectors.toList()).contains(result));
        this.setResult(player, result);
        return result;
    }
}
