package game.gamehandler.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import game.dice.model.DiceModel;
import game.map.GameMap;
import game.map.GameMapImpl;
import game.map.GameMapSquare;
import game.player.Player;
import minigames.common.model.MinigameModel;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;

/**
 * Implementation of the {@link GameHandlerModel} interface.
 */
public class GameHandlerModelImpl implements GameHandlerModel {

    private final DiceModel dice;
    private final GameMap gameMap;
    private Optional<MinigameModel> minigameModel = Optional.empty();

    private final int turnsNumber;
    private int turn;
    private TurnProgress turnProgress;
    private PlayerTurnProgress playerTurnProgress;
    private Optional<Player> currentPlayer;
    private List<Player> players;
    private Iterator<Player> playersIterator;

    /**
     * Constructor for this class.
     * 
     * @param dice        the {@link DiceModel} to use
     * @param players     the {@link List} of the players in the game
     * @param turnsNumber the duration of the game in turns
     */
    public GameHandlerModelImpl(final DiceModel dice, final List<Player> players, final int turnsNumber) {
        this.dice = dice;
        this.turnsNumber = turnsNumber;
        this.turn = 1;
        this.players = players;
        this.gameMap = new GameMapImpl();
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
        if (this.turnProgress == TurnProgress.END_OF_TURN) {
            this.startNewTurn();
            if (this.turn == this.turnsNumber + 1) {
                return Optional.empty();
            }
        }
        return Optional.of(this.turnProgress);
    }

    @Override
    public final Optional<PlayerTurnProgress> nextPlayerTurnStep() {
        this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        switch (this.playerTurnProgress) {
        case END_OF_TURN:
            if (this.playersTurnsFinished()) {
                break;
            }
            this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        case SHOW_BANNER:
            this.newPlayerTurn();
            break;
        case USE_POWERUP:
            if (this.getCurrentPlayer().isEmpty() || !this.getCurrentPlayer().get().getPowerupList().isEmpty()) {
                break;
            }
            this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        case ROLL_DICE:
            this.rollDices();
            break;
        case MOVE_PLAYER:
            this.movePlayer();
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
        if (this.currentPlayer.isPresent()) {
            final Player cp = this.currentPlayer.get();
            if (this.dice.getTotal() > 0) {
                cp.moveForward(this.dice.getTotal(), this.gameMap);
                final GameMapSquare playerPosition = cp.getPosition(this.gameMap);
                playerPosition.makeSpecialAction(cp);
            }
        }
    }

    private boolean playersTurnsFinished() {
        return !(this.playersIterator.hasNext()) && (this.playerTurnProgress == PlayerTurnProgress.END_OF_TURN);
    }

    private void startNewTurn() {
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
    public final void setPlayers(final List<Player> players) {
        this.players = players;
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

    @Override
    public final List<Player> getTurnOrder() {
        if (this.minigameModel.isPresent()) {
            return this.minigameModel.get().getGameResults();
        }
        return this.players;
    }
}
