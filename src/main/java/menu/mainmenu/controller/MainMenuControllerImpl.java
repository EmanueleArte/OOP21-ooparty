package menu.mainmenu.controller;

import menu.MenuController;
import menu.mainmenu.model.MainMenuModel;
import menu.mainmenu.model.MainMenuModelImpl;
import menu.mainmenu.view.MainMenuViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;
import utils.view.GenericViewUtils;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MenuController}.
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
    public final <C> void setViewController(final C viewController) throws IllegalArgumentException {
        if (viewController instanceof MainMenuViewControllerImpl) {
            this.menuViewController = (MainMenuViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MainMenuViewControllerImpl");
        }
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
        GenericViewUtils.createScene(this.getStageManager(), this, "menu/main_menu.fxml");
    }

}
