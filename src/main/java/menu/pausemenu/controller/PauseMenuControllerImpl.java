package menu.pausemenu.controller;

import menu.MenuController;
import menu.pausemenu.model.PauseMenuModel;
import menu.pausemenu.model.PauseMenuModelImpl;
import menu.pausemenu.view.PauseMenuViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class PauseMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private final PauseMenuModel<?> menuModel;
    private GenericViewController menuViewController;

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
    public final GenericViewController getViewController() {
        return this.menuViewController;
    }

    @Override
    public final <C> void setViewController(final C viewController) throws IllegalArgumentException {
        if (viewController instanceof PauseMenuViewControllerImpl) {
            this.menuViewController = (PauseMenuViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of PauseMenuViewControllerImpl");
        }
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
        this.getViewFactory().createPauseMenuView(this);
    }

}
