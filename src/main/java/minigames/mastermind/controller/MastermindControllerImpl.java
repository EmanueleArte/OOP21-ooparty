package minigames.mastermind.controller;

import java.util.List;

import game.player.Player;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.model.MastermindModelImpl;
import minigames.mastermind.view.MastermindViewController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;
import utils.view.GenericViewUtils;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MastermindController}.
 */
public class MastermindControllerImpl extends GenericControllerAbstr implements MastermindController {

    private final MastermindModel<?> mastermindModel;
    private MastermindViewController mastermindViewController;

    /**
     * Builder for {@link MastermindControllerImpl}.
     * 
     * @param <S>     the scenes of the stage
     * @param s       the {@link StageManager}
     * @param players the list of players
     */
    public <S> MastermindControllerImpl(final StageManager<S> s, final List<Player> players) {
        super(s);
        this.mastermindModel = new MastermindModelImpl<>(players, s);
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
        return this.mastermindModel.gameResults();
    }

    @Override
    public final void startGame() {
        this.getStageManager().getGui().getViewFactory().createMastermindView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager(), this);
        GenericViewUtils.createScene(this.getStageManager(), guideController, "minigames/mastermind_guide.fxml");
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
