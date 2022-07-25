package minigames.common.view;

import java.util.List;

import utils.graphics.StageManagerController;

/**
 * Implementation of {@link MinigameView}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public abstract class MinigameViewAbstr<S, U> implements MinigameView<S, U> {

    private final StageManagerController<S> stageManager;

    /**
     * Builds a new {@link MinigameViewAbstr}.
     * 
     * @param s the {@link utils.graphics.StageManagerController}
     */
    public MinigameViewAbstr(final StageManagerController<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final StageManagerController<S> getStageManager() {
        return stageManager;
    }


    @Override
    public abstract void startMinigame(List<U> players);

}
