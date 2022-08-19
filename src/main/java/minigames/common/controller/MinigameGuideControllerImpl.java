package minigames.common.controller;

import minigames.common.view.MinigameGuideViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class MinigameGuideControllerImpl extends GenericControllerAbstr implements MinigameGuideController {

    private GenericViewController guideViewController;
    private final MinigameController minigameController;

    public MinigameGuideControllerImpl(final StageManager s, final MinigameController minigameController) {
        super(s);
        this.minigameController = minigameController;
    }

    @Override
    public void startGame() {
        if (!this.getStageManager().getScenes().isEmpty()) {
            this.getStageManager().popScene();
        }
    }

    @Override
    public GenericViewController getViewController() {
        return this.guideViewController;
    }

    @Override
    public void setViewController(final GenericViewController viewController) {
        if (viewController instanceof MinigameGuideViewControllerImpl) {
           this.guideViewController = (MinigameGuideViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideViewControllerImpl");
        }
    }

}
