package menu.pausemenu.model;

import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link PauseMenuModel}.
 * 
 * @param <S> the scenes of the stage
 */
public class PauseMenuModelImpl<S> implements PauseMenuModel<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link PauseMenuModelImpl}.
     * 
     * @param s the {@link StageManager}
     */
    public PauseMenuModelImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public final void returnMainMenu() {
        while (this.stageManager.getScenes().size() > 1) {
            this.stageManager.popScene();
        }
    }

    @Override
    public final void continueGame() {
        this.stageManager.popScene();
    }

}
