package game.dice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utils.graphics.stagemanager.StageManager;

public class DiceModelImpl<P> implements DiceModel<P> {

    private final Random rand;
    private final StageManager stageManager;
    private int result;

    public DiceModelImpl(final StageManager s) {
        this.stageManager = s;
        rand = new Random();
    }

    @Override
    public void rollDice() {
        this.result = rand.nextInt(6) + 1;
    }

    @Override
    public List<Integer> rollDices(final List<P> players) {
        /*
         * List<Integer> results = new ArrayList<Integer>(); players.forEach(player -> {
         * results.add(rollDice(player)); }); return results;
         */
        return null;
    }

    @Override
    public final void returnToGame() {
        this.stageManager.popScene();
    }

    @Override
    public int getResult() {
        return this.result;
    }

}
