package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.dice.view.DiceViewControllerImpl;
import game.gamehandler.model.GameHandlerModel;
import game.gamehandler.model.GameHandlerModelImpl;
import game.gamehandler.view.GameHandlerViewControllerImpl;
import game.player.Player;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;
import utils.view.GenericViewController;

public class GameHandlerControllerImpl<S> extends GenericControllerAbstr
        implements GenericController, GameHandlerController {

    private GameHandlerViewControllerImpl viewController;
    private GameHandlerModel model;

    public GameHandlerControllerImpl(final StageManager<S> s, final List<Player> players, final int turnsNumber) {
        super(s);
        this.model = new GameHandlerModelImpl(s, players, turnsNumber, null);
    }

    @Override
    public final void start() {
        GenericViewUtils.createScene(this.getStageManager(), this, DiceViewControllerImpl.class, "game/game.fxml");
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof GameHandlerViewControllerImpl) {
            this.viewController = (GameHandlerViewControllerImpl) viewController;
            this.viewController.initialize(this.model.getPlayers());
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GameHandlerViewControllerImpl");
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final int nextStep() {
        return this.model.nextStep();
    }

    @Override
    public final int nextPlayerTurnStep() {
        return this.model.nextPlayerTurnStep();
    }

    @Override
    public final int getTurnNumber() {
        return this.model.getTurnNumber();
    }

    @Override
    public final Optional<Player> getCurrentPlayer() {
        return this.model.getCurrentPlayer();
    }

}
