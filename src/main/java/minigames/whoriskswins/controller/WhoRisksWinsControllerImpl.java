package minigames.whoriskswins.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.whoriskswins.model.WhoRisksWinsModel;
import minigames.whoriskswins.view.WhoRisksWinsViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;
import utils.view.GenericViewUtils;

/**
 * Extension of {@link MinigameControllerAbstr} and implementation of
 * {@link WhoRisksWinsController}.
 */
public class WhoRisksWinsControllerImpl extends MinigameControllerAbstr implements WhoRisksWinsController {

    private final WhoRisksWinsModel wrwModel;
    private WhoRisksWinsViewController wrwViewController;

    /**
     * Builder for {@link WhoRisksWinsControllerImpl}.
     * 
     * @param <S>   the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link WhoRisksWinsModel}
     * @param dice  the {@link DiceController}
     */
    public <S> WhoRisksWinsControllerImpl(final StageManager<S> s, final WhoRisksWinsModel model,
            final DiceController dice) {
        super(s, dice);
        this.wrwModel = model;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) throws IllegalArgumentException {
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
        return this.wrwModel.getGameResults();
    }

    @Override
    public final void startGame() {
        this.getStageManager().getGui().getViewFactory().createWhoRisksWinsView(this);
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
