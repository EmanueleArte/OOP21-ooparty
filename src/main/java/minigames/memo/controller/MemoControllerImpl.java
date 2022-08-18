package minigames.memo.controller;

import java.util.List;

import game.player.Player;
import minigames.memo.model.MemoModel;
import minigames.memo.model.MemoModelImpl;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of {@link MemoController} and extension of
 * {@link GenericControllerAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MemoControllerImpl<S> extends GenericControllerAbstr implements MemoController {

    private final MemoModel<S> memoModel;

    public MemoControllerImpl(final StageManager<S> s, final List<Player> players) {
        super(s);
        this.memoModel = new MemoModelImpl<>(players, s);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getGameResults() {
        return this.memoModel.gameResults();
    }

    @Override
    public void startGame() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextTurn() {
        // TODO - view (scelta carte)
        this.memoModel.doNextTurn(0, 0);
        return !this.memoModel.isOver();
    }

    @Override
    public GenericViewController getViewController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C> void setViewController(final C viewController) {
        // TODO Auto-generated method stub

    }

}
