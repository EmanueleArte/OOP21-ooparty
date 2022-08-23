package minigames.common.controller;

import minigames.common.view.MinigameGuideViewControllerImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation for the controller of the minigame's guide.
 */
public class MinigameGuideControllerImpl extends GenericControllerAbstr implements MinigameGuideController {

    private GenericViewController guideViewController;

    /**
     * Builds a {@link MinigameGuideControllerImpl}.
     * 
     * @param <S>  the scenes of the stage
     * @param s    the {@link StageManager}
     */
    public <S> MinigameGuideControllerImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final void startMinigame() {
        if (!this.getStageManager().getScenes().isEmpty()) {
            this.getStageManager().popScene();
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.guideViewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) {
        if (viewController instanceof MinigameGuideViewControllerImpl) {
           this.guideViewController = (MinigameGuideViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideViewControllerImpl");
        }
    }

}
