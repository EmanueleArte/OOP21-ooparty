package game.gamehandler.controller;

import java.util.List;
import java.util.Optional;

import game.dice.controller.DiceController;
import game.gamehandler.model.GameHandlerModel;
import game.map.GameMap;
import game.gamehandler.view.GameHandlerViewControllerImpl;
import game.player.Player;
import menu.afterminigamemenu.controller.AfterMinigameMenuControllerImpl;
import menu.pausemenu.controller.PauseMenuControllerImpl;
import minigames.common.controller.MinigameController;
import utils.controller.GenericController;
import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewUtils;
import utils.view.GenericViewController;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.factories.controller.MinigameControllerFactory;
import utils.factories.controller.MinigameControllerFactoryImpl;

public class GameHandlerControllerImpl extends GenericControllerAbstr
        implements GenericController, GameHandlerController {

    private GameHandlerViewControllerImpl viewController;
    private GameHandlerModel model;
    private DiceController dice;
    private final MinigameControllerFactory<?> minigameFactory;

    public <S> GameHandlerControllerImpl(final StageManager<S> s, final DiceController diceController,
            final GameHandlerModel model) {
        super(s);
        this.model = model;
        this.dice = diceController;
        this.minigameFactory = new MinigameControllerFactoryImpl<>(getPlayers(), s);
    }

    @Override
    public final void start() {
        GenericViewUtils.createScene(this.getStageManager(), this, "game/game.fxml");
    }

    @Override
    public final void setViewController(final GenericViewController viewController) {
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
        Optional<TurnProgress> turnProgress = this.model.nextStep();
        if (turnProgress.isPresent() && turnProgress.get() == TurnProgress.PLAY_MINIGAME) {
            MinigameController minigameController = this.minigameFactory.createRandomMinigameController();
            minigameController.startGame();
        }
        if (turnProgress.isPresent() && turnProgress.get() == TurnProgress.SHOW_LEADERBOARD) {
            this.model.setPlayers(this.getStageManager().getLastGameController().getGameResults());
        }
        return turnProgress;
    }

    @Override
    public final Optional<PlayerTurnProgress> nextPlayerTurnStep() {
        var nextPlayerTurnStep = this.model.nextPlayerTurnStep();
        if (nextPlayerTurnStep.isPresent() && nextPlayerTurnStep.get() == PlayerTurnProgress.ROLL_DICE) {
            this.dice.start();
        }
        return nextPlayerTurnStep;
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
    public final List<Player> getTurnOrder() {
        return this.model.getTurnOrder();
    }

    @Override
    public final void pauseMenu() {
        PauseMenuControllerImpl pauseMenuController = new PauseMenuControllerImpl(this.getStageManager());
        pauseMenuController.createMenu();
    }

    public final void checkPlayerDeath(final Player p) {
        this.model.checkPlayerDeath(p);
    }

    @Override
    public final void showAfterMinigameMenu() {
        AfterMinigameMenuControllerImpl afterMinigameMenuControllerImpl = new AfterMinigameMenuControllerImpl(
                this.getStageManager());
        afterMinigameMenuControllerImpl.createMenu();
        afterMinigameMenuControllerImpl.makeLeaderboard(this.getTurnOrder());
    }

    @Override
    public final void endGame() {
        this.getStageManager().popScene();
        AfterMinigameMenuControllerImpl afterMinigameMenuControllerImpl = new AfterMinigameMenuControllerImpl(
                this.getStageManager());
        afterMinigameMenuControllerImpl.createMenu();
        afterMinigameMenuControllerImpl.makeEndGameLeaderboard(this.getLeaderboard());
    }

}
