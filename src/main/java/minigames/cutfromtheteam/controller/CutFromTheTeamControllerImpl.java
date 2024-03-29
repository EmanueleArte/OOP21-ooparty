package minigames.cutfromtheteam.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.cutfromtheteam.model.CutFromTheTeamModel;
import minigames.cutfromtheteam.model.CutFromTheTeamModelImpl;
import minigames.cutfromtheteam.view.CutFromTheTeamViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class CutFromTheTeamControllerImpl extends MinigameControllerAbstr implements CutFromTheTeamController {

    private final CutFromTheTeamModel cutFromTheTeamModel;
    private CutFromTheTeamViewController cutFromTheTeamView;

    public <S> CutFromTheTeamControllerImpl(final StageManager<S> stageManager, final CutFromTheTeamModelImpl model,
            final DiceController diceController) {
        super(stageManager, diceController);
        this.cutFromTheTeamModel = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getGameResults() {
        return this.cutFromTheTeamModel.getGameResults();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.getStageManager().getGui().getViewLoader().createCutFromTheTeamView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager());
        this.getStageManager().getGui().getViewLoader().createCutFromTheTeamGuideView(guideController);

        this.cutFromTheTeamView.start(this.cutFromTheTeamModel.getRopes());
        this.updateCurrentPlayerLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickRope(final Boolean ropeValue) {
        this.cutFromTheTeamModel.setRope(ropeValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextTurn() {
        var temp = this.cutFromTheTeamModel.runGame();
        if (this.isOver()) {
            this.cutFromTheTeamView.enableCloseButton();
        }
        return temp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setViewController(final GenericViewController viewController) {
        if (viewController instanceof CutFromTheTeamViewController) {
            this.cutFromTheTeamView = (CutFromTheTeamViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MemoViewController");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericViewController getViewController() {
        return this.cutFromTheTeamView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentPlayerLabel() {
        this.cutFromTheTeamView.setPlayerLabelText(this.cutFromTheTeamModel.getCurrPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return this.cutFromTheTeamModel.isOver();
    }

}
