package menu.pausemenu.controller;

import menu.common.controller.MenuController;
import menu.common.controller.SimpleMenuControllerAbstr;
import utils.graphics.controller.StageManager;

/**
 * Extension of {@link SimpleMenuControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class PauseMenuControllerImpl extends SimpleMenuControllerAbstr implements MenuController {

    /**
     * Builder for {@link PauseMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> PauseMenuControllerImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void goNext() {
        this.getStageManager().popScene();
    }

    @Override
    public final void exit() {
        while (this.getStageManager().getScenes().size() > 1) {
            this.getStageManager().popScene();
        }
    }

    @Override
    public final void createMenu() {
        this.getStageManager().getGui().getViewFactory().createPauseMenuView(this);
    }

}
