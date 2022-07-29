package menu.mainmenu.controller;

import menu.MenuController;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuViewImpl;
import menu.mainmenu.viewcontroller.MainMenuViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericView;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MenuController}.
 */
public class MainMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private final MainMenuModel<?> menuModel;
    private GenericViewController menuViewController;

    /**
     * Builder for {@link MainMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> MainMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.menuModel = new MainMenuModelImpl<>(s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        this.menuViewController = (MainMenuViewControllerImpl) viewController;
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
        final GenericView<?> menuView = new MainMenuViewImpl<>(this.getStageManager());
        menuView.createScene(this);
    }

}
