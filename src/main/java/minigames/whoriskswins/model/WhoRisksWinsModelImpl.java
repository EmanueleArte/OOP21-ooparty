package minigames.whoriskswins.model;

import java.util.List;
import java.util.Random;

import game.player.Player;
import minigames.common.model.MinigameModelAbstr;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link WhoRisksWinsModel} and extension of
 * {@link MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class WhoRisksWinsModelImpl<S> extends MinigameModelAbstr<S> implements WhoRisksWinsModel<S> {

    /**
     * Range of milliseconds.
     */
    private static final int TIME_RANGE = 800;
    /**
     * Minimum milliseconds.
     */
    private static final int MINIMUM_TIME = 700;
    private int blockFallingSpeed;

    /**
     * Builds a new {@link WhoRisksWinsModelImpl}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public WhoRisksWinsModelImpl(final List<Player> players, final StageManager<S> s) {
        super(players, s);
    }

    @Override
    public final boolean runGame() {
        if (this.hasNextPlayer()) {
            this.generateBlockFallingSpeed();
            this.setCurrPlayer();
            return true;
        }
        this.getStageManager().popScene();
        return false;
    }

    @Override
    public final void stopBlockFall(final double blockY, final double playerY) {
        int score = (int) (playerY + blockY);
        if (blockY > playerY) {
            score = 0;
        }
        this.setScore(score);
        this.scoreMapper(this.getCurrPlayer(), this.getScore());
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
        this.blockFallingSpeed = rand.nextInt(WhoRisksWinsModelImpl.TIME_RANGE) + WhoRisksWinsModelImpl.MINIMUM_TIME;
    }

}
