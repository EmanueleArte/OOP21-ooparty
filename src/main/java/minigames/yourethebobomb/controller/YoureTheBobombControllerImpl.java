package minigames.yourethebobomb.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.yourethebobomb.model.YoureTheBobombModelImpl;
import minigames.yourethebobomb.view.YoureTheBobombViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class YoureTheBobombControllerImpl extends MinigameControllerAbstr implements YoureTheBobombController {

    private final YoureTheBobombModelImpl youreTheBobombModel;
    private YoureTheBobombViewController youreTheBobombView;

    public <S> YoureTheBobombControllerImpl(final StageManager<S> stageManager, final YoureTheBobombModelImpl model,
            final DiceController diceController) {
        super(stageManager, diceController);
        this.youreTheBobombModel = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getGameResults() {
        return this.youreTheBobombModel.getGameResults();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.getStageManager().getGui().getViewLoader().createYoureTheBobombView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager());
        this.getStageManager().getGui().getViewLoader().createYoureTheBobombGuideView(guideController);

        this.youreTheBobombView.start(this.youreTheBobombModel.getRopes());
        this.updateCurrentPlayerLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickRope(final Boolean ropeValue) {
        this.youreTheBobombModel.setRope(ropeValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextTurn() {
        var temp = this.youreTheBobombModel.runGame();
        if (this.isOver()) {
            this.youreTheBobombView.enableCloseButton();
        }
        return temp;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setViewController(final GenericViewController viewController) {
        if (viewController instanceof YoureTheBobombViewController) {
            this.youreTheBobombView = (YoureTheBobombViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of YoureTheBobombViewController");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericViewController getViewController() {
        return this.youreTheBobombView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentPlayerLabel() {
        this.youreTheBobombView.setPlayerLabelText(this.youreTheBobombModel.getCurrPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return this.youreTheBobombModel.isOver();
    }

}
