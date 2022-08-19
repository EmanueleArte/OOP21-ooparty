package menu.afterminigamemenu.controller;

import java.util.List;

import game.player.Player;
import menu.MenuController;
import menu.afterminigamemenu.view.AfterMinigameMenuViewController;
import menu.afterminigamemenu.view.AfterMinigameMenuViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class AfterMinigameMenuControllerImpl extends GenericControllerAbstr implements MenuController, AfterMinigameMenuController {

    private AfterMinigameMenuViewController menuViewController;

    /**
     * Builder for {@link AfterMinigameMenuControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> AfterMinigameMenuControllerImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof AfterMinigameMenuViewControllerImpl) {
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
    }

    @Override
    public final void exit() {
        if (!this.getStageManager().getScenes().isEmpty()) {
            this.getStageManager().popScene();
        }
    }

    @Override
    public final void createMenu() {
        this.getViewFactory().createAfterMinigameMenu(this);
    }

    @Override
    public final void makeLeaderboard(final List<Player> players) {
        this.menuViewController.makeLeaderboard(players);
    }

}
