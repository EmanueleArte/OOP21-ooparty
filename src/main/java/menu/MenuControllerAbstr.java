package menu;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MenuController}.
 */
public abstract class MenuControllerAbstr implements MenuController {

    private final StageManager<?> stageManager;

    /**
     * Builder for {@link MenuControllerAbstr}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> MenuControllerAbstr(final StageManager<S> s) {
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
