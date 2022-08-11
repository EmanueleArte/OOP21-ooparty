package minigames.common.controller;

import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

public abstract class MinigameGuideControllerAbstr extends GenericControllerAbstr implements MinigameGuideController {

    protected GenericViewController guideViewController;

    public <S> MinigameGuideControllerAbstr(final StageManager<S> s) {
        super(s);
    }

    @Override
    public GenericViewController getViewController() {
        return this.guideViewController;
    }

}
