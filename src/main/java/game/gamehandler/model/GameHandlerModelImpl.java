package game.gamehandler.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import game.map.GameMap;
import game.map.GameMapSquare;
import game.player.Player;
import menu.powerupmenu.controller.PowerupMenuController;
import menu.powerupmenu.controller.PowerupMenuControllerImpl;
import minigames.common.controller.MinigameController;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.factories.MinigameControllerFactoryImpl;
import utils.graphics.controller.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private final StageManager<S> stageManager;
    private final DiceController dice;
    private final MinigameControllerFactoryImpl<S> minigameFactory;
    private final PowerupMenuController powerupMenu;
    private final GameMap gameMap;
    private Optional<MinigameController> minigameController = Optional.empty();

    private final int turnsNumber;
    private int turn;
    private TurnProgress turnProgress;
    private PlayerTurnProgress playerTurnProgress;
    private Optional<Player> currentPlayer;
    private List<Player> players;
    private Iterator<Player> playersIterator;

    public GameHandlerModelImpl(final StageManager<S> s, final List<Player> players, final int turnsNumber,
            final GameMap gameMap) {
        this.stageManager = s;
        this.dice = new DiceControllerImpl(this.stageManager, false);
        this.minigameFactory = new MinigameControllerFactoryImpl<>(players, s);
        this.powerupMenu = new PowerupMenuControllerImpl(this.stageManager, players); // TODO da cambiare, non va bene
        this.turnsNumber = turnsNumber;
        this.turn = 1;
        this.players = players;
        this.gameMap = gameMap;
        this.turnProgress = TurnProgress.END_OF_TURN;
        this.playerTurnProgress = PlayerTurnProgress.END_OF_TURN;
        this.playersIterator = players.iterator();
        this.currentPlayer = Optional.empty();

        this.gameMap.initializePlayers(this.players);
    }

    @Override
    public final Optional<TurnProgress> nextStep() {
        if (this.turnProgress == TurnProgress.PLAYERS_TURNS) {
            if (!this.playersTurnsFinished()) {
                return Optional.of(this.turnProgress);
            }
            this.currentPlayer = Optional.empty();
        }
        this.turnProgress = TurnProgress.next(this.turnProgress);
        switch (this.turnProgress) {
        case END_OF_TURN:
            this.startNewTurn();
            if (this.turn == this.turnsNumber + 1) {
                this.endGame();
                return Optional.empty();
            }
            break;
        case PLAY_MINIGAME:
            this.playMinigame();
            break;
        default:
            break;
        }
        return Optional.of(this.turnProgress);
    }

    @Override
    public final Optional<PlayerTurnProgress> nextPlayerTurnStep() {
        this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        switch (this.playerTurnProgress) {
        case SHOW_BANNER:
            this.newPlayerTurn();
            break;
        case USE_POWERUP:
            this.powerupMenu();
            break;
        case MOVE_PLAYER:
            this.movePlayer();
            break;
        case ROLL_DICE:
            this.rollDices();
            break;
        default:
            break;
        }
        return Optional.of(this.playerTurnProgress);
    }

    private void newPlayerTurn() {
        this.currentPlayer = Optional.of(this.playersIterator.next());
        this.currentPlayer.get().setDicesNumber(1);
        this.dice.reset();
    }

    private void rollDices() {
        final Player cp = this.currentPlayer.get();
        for (int i = 0; i < cp.getDicesToRoll(); i++) {
            this.dice.rollDice(cp);
        }
    }

    private void movePlayer() {
        final Player cp = this.currentPlayer.get();
        if (this.dice.getTotal() > 0) {
            cp.moveForward(this.dice.getTotal(), this.gameMap);
            final GameMapSquare playerPosition = cp.getPosition(this.gameMap);
            if (playerPosition.isCoinsGameMapSquare()) {
                playerPosition.receiveCoins(cp);
            } else if (playerPosition.isDamageGameMapSquare()) {
                playerPosition.receiveDamage(cp);
                checkPlayerDeath(cp);
            } else if (playerPosition.isStarGameMapSquare()) {
                playerPosition.receiveStar(cp);
            } else if (playerPosition.isPowerUpGameMapSquare()) {
                playerPosition.receivePowerup(cp);
            }
        }
    }

    private void powerupMenu() {
        final Player cp = this.currentPlayer.get();
        if (cp.getPowerupList().isEmpty()) {
            this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        } else {
            this.powerupMenu.start(cp);
        }
    }

    private boolean playersTurnsFinished() {
        return !(this.playersIterator.hasNext()) && (this.playerTurnProgress == PlayerTurnProgress.END_OF_TURN);
    }

    private void playMinigame() {
        minigameController = Optional.of(this.minigameFactory.createRandomMinigameController());
        minigameController.get().startGame();
    }

    private void startNewTurn() {
        this.players = (List<Player>) this.stageManager.getLastGameController().getGameResults();
        this.playersIterator = players.iterator();
        this.turnProgress = TurnProgress.END_OF_TURN;
        this.playerTurnProgress = PlayerTurnProgress.END_OF_TURN;
        this.turn++;
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

    /**
     * This method returns the leaderboard. The leaderboard consist in a list of
     * players ordered by: - stars; - coins; - life points;
     * 
     * @return an ordered list of players
     */
    @Override
    public List<Player> getLeaderboard() {
        var tmp = new ArrayList<>(this.players);

        tmp.sort(new Comparator<Player>() {

            @Override
            public int compare(final Player o1, final Player o2) {
                if (o2.getStarsCount() != o1.getStarsCount()) {
                    return o2.getStarsCount() - o1.getStarsCount();
                } else if (o2.getCoinsCount() != o1.getCoinsCount()) {
                    return o2.getCoinsCount() - o1.getCoinsCount();
                }
                return o2.getLifePoints() - o1.getLifePoints();
            }
        });
        return tmp;
    }

    @Override
    public final void checkPlayerDeath(final Player p) {
        p.checkIfDeadAndRespawn(this.gameMap);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Player> getTurnOrder() {
        if (this.minigameController.isPresent()) {
            return this.minigameController.get().getGameResults();
        }
        return this.players;
    }
}
