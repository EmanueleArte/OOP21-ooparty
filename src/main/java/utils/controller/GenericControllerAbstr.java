package utils.controller;

import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void setViewController(GenericViewController viewController);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract GenericViewController getViewController();

    /**
     * Getter for stageManager.
     *
     * @return the {@link StageManager}
     */
    protected StageManager<?> getStageManager() {
        return this.stageManager;
    }

}
