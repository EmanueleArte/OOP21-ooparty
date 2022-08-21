package minigames.common.view;

import minigames.common.controller.MinigameGuideController;
import utils.controller.GenericController;

/**
 * Implementation for the view controller of the minigame's guide.
 */
public class MinigameGuideViewControllerImpl implements MinigameGuideViewController {

    private MinigameGuideController minigameController;

    @Override
    public final void setController(final GenericController controller) {
        if (controller instanceof MinigameGuideController) {
            this.minigameController = (MinigameGuideController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideController");
        }
    }

    @Override
    public final void startMinigame() {
        this.minigameController.startGame();
    }

}
