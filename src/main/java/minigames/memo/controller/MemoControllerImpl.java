package minigames.memo.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.memo.model.MemoModel;
import minigames.memo.view.MemoViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of {@link MemoController} and extension of
 * {@link GenericControllerAbstr}.
 */
public class MemoControllerImpl extends MinigameControllerAbstr implements MemoController {

    private final MemoModel memoModel;
    private MemoViewController memoView;

    /**
     * Builder for {@link MemoControllerImpl}.
     * 
     * @param <S>     the scenes of the stage.
     * @param s       the {@link StageManager}.
     * @param players the list of players.
     */
    public <S> MemoControllerImpl(final StageManager<S> s, final MemoModel model, final DiceController dice) {
        super(s, dice);
        this.memoModel = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getGameResults() {
        return this.memoModel.getGameResults();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.getStageManager().getGui().getViewFactory().createMemoView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager());
        this.getStageManager().getGui().getViewFactory().createMemoGuideView(guideController);

        this.memoView.start(this.memoModel.getCards());
        this.memoView.setPlayerLabelText(this.memoModel.getCurrPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentPlayerLabel() {
        this.memoView.setPlayerLabelText(this.memoModel.getCurrPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickCard(final int cardValue) {
        this.memoModel.setValue(cardValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericViewController getViewController() {
        return this.memoView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setViewController(final GenericViewController viewController) {
        if (viewController instanceof MemoViewController) {
            this.memoView = (MemoViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MemoViewController");
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @return true if the cards were a pair, therefore the player scored a point.
     */
    @Override
    public boolean nextTurn() {
        var temp = this.memoModel.runGame();
        if (this.isOver()) {
            System.out.println(this.memoModel.getPlayersClassification());
            this.closeGame();
        }
        return temp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return this.memoModel.isOver();
    }

}
