package minigames.common.viewcontroller;

import minigames.common.controller.MinigameGuideController;
import utils.controller.GenericController;

public class MinigameGuideViewControllerImpl implements MinigameGuideViewController {

    private MinigameGuideController minigameController;

    @Override
    public void setController(final GenericController controller) {
        if (controller instanceof MinigameGuideController) {
            this.minigameController = (MinigameGuideController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideController");
        }
    }

    @Override
    public void startMinigame() {
        this.minigameController.startGame();
    }

}
