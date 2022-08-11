package minigames.mastermind.viewcontroller;

import javafx.fxml.FXML;
import minigames.common.controller.MinigameGuideController;
import minigames.common.viewcontroller.MinigameGuideViewController;
import utils.controller.GenericController;

public class MastermindGuideViewControllerImpl implements MinigameGuideViewController {

    private MinigameGuideController mastermindController;

    @FXML
    public void startMinigame() {
        this.mastermindController.startGame();
    }

    @Override
    public void setController(final GenericController controller) {
        if (controller instanceof MinigameGuideController) {
            this.mastermindController = (MinigameGuideController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MastermindGuideController");
        }
    }

}
