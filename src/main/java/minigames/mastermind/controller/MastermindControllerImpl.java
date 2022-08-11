package minigames.mastermind.controller;

import java.util.List;

import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.model.MastermindModelImpl;
import minigames.mastermind.view.MastermindGuideViewImpl;
import minigames.mastermind.view.MastermindViewImpl;
import minigames.mastermind.viewcontroller.MastermindViewController;
import utils.GenericViewController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericView;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link MastermindController}.
 */
public class MastermindControllerImpl extends GenericControllerAbstr implements MastermindController {

    private final MastermindModel<?, ?> mastermindModel;
    private MastermindViewController mastermindViewController;

    /**
     * Builder for {@link MastermindControllerImpl}.
     * 
     * @param <S>     the scenes of the stage
     * @param <U>     the players
     * @param s       the {@link StageManager}
     * @param players the list of players
     */
    public <S, U> MastermindControllerImpl(final StageManager<S> s, final List<U> players) {
        super(s);
        this.mastermindModel = new MastermindModelImpl<>(players, s);
    }

    @Override
    public final <C> void setViewController(final C viewController) throws IllegalArgumentException {
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
    public final List<?> getGameResults() {
        return this.mastermindModel.gameResults();
    }

    @Override
    public final void startGame() {
        final GenericView<?> mastermindView = new MastermindViewImpl<>(this.getStageManager());
        mastermindView.createScene(this);
    }

    @Override
    public void openGame() {
        final GenericView<?> mastermindGuideView = new MastermindGuideViewImpl<>(this.getStageManager());
        final GenericController controller = new MastermindGuideControllerImpl(this.getStageManager(), this);
        mastermindGuideView.createScene(controller);
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
