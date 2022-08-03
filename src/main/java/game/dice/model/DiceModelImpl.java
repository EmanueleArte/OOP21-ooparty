package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.graphics.stagemanager.StageManager;

public class DiceModelImpl<P> implements DiceModel<P> {

    private final Random rand;
    private final StageManager stageManager;

    public DiceModelImpl(final StageManager s) {
        this.stageManager = s;
        rand = new Random();
    }

    @Override
    public int rollDice(final P player) {
        return rand.nextInt(6) + 1;
    }

    @Override
    public List<Integer> rollDices(final List<P> players) {
        List<Integer> results = new ArrayList<Integer>();
        players.forEach(player -> {
            results.add(rollDice(player));
        });
        return results;
    }

    @Override
    public final void returnToGame() {
        this.stageManager.popScene();
    }

}
