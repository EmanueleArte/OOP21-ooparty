package minigames.whoriskswins.model;

import java.util.List;
import java.util.Random;

import game.dice.model.DiceModel;
import game.player.Player;
import minigames.common.model.MinigameModelAbstr;

/**
 * Implementation of {@link WhoRisksWinsModel} and extension of
 * {@link MinigameModelAbstr}.
 */
public class WhoRisksWinsModelImpl extends MinigameModelAbstr implements WhoRisksWinsModel {

    /**
     * Range of milliseconds.
     */
    private static final int TIME_RANGE = 800;
    /**
     * Minimum milliseconds.
     */
    private static final int MINIMUM_TIME = 500;
    private int blockFallingSpeed;

    /**
     * Builds a new {@link WhoRisksWinsModelImpl}.
     * 
     * @param players the list of players
     * @param dice    the {@link DiceModel}
     */
    public WhoRisksWinsModelImpl(final List<Player> players, final DiceModel dice) {
        super(players, dice);
    }

    @Override
    public final boolean runGame() {
        if (this.hasNextPlayer()) {
            this.generateBlockFallingSpeed();
            this.setCurrPlayer();
            return true;
        }
        this.setGameResults();
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
