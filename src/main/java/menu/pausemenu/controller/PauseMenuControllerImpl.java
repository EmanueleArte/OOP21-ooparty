package menu.pausemenu.controller;

import menu.common.controller.MenuController;
import menu.common.controller.SimpleMenuControllerAbstr;
import menu.pausemenu.model.PauseMenuModel;
import menu.pausemenu.model.PauseMenuModelImpl;
import utils.graphics.controller.StageManager;

/**
 * Extension of {@link SimpleMenuControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class PauseMenuControllerImpl extends SimpleMenuControllerAbstr implements MenuController {

    private final PauseMenuModel<?> menuModel;

    /**
     * Builder for {@link PauseMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> PauseMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.menuModel = new PauseMenuModelImpl<>(s);
    }

    @Override
    public final void goNext() {
        this.menuModel.continueGame();
    }

    @Override
    public final void exit() {
        this.menuModel.returnMainMenu();
    }

    @Override
    public final void createMenu() {
        this.getStageManager().getGui().getViewFactory().createPauseMenuView(this);
    }

}
