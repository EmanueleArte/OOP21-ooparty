package utils.controller;

import utils.factories.FxmlViewFactoryImpl;
import utils.factories.ViewFactory;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link GenericController}.
 */
public abstract class GenericControllerAbstr implements GenericController {

    private final StageManager<?> stageManager;
    private final ViewFactory<?> factory;

    /**
     * Builder for {@link GenericControllerAbstr}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> GenericControllerAbstr(final StageManager<S> s) {
        this.stageManager = s;
        this.factory = new FxmlViewFactoryImpl<>(s);
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
    protected ViewFactory<?> getFactory() {
        return this.factory;
    }

}
