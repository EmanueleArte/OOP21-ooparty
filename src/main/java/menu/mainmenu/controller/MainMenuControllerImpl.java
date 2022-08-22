package menu.mainmenu.controller;

import menu.common.controller.MenuController;
import menu.common.controller.SimpleMenuControllerAbstr;
import menu.mainmenu.model.MainMenuModel;
import utils.graphics.controller.StageManager;

/**
 * Extension of {@link SimpleMenuControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class MainMenuControllerImpl extends SimpleMenuControllerAbstr implements MenuController {

    private final MainMenuModel menuModel;

    /**
     * Builder for {@link MainMenuControllerImpl}.
     * 
     * @param <S>   the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link MainMenuModel}
     */
    public <S> MainMenuControllerImpl(final StageManager<S> s, final MainMenuModel model) {
        super(s);
        this.menuModel = model;
    }

    @Override
    public final void goNext() {
        this.getStageManager().getControllerFactory().createGameCreationMenuController().createMenu();
    }

    @Override
    public final void exit() {
        this.menuModel.exit();
    }

    @Override
    public final void createMenu() {
        this.getStageManager().getGui().getViewFactory().createMainMenuView(this);
    }

}
