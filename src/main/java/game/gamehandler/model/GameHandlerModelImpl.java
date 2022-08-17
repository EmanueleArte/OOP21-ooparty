package game.gamehandler.model;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import game.map.GameMap;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.player.Player;
import game.powerupmenu.controller.PowerupMenuController;
import game.powerupmenu.controller.PowerupMenuControllerImpl;
import minigames.common.controller.MinigameController;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.factories.MinigameFactoryImpl;
import utils.graphics.controller.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private final StageManager<S> stageManager;
    private final DiceController dice;
    private final PowerupMenuController powerupMenu;
    private final MinigameFactoryImpl<S> minigameFactory;
    private final GameMap gameMap;

    private final int turnsNumber;
    private int turn;
    private int turnProgress;
    private int playerTurnProgress;
    private Optional<Player> currentPlayer;
    private List<Player> players;
    private Iterator<Player> playersIterator;

    public GameHandlerModelImpl(final StageManager<S> s, final List<Player> players, final int turnsNumber,
            final GameMap gameMap) {
        this.stageManager = s;
        this.dice = new DiceControllerImpl(this.stageManager, false);
        this.powerupMenu = new PowerupMenuControllerImpl(this.stageManager);
        this.minigameFactory = new MinigameFactoryImpl<>(players, s);
        this.turnsNumber = turnsNumber;
        this.turn = 1;
        this.players = players;
        this.gameMap = gameMap;
        this.turnProgress = -1;
        this.playerTurnProgress = -1;
        this.playersIterator = players.iterator();
        this.currentPlayer = Optional.empty();

        this.gameMap.initializePlayers(this.players);
    }

    @Override
    public final int nextStep() {
        if (this.turnProgress == TurnProgress.PLAYERS_TURNS.getProgress()) {
            if (!this.playersTurnsFinished()) {
                return this.turnProgress;
            }
            this.currentPlayer = Optional.empty();
        }
        this.turnProgress++;
        if (this.turnProgress == TurnProgress.END_OF_TURN.getProgress()) {
            this.startNewTurn();
            if (this.turn == this.turnsNumber + 1) {
                this.endGame();
                return -1;
            }
        }
        if (this.turnProgress == TurnProgress.PLAY_MINIGAME.getProgress()) {
            this.playMinigame();
        }
        return this.turnProgress;
    }

    @Override
    public final int nextPlayerTurnStep() {
        if (this.playerTurnProgress == PlayerTurnProgress.ROLL_DICE.getProgress()) {
            if (this.currentPlayer.get().hasDiceToRoll()) {
                this.playerTurnProgress--;
            }
        }
        this.playerTurnProgress++;
        if (this.playerTurnProgress > PlayerTurnProgress.END_OF_TURN.getProgress()) {
            this.playerTurnProgress = PlayerTurnProgress.SHOW_BANNER.getProgress();
        }
        if (this.playerTurnProgress == PlayerTurnProgress.SHOW_BANNER.getProgress()) {
            this.currentPlayer = Optional.of(this.playersIterator.next());
            this.currentPlayer.get().setDicesNumber(1);
        }
        if (this.playerTurnProgress == PlayerTurnProgress.USE_POWERUP.getProgress()) {
            if (this.currentPlayer.get().getPowerupList().isEmpty()) {
                this.powerupMenu.start();
                //this.playerTurnProgress++;
            } else {
                this.powerupMenu.start();
            }
        }
        if (this.playerTurnProgress == PlayerTurnProgress.MOVE_PLAYER.getProgress()) {
            final Player cp = this.currentPlayer.get();
            System.out.println(this.dice.getLastResult());
            if (this.dice.getLastResult().isPresent()) {
                cp.moveForward(this.dice.getLastResult().get(), this.gameMap);
                final GameMapSquare playerPosition = cp.getPosition(this.gameMap);
                if (playerPosition.isCoinsGameMapSquare()) {
                    playerPosition.receiveCoins(cp);
                } else if (playerPosition.isDamageGameMapSquare()) {
                    playerPosition.receiveDamage(cp, this.gameMap);
                } else if (playerPosition.isStarGameMapSquare()) {
                    playerPosition.receiveStar(cp);
                } else if (playerPosition.isPowerUpGameMapSquare()) {
                    playerPosition.receivePowerup(cp);
                }
            }
        }
        if (this.playerTurnProgress == PlayerTurnProgress.ROLL_DICE.getProgress()) {
            if (this.currentPlayer.get().hasDiceToRoll()) {
                this.dice.rollDice();
                this.currentPlayer.get().rollDice();
                this.dice.start(this.currentPlayer.get());
            }
        }
        return this.playerTurnProgress;
    }

    private boolean playersTurnsFinished() {
        return !(this.playersIterator.hasNext())
                && (this.playerTurnProgress == PlayerTurnProgress.END_OF_TURN.getProgress());
    }

    @SuppressWarnings("unchecked")
    private void startNewTurn() {
        this.players = (List<Player>) this.stageManager.getLastGameController().getGameResults();
        this.playersIterator = players.iterator();
        this.turnProgress = 0;
        this.playerTurnProgress = -1;
        this.turn++;
    }

    @Override
    public final void playMinigame() {
        final MinigameController minigameController = this.minigameFactory.createRandomMinigameController();
        minigameController.startGame();
    }

    @Override
    public final List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public final int getTurnNumber() {
        return this.turn;
    }

    @Override
    public final Optional<Player> getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public final void endGame() {
        this.stageManager.popScene();
    }

    @Override
    public final GameMap getGameMap() {
        return this.gameMap;
    }
}
