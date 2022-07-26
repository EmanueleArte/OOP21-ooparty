package menu;

import menu.mainmenu.controller.MainMenuController;
import utils.graphics.stagemanager.StageManager;

public abstract class MenuControllerAbstr implements MainMenuController {

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
