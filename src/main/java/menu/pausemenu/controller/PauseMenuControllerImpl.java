package menu.pausemenu.controller;

import menu.MenuController;
import menu.pausemenu.viewcontroller.PauseMenuViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

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
        // TODO Auto-generated method stub

    }

    @Override
    public final void exit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void createMenu() {
        // TODO Auto-generated method stub

    }

}
