package utils;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link GenericView}.
 * 
 * @param <S> the scenes of the stage
 */
public abstract class GenericViewAbstr<S> implements GenericView<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link GenericViewAbstr}.
     * 
     * @param s the {@link utils.graphics.stagemanager.StageManager}
     */
    public GenericViewAbstr(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final StageManager<S> getStageManager() {
        return stageManager;
    }


    @Override
    public abstract void crateScene(GenericController controller);

}
