package minigames.common.controller;

import minigames.common.view.MinigameGuideViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;

public class MinigameGuideControllerImpl extends GenericControllerAbstr implements MinigameGuideController {

    private GenericViewController guideViewController;
    private final MinigameController minigameController;

    public MinigameGuideControllerImpl(final StageManager s, final MinigameController minigameController) {
        super(s);
        this.minigameController = minigameController;
    }

    @Override
    public void startGame() {
        minigameController.startGame();
    }

    @Override
    public GenericViewController getViewController() {
        return this.guideViewController;
    }

    @Override
    public <C> void setViewController(final C viewController) {
        if (viewController instanceof MinigameGuideViewControllerImpl) {
           this.guideViewController = (MinigameGuideViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideViewControllerImpl");
        }
    }

}
