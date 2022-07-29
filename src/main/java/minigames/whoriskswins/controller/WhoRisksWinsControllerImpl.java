package minigames.whoriskswins.controller;

import java.util.List;

import minigames.whoriskswins.viewcontroller.WhoRisksWinsViewController;
import utils.GenericViewController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link WhoRisksWinsController}.
 */
public class WhoRisksWinsControllerImpl extends GenericControllerAbstr implements WhoRisksWinsController {

    private final WhoRisksWinsModel<?, ?> wrwModel;
    private WhoRisksWinsViewController wrwViewController;

    /**
     * Builder for {@link WhoRisksWinsControllerImpl}.
     * 
     * @param <S>     the scenes of the stage
     * @param <U>     the players
     * @param s       the {@link StageManager}
     * @param players the list of players
     */
    public <S, U> WhoRisksWinsControllerImpl(final StageManager<S> s, final List<U> players) {
        super(s);
        this.wrwModel = new WhoRisksWinsModelImpl<>(players, s);
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        this.wrwViewController = (WhoRisksWinsViewController) viewController;
    }

    @Override
    public final GenericViewController getViewController() {
        return this.wrwViewController;
    }

    @Override
    public final List<?> getGameResults() {
        return this.wrwModel.gameResults();
    }

    @Override
    public final void startGame() {
        // TODO Auto-generated method stub

    }

    @Override
    public final boolean nextTurn() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final void stopBlock(final int blockY, final int playerY) {
        // TODO Auto-generated method stub

    }

}
