package menu.mainmenu.controller;

import menu.MenuController;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import utils.GenericControllerAbstr;
import utils.GenericViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MenuController}.
 */
public class MainMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private final MainMenuModel<?> menuModel;
    private MainMenuView<?> menuView;
    private MainMenuViewController menuViewController;

    /**
     * Builder for {@link MainMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link utils.graphics.stagemanager.StageManager}
     */
    public <S> MainMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.menuModel = new MainMenuModelImpl<>(s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        this.menuViewController = (MainMenuViewController) viewController;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.menuViewController;
    }

    @Override
    public final void goNext() {
        this.menuModel.gameCreationMenu();
    }

    @Override
    public final void exit() {
        this.menuModel.exit();
    }

    @Override
    public final void createMenu() {
        this.menuView = new MainMenuViewImpl<>(this.getStageManager());
        this.menuView.createMainMenu(this);
    }

}
