package menu.afterminigamemenu.controller;

import menu.MenuController;
import menu.gamecreationmenu.view.GameCreationMenuViewController;
import menu.gamecreationmenu.view.GameCreationMenuViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class AfterMinigameMenuControllerImpl extends GenericControllerAbstr implements MenuController {

    private GameCreationMenuViewController menuViewController;

    /**
     * Builder for {@link AfterMinigameMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> AfterMinigameMenuControllerImpl(final StageManager<S> s) {
        super(s);
        // TODO Auto-generated constructor stub
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof AfterMinigameMenuControllerImpl) {
            this.menuViewController = (GameCreationMenuViewControllerImpl) viewController;
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
        this.getViewFactory().createMainMenuView(this);
    }

}
