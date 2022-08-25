package minigames.yourethebobomb.controller;

import java.util.List;

import game.dice.controller.DiceController;
import game.player.Player;
import minigames.common.controller.MinigameControllerAbstr;
import minigames.common.controller.MinigameGuideControllerImpl;
import minigames.yourethebobomb.model.YoureTheBobombModel;
import minigames.yourethebobomb.view.YoureTheBobombViewController;
import utils.controller.GenericController;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Implementation of {@link YoureTheBobombController} and extension of
 * {@link MinigameControllerAbstr}.
 */
public class YoureTheBobombControllerImpl extends MinigameControllerAbstr implements YoureTheBobombController {

    private final YoureTheBobombModel model;
    private YoureTheBobombViewController view;

    /**
     * Builds a new {@link YoureTheBobombControllerImpl}.
     *
     * @param <S>   the scenes of the stage
     * @param s     the {@link StageManager}
     * @param model the {@link YoureTheBobombModel}
     * @param dice  the {@link DiceController}
     */
    public <S> YoureTheBobombControllerImpl(final StageManager<S> s, final YoureTheBobombModel model,
            final DiceController dice) {
        super(s, dice);
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCurrentPlayerLabel() {
        this.view.setPlayerLabelText(this.model.getCurrPlayer());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pickTile(final int tile) {
        this.view.putPlayerIntoTile(this.model.getCurrPlayer().getNickname(), tile);
        if (this.model.chooseTile(tile)) {
            return;
        }
        if (this.model.runGame()) {
            this.setView();
            return;
        }
        this.setView();
        this.view.enableCloseButton();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getGameResults() {
        return this.model.getGameResults();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.getStageManager().getGui().getViewLoader().createYoureTheBobombView(this);
        final GenericController guideController = new MinigameGuideControllerImpl(this.getStageManager());
        this.getStageManager().getGui().getViewLoader().createYoureTheBobombGuideView(guideController);
        this.setView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean nextTurn() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setViewController(final GenericViewController viewController) {
        if (viewController instanceof YoureTheBobombViewController) {
            this.view = (YoureTheBobombViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of YoureTheBobombViewController");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericViewController getViewController() {
        return this.view;
    }

    private void setView() {
        this.view.start(this.model.getTiles());
    }

}
