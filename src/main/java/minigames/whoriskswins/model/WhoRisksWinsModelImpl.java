package minigames.whoriskswins.model;

import java.util.List;
import java.util.Random;

import minigames.common.model.MinigameModelAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link WhoRisksWinsModel} and extension of
 * {@link MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public class WhoRisksWinsModelImpl<S, U> extends MinigameModelAbstr<S, U> implements WhoRisksWinsModel<S, U> {

    /**
     * Range of milliseconds.
     */
    private static final int TIME_RANGE = 2000;
    /**
     * Minimum milliseconds.
     */
    private static final int MINIMUM_TIME = 500;
    private int blockFallingSpeed;

    /**
     * Builds a new {@link WhoRisksWinsModelImpl}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public WhoRisksWinsModelImpl(final List<U> players, final StageManager<S> s) {
        super(players, s);
    }

    @Override
    public final boolean runGame() {
        if (this.hasNextPlayer()) {
            this.generateBlockFallingSpeed();
            this.setCurrPlayer();
            return true;
        }
        return false;
    }

    @Override
    public final void stopBlockFall(final double blockY, final double playerY) {
        // crea score

    }

    @Override
    public final int getBlockFallingSpeed() {
        return this.blockFallingSpeed;
    }

    /**
     * This method generates a new block falling speed.
     */
    private void generateBlockFallingSpeed() {
        final Random rand = new Random();
        this.blockFallingSpeed = rand.nextInt(WhoRisksWinsModelImpl.TIME_RANGE + WhoRisksWinsModelImpl.MINIMUM_TIME);
    }

}
