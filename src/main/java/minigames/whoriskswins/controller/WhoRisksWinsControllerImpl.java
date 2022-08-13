package minigames.whoriskswins.controller;

import java.util.List;

import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.common.viewcontroller.MinigameGuideViewController;
import minigames.whoriskswins.model.WhoRisksWinsModel;
import minigames.whoriskswins.model.WhoRisksWinsModelImpl;
import minigames.whoriskswins.viewcontroller.WhoRisksWinsViewController;
import minigames.whoriskswins.viewcontroller.WhoRisksWinsViewControllerImpl;
import utils.GenericViewController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;

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
    public final <C> void setViewController(final C viewController) throws IllegalArgumentException {
        if (viewController instanceof WhoRisksWinsViewController) {
            this.wrwViewController = (WhoRisksWinsViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of WhoRisksWinsViewController");
        }
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
        //final GenericView<?> wrwView = new WhoRisksWinsViewImpl<>(this.getStageManager());
        //wrwView.createScene(this);
        GenericViewUtils.createScene(this.getStageManager(), this, WhoRisksWinsViewControllerImpl.class, "minigames/who_risks_wins.fxml");
    }

    @Override
    public final boolean nextTurn() {
        final boolean nextTurnExistence = this.wrwModel.runGame();
        if (nextTurnExistence) {
            final var currPlayer = this.wrwModel.getCurrPlayer();
            this.wrwViewController.setPlayerLabelText(currPlayer);
            this.wrwViewController.setPlayerAvatarColor(currPlayer);
        }
        return nextTurnExistence;
    }

    @Override
    public final void stopBlockFall(final double blockY, final double playerY) {
        this.wrwModel.stopBlockFall(blockY, playerY);
        this.wrwViewController.showTurnResults(this.wrwModel.getScore());
    }

    @Override
    public final int getFallingSpeed() {
        return this.wrwModel.getBlockFallingSpeed();
    }

    @Override
    public void openGame() {
        //final GenericView<?> wrwGuideView = new WhoRisksWinsGuideViewImpl<>(this.getStageManager());
        final GenericController controller = new MinigameGuideControllerImpl(this.getStageManager(), this);
        //wrwGuideView.createScene(controller);
        GenericViewUtils.createScene(this.getStageManager(), controller, MinigameGuideViewController.class, "minigames/who_risks_wins_guide.fxml");
    }

}
