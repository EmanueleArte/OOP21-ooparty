package menu.pausemenu.model;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link PauseMenuModel}.
 * 
 * @param <S> the scenes of the stage
 */
public class PauseMenuModelImpl<S> implements PauseMenuModel<S> {

    private final StageManager<S> stageManager;

    /**
     * Builds a new {@link MainMenuModelImpl}.
     * 
     * @param s the {@link StageManager}
     */
    public PauseMenuModelImpl(final StageManager<S> s) {
        super();
        this.stageManager = s;
    }

    @Override
    public void returnMainMenu() {
        // TODO Auto-generated method stub

    }

    @Override
    public void continueGame() {
        // TODO Auto-generated method stub

    }

}
