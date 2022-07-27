package minigames.mastermind.controller;

import java.util.List;

import menu.mainmenu.model.MainMenuModel;
import minigames.common.controller.MinigameController;
import utils.GenericControllerAbstr;
import utils.GenericViewController;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of {@link MinigameController}.
 */
public class MastermindControllerImpl extends GenericControllerAbstr implements MinigameController {

    private final MainMenuModel<?> mastermindModel;
    private GenericViewController mastermindViewController;

    /**
     * Builder for {@link MastermindControllerImpl}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public MastermindControllerImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        // TODO Auto-generated method stub

    }

    @Override
    public final GenericViewController getViewController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final List<?> getGameResults() {
        // TODO Auto-generated method stub
        return null;
    }

}
