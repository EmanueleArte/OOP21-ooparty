package menu.pausemenu.controller;

import menu.MenuController;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MenuController}.
 */
public class PauseMenuControllerImpl extends GenericControllerAbstr implements MenuController {

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
        // TODO Auto-generated method stub
        return null;
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

    @Override
    public <C> void setViewController(final C viewController) {
        // TODO Auto-generated method stub

    }

}
