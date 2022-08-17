package utils.controller;

import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link GenericController}.
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

    @Override
    public abstract <C> void setViewController(C viewController);

    /**
     * Getter for stageManager.
     * 
     * @return the {@link StageManager}
     */
    protected StageManager<?> getStageManager() {
        return this.stageManager;
    }

}
