package minigames.common.view;

import java.util.List;

import utils.graphics.StageManager;

/**
 * Implementation of {@link MinigameView}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public abstract class MinigameViewAbstr<S, U> implements MinigameView<S, U> {

    private final StageManager<S> stageManager;

    public MinigameViewAbstr(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final StageManager<S> getStageManager() {
        return stageManager;
    }


    @Override
    public abstract void startMinigame(List<U> players);

}
