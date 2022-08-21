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
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
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
    public final void nextStep() {
        Optional<TurnProgress> progress = this.model.nextStep();
        if (progress.isPresent()) {
            switch (progress.get()) {
            case SHOW_BANNER:
                this.viewController.showBanner("Turn " + this.model.getTurnNumber());
                break;
            case HIDE_BANNER:
                this.viewController.hideBanner();
                break;
            case PLAYERS_TURNS:
                Optional<PlayerTurnProgress> playerProgress = this.model.nextPlayerTurnStep();
                if (playerProgress.isPresent()) {
                    Player currentPlayer = this.model.getCurrentPlayer().get();
                    switch (playerProgress.get()) {
                    case SHOW_BANNER:
                        this.viewController.showBanner(this.model.getCurrentPlayer().get().getNickname() + "'s turn");
                        break;
                    case HIDE_BANNER:
                        this.viewController.hideBanner();
                        break;
                    case USE_POWERUP:
                        final PowerupMenuController powerupMenu = this.getStageManager().getControllerFactory()
                                .createPowerupMenuController(this.getPlayers());
                        powerupMenu.start(currentPlayer);
                        break;
                    case ROLL_DICE:
                        this.dice.start();
                        break;
                    case MOVE_PLAYER:
                        this.viewController.movePlayer(currentPlayer);
                        if (this.getGameMap().getPlayerPosition(currentPlayer).isCoinsGameMapSquare()) {
                            this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " earned "
                                    + currentPlayer.getLastEarnedCoins() + " coins!");
                        } else if (this.getGameMap().getPlayerPosition(currentPlayer).isDamageGameMapSquare()) {
                            if (!currentPlayer.isDead()) {
                                this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " lost "
                                        + currentPlayer.getLastDamageTaken() + " life points!");
                            } else {
                                this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " lost "
                                        + currentPlayer.getLastDamageTaken() + " life points! He died!");
                            }
                        } else if (this.getGameMap().getPlayerPosition(currentPlayer).isStarGameMapSquare()) {
                            if (currentPlayer.getIsLastStarEarned()) {
                                this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " earned a star!");
                            } else {
                                this.viewController.setUpdatesLabel(
                                        currentPlayer.getNickname() + " didn't have enough coins to buy a star!");
                            }
                        } else if (this.getGameMap().getPlayerPosition(currentPlayer).isPowerUpGameMapSquare()) {
                            this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " got a new powerup!");
                        }
                        boolean respawn = false;
                        if (currentPlayer.isDead()) {
                            respawn = true;
                            this.viewController.setUpdatesLabel(currentPlayer.getNickname() + " lost "
                                    + currentPlayer.getLastDamageTaken() + " life points! He died!");
                        }
                        System.out.println("Respawn: " + respawn);
                        this.checkPlayerDeath(currentPlayer);
                        if (respawn) {
                            this.viewController.movePlayer(currentPlayer);
                        }
                        this.viewController.updateLeaderboard(this.getLeaderboard());
                        break;
                    default:
                        break;
                    }
                }
                break;
            case PLAY_MINIGAME:
                this.viewController.setUpdatesLabel("");
                MinigameController minigameController = this.minigameFactory.createRandomMinigameController();
                minigameController.startGame();
                break;
            case SHOW_LEADERBOARD:
                this.model.setPlayers(this.getStageManager().getLastGameController().getGameResults());
                this.showAfterMinigameMenu();
                break;
            case END_OF_TURN:
                this.viewController.updateTurnOrder(this.model.getTurnOrder());
                this.viewController.updateLeaderboard(this.model.getLeaderboard());
                break;
            default:
                break;
            }
        } else {
            this.endGame();
        }
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
