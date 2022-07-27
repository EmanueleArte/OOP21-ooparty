package minigames.mastermind.controller;

import java.util.List;

import minigames.common.controller.MinigameController;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.model.MastermindModelImpl;
import minigames.mastermind.viewcontroller.MastermindViewController;
import utils.GenericViewController;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr}.
 */
public class MastermindControllerImpl extends MinigameControllerAbstr {

    private final MastermindModel<?, ?> mastermindModel;
    private MastermindViewController mastermindViewController;

    /**
     * Builder for {@link MastermindControllerImpl}.
     * 
     * @param <S>     the scenes of the stage
     * @param s       the {@link StageManager}
     * @param players the list of players
     */
    public <S, U> MastermindControllerImpl(final StageManager<S> s, final List<U> players) {
        super(s);
        this.mastermindModel = new MastermindModelImpl<>(players, s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {

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
