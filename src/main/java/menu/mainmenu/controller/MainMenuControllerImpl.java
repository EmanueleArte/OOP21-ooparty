package menu.mainmenu.controller;

import menu.MenuControllerAbstr;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuView;
import menu.mainmenu.view.MainMenuViewImpl;
import menu.mainmenu.viewcontroller.MainMenuViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link MenuControllerAbstr}.
 */
public class MainMenuControllerImpl extends MenuControllerAbstr {

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
        this.menuViewController.setMainMenuController(this);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        this.menuViewController = (MainMenuViewController) viewController;
    }

}
