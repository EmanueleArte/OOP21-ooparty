package minigames.mastermind.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.view.MastermindViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Extension of {@link MinigameControllerAbstr} and implementation of
 * {@link MastermindController}.
 */
public class MastermindControllerImpl extends MinigameControllerAbstr implements MastermindController {

    private final MastermindModel mastermindModel;
    private MastermindViewController mastermindViewController;

    /**
     * Builder for {@link MastermindControllerImpl}.
     *
     * @param <S>   the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link MastermindModel}
     * @param dice  the {@link DiceController}
     */
    public <S> MastermindControllerImpl(final StageManager<S> s, final MastermindModel model,
            final DiceController dice) {
        super(s, dice);
        this.mastermindModel = model;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) throws IllegalArgumentException {
        if (viewController instanceof MastermindViewController) {
            this.mastermindViewController = (MastermindViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MastermindViewController");
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.mastermindViewController;
    }

    @Override
    public final List<Player> getGameResults() {
        return this.mastermindModel.getGameResults();
    }

    @Override
    public final void startGame() {
        this.getStageManager().getGui().getViewLoader().createMastermindView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager());
        this.getStageManager().getGui().getViewLoader().createMastermindGuideView(guideController);
    }

    @Override
    public final void setMaxAttempts(final int maxAttempts) {
        this.mastermindModel.setMaxAttempts(maxAttempts);
    }

    @Override
    public final boolean nextTurn() {
        final boolean nextTurnExistence = this.mastermindModel.runGame();
        if (nextTurnExistence) {
            this.mastermindViewController.setPlayerLabelText(this.mastermindModel.getCurrPlayer());
        }
        return nextTurnExistence;
    }

    @Override
    public final void doAttempt(final String attempt) {
        final String attemptDone = this.mastermindModel.doAttempt(attempt);
        this.mastermindViewController.showAttemptDone(attemptDone);
        this.mastermindViewController.showTurnResults(this.mastermindModel.getWin(), this.mastermindModel.getLose(),
                this.mastermindModel.getScore(), this.mastermindModel.getSolution(),
                this.mastermindModel.getNAttempts());
    }

}
