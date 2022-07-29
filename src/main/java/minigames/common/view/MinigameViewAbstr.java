package minigames.common.view;

import utils.GenericController;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MinigameView}.
 * 
 * @param <S> the scenes of the stage
 */
public abstract class MinigameViewAbstr<S> implements MinigameView<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link MinigameViewAbstr}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public MinigameViewAbstr(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final StageManager<S> getStageManager() {
        return stageManager;
    }


    @Override
    public abstract void startMinigame(GenericController controller);

}
