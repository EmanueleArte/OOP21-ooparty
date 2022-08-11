package minigames.common.controller;

import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

public abstract class MinigameGuideControllerAbstr extends GenericControllerAbstr implements MinigameGuideController {

    private GenericViewController guideViewController;

    public <S> MinigameGuideControllerAbstr(final StageManager<S> s) {
        super(s);
    }

    /**
     * Getter for view controller.
     * @return view controller
     */
    @Override
    public GenericViewController getViewController() {
        return this.guideViewController;
    }

    /**
     * Setter for view controller.
     * @param viewController
     */
    public void setViewController(final GenericViewController viewController) {
        this.guideViewController = viewController;
    }

}
