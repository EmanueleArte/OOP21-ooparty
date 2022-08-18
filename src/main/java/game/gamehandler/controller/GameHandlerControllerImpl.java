package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.dice.view.DiceViewControllerImpl;
import game.gamehandler.model.GameHandlerModel;
import game.gamehandler.model.GameHandlerModelImpl;
import game.map.GameMap;
import game.gamehandler.view.GameHandlerViewControllerImpl;
import game.player.Player;
import menu.pausemenu.controller.PauseMenuControllerImpl;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;
import utils.view.GenericViewController;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;

public class GameHandlerControllerImpl<S> extends GenericControllerAbstr
        implements GenericController, GameHandlerController {

    private GameHandlerViewControllerImpl viewController;
    private GameHandlerModel model;

    public <S, U> GameHandlerControllerImpl(final StageManager<S> s, final List<U> players, final int turnsNumber,
            final GameMap gameMap) {
        super(s);
        this.model = new GameHandlerModelImpl(s, players, turnsNumber, gameMap);
    }

    @Override
    public final void start() {
        GenericViewUtils.createScene(this.getStageManager(), this, "game/game.fxml");
    }

    @Override
    public final <C> void setViewController(final C viewController) {
        if (viewController instanceof GameHandlerViewControllerImpl) {
            this.viewController = (GameHandlerViewControllerImpl) viewController;
            this.viewController.initialize(this.model.getPlayers(), this);
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GameHandlerViewControllerImpl");
        }
    }

    @Override
    public final GenericViewController getViewController() {
        return this.viewController;
    }

    @Override
    public final Optional<TurnProgress> nextStep() {
        return this.model.nextStep();
    }

    @Override
    public final Optional<PlayerTurnProgress> nextPlayerTurnStep() {
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

    @Override
    public final GameMap getGameMap() {
        return this.model.getGameMap();
    }

    @Override
    public final List<Player> getPlayers() {
        return this.model.getPlayers();
    }

    @Override
    public final List<Player> getLeaderboard() {
        return this.model.getLeaderboard();
    }

    @Override
    public final void pauseMenu() {
        PauseMenuControllerImpl pauseMenuController = new PauseMenuControllerImpl(this.getStageManager());
        pauseMenuController.createMenu();
    }

}
