package minigames.whoriskswins.controller;

import java.util.List;

import game.player.Player;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.whoriskswins.model.WhoRisksWinsModel;
import minigames.whoriskswins.model.WhoRisksWinsModelImpl;
import minigames.whoriskswins.view.WhoRisksWinsViewController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;
import utils.view.GenericViewUtils;

/**
 * Extension of {@link GenericControllerAbstr} and implementation of
 * {@link WhoRisksWinsController}.
 */
public class WhoRisksWinsControllerImpl extends GenericControllerAbstr implements WhoRisksWinsController {

    private final WhoRisksWinsModel<?> wrwModel;
    private WhoRisksWinsViewController wrwViewController;

    /**
     * Builder for {@link WhoRisksWinsControllerImpl}.
     * 
     * @param <S>     the scenes of the stage
     * @param s       the {@link StageManager}
     * @param players the list of players
     */
    public <S> WhoRisksWinsControllerImpl(final StageManager<S> s, final List<Player> players) {
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
    public final List<Player> getGameResults() {
        return this.wrwModel.gameResults();
    }

    @Override
    public final void startGame() {
        GenericViewUtils.createScene(this.getStageManager(), this, "minigames/who_risks_wins.fxml");
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager(), this);
        GenericViewUtils.createScene(this.getStageManager(), guideController, "minigames/who_risks_wins_guide.fxml");
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

}
