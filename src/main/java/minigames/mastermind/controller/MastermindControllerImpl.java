package minigames.mastermind.controller;

import java.util.List;

import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.common.viewcontroller.MinigameGuideViewControllerImpl;
import minigames.mastermind.model.MastermindModel;
import minigames.mastermind.model.MastermindModelImpl;
import minigames.mastermind.viewcontroller.MastermindViewController;
import minigames.mastermind.viewcontroller.MastermindViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;

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
        //final GenericView<?> mastermindView = new MastermindViewImpl<>(this.getStageManager());
        //mastermindView.createScene(this);
        GenericViewUtils.createScene(this.getStageManager(), this, MastermindViewControllerImpl.class, "minigames/mastermind.fxml");
    }

    @Override
    public void openGame() {
        //final GenericView<?> mastermindGuideView = new MastermindGuideViewImpl<>(this.getStageManager());
        final GenericController controller = new MinigameGuideControllerImpl(this.getStageManager(), this);
        //mastermindGuideView.createScene(controller);
        GenericViewUtils.createScene(this.getStageManager(), controller, MinigameGuideViewControllerImpl.class, "minigames/mastermind_guide.fxml");
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
