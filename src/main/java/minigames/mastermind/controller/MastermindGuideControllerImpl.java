package minigames.mastermind.controller;

import minigames.common.controller.MinigameGuideControllerAbstr;
import minigames.mastermind.viewcontroller.MastermindGuideViewControllerImpl;
import utils.graphics.stagemanager.StageManager;

public class MastermindGuideControllerImpl extends MinigameGuideControllerAbstr {

    private final MastermindController mastermindController;

    public MastermindGuideControllerImpl(final StageManager s, final MastermindController mastermindController) {
        super(s);
        this.mastermindController = mastermindController;
    }

    @Override
    public <C> void setViewController(final C viewController) {
        if (viewController instanceof MastermindGuideViewControllerImpl) {
            this.guideViewController = (MastermindGuideViewControllerImpl) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MastermindGuideViewControllerImpl");
        }
    }

    @Override
    public void startGame() {
        this.mastermindController.startGame();
    }

}
