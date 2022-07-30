package minigames.whoriskswins.model;

import java.util.List;

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
            //velocità caduta
            this.setCurrPlayer();
            return true;
        }
        return false;
    }

    @Override
    public final void stopBlockFall(final int blockY, final int playerY) {
        // crea score

    }

    @Override
    public final int getBlockFallingSpeed() {
        return this.blockFallingSpeed;
    }

}
