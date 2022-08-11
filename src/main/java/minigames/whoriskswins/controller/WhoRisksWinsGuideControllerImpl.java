package minigames.whoriskswins.controller;

import minigames.common.controller.MinigameGuideControllerAbstr;
import minigames.common.viewcontroller.MinigameGuideViewControllerImpl;
import utils.graphics.stagemanager.StageManager;

public class WhoRisksWinsGuideControllerImpl extends MinigameGuideControllerAbstr {

    private final WhoRisksWinsController wrwController;

    public WhoRisksWinsGuideControllerImpl(final StageManager s, final WhoRisksWinsController wrwController) {
        super(s);
        this.wrwController = wrwController;
    }

    @Override
    public void startGame() {
        this.wrwController.startGame();
    }

    @Override
    public <C> void setViewController(final C viewController) {
        if (viewController instanceof MinigameGuideViewControllerImpl) {
            super.setViewController((MinigameGuideViewControllerImpl) viewController);
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MinigameGuideViewControllerImpl");
        }
    }

}
