package utils;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MenuController}.
 */
public abstract class GenericControllerAbstr implements GenericController {

    private final StageManager<?> stageManager;

    /**
     * Builder for {@link GenericControllerAbstr}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> GenericControllerAbstr(final StageManager<S> s) {
        this.stageManager = s;
    }

    /**
     * Getter for stageManager.
     * 
     * @return the {@link StageManager}
     */
    protected StageManager<?> getStageManager() {
        return this.stageManager;
    }

}
