package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.gamehandler.model.GameHandlerModel;
import game.gamehandler.model.GameHandlerModelImpl;
import game.gamehandler.view.GameHandlerViewImpl;
import game.gamehandler.viewcontroller.GameHandlerViewControllerImpl;
import game.player.Player;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.GenericViewController;
import utils.graphics.stagemanager.StageManager;
import utils.view.GenericView;

public class GameHandlerControllerImpl extends GenericControllerAbstr
        implements GenericController, GameHandlerController {

    private GameHandlerViewControllerImpl viewController;
    private GameHandlerModel model;

    public <S, U> GameHandlerControllerImpl(final StageManager<S> s, final List<U> players, final int turnsNumber) {
        super(s);
        this.model = new GameHandlerModelImpl(s, players, turnsNumber, null);
    }

    @Override
    public void start() {
        GameHandlerViewImpl view = new GameHandlerViewImpl(this.getStageManager());
        final GenericView<?> gameView = new GameHandlerViewImpl<>(this.getStageManager());
        gameView.createScene(this);
    }

    @Override
    public <C> void setViewController(final C viewController) {
        if (viewController instanceof GameHandlerViewControllerImpl) {
            this.viewController = (GameHandlerViewControllerImpl) viewController;
            this.viewController.initialize(this.model.getPlayers());
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GameHandlerViewControllerImpl");
        }
    }

    @Override
    public GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public int nextStep() {
        return this.model.nextStep();
    }

    @Override
    public int nextPlayerTurnStep() {
        return this.model.nextPlayerTurnStep();
    }

    @Override
    public int getTurnNumber() {
        return this.model.getTurnNumber();
    }

    @Override
    public Optional<Player> getCurrentPlayer() {
        return this.model.getCurrentPlayer();
    }

}
