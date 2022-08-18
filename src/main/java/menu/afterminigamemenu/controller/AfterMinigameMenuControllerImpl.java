package menu.afterminigamemenu.controller;

import menu.MenuController;
import menu.afterminigamemenu.model.AfterMinigameMenuModel;
import menu.afterminigamemenu.model.AfterMinigameMenuModelImpl;
import menu.afterminigamemenu.view.AfterMinigameMenuViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class AfterMinigameMenuControllerImpl extends GenericControllerAbstr implements MenuController, AfterMinigameMenuController {

    private final AfterMinigameMenuModel menuModel;
    private AfterMinigameMenuViewController menuViewController;

    /**
     * Builder for {@link AfterMinigameMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> AfterMinigameMenuControllerImpl(final StageManager<S> s) {
        super(s);
        this.menuModel = new AfterMinigameMenuModelImpl();
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof AfterMinigameMenuControllerImpl) {
            this.menuViewController = (AfterMinigameMenuViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of AfterMinigameMenuControllerImpl");
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.menuViewController;
    }

    @Override
    public void goNext() {
        // TODO Auto-generated method stub
    }

    @Override
    public void exit() {
        // TODO Auto-generated method stub
    }

    @Override
    public final void createMenu() {
        this.getViewFactory().createAfterMinigameMenu(this);
    }

}
