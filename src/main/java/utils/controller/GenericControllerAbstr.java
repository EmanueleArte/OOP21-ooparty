package utils.controller;

import utils.factories.FxmlViewFactoryImpl;
import utils.factories.ViewFactory;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link GenericController}.
 */
public abstract class GenericControllerAbstr implements GenericController {

    private final StageManager<?> stageManager;
    private final ViewFactory<?> viewFactory;

    /**
     * Builder for {@link GenericControllerAbstr}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> GenericControllerAbstr(final StageManager<S> s) {
        this.stageManager = s;
        this.viewFactory = new FxmlViewFactoryImpl<>(s);
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

    /**
     * Getter for factory.
     * 
     * @return the {@link ViewFactory}
     */
    protected ViewFactory<?> getViewFactory() {
        return this.viewFactory;
    }

}
