package minigames.cutFromTheTeam.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.cutFromTheTeam.model.CutFromTheTeamModel;
import minigames.cutFromTheTeam.model.CutFromTheTeamModelImpl;
import minigames.cutFromTheTeam.view.CutFromTheTeamViewController;
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startGame() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextTurn() {
        // TODO Auto-generated method stub
        return false;
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

}
