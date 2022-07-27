package minigames.common.controller;

import java.util.List;

import utils.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MinigameController}.
 */
public abstract class MinigameControllerAbstr extends GenericControllerAbstr implements MinigameController {

    public <S> MinigameControllerAbstr(final StageManager<S> s) {
        super(s);
    }

    @Override
    public abstract List<?> getGameResults();

}
