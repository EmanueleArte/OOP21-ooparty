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
import minigames.common.controller.MinigameController;
import minigames.whoriskswins.controller.WhoRisksWinsControllerImpl;
import utils.enums.PlayerTurnProgress;
import utils.enums.TurnProgress;
import utils.factories.MinigameFactoryImpl;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private final StageManager<S> stageManager;
    private final DiceController dice;
    private final MinigameFactoryImpl<S, ?> minigameFactory;
    private final GameMap gameMap;

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
        this.minigameFactory = new MinigameFactoryImpl<>(players, s);
        this.turnsNumber = turnsNumber;
        this.turn = 1;
        this.players = players;
        this.gameMap = gameMap;
        this.turnProgress = TurnProgress.END_OF_TURN;
        this.playerTurnProgress = PlayerTurnProgress.END_OF_TURN;
        this.playersIterator = players.iterator();
        this.currentPlayer = Optional.empty();

        this.gameMap.inizializePlayers(this.players);
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
                this.endGame();
                return Optional.empty();
            }
        }
        if (this.turnProgress == TurnProgress.PLAY_MINIGAME) {
            this.playMinigame();
        }
        return Optional.of(this.turnProgress);
    }

    @Override
    public final Optional<PlayerTurnProgress> nextPlayerTurnStep() {
        this.playerTurnProgress = PlayerTurnProgress.next(this.playerTurnProgress);
        if (this.playerTurnProgress == PlayerTurnProgress.SHOW_BANNER) {
            this.currentPlayer = Optional.of(this.playersIterator.next());
        }
        if (this.playerTurnProgress == PlayerTurnProgress.MOVE_PLAYER) {
            System.out.println(this.dice.getLastResult());
        }
        if (this.playerTurnProgress == PlayerTurnProgress.ROLL_DICE) {
            this.dice.rollDice();
            this.dice.start(this.currentPlayer.get());
        }
        return Optional.of(this.playerTurnProgress);
    }

    private boolean playersTurnsFinished() {
        return !(this.playersIterator.hasNext())
                && (this.playerTurnProgress == PlayerTurnProgress.END_OF_TURN);
    }

    @Override
    public void playTurn(final Player player) {
        /*
         * System.out.println("Turno di " + player.getNickname() + " - posizione: " +
         * player.getPosition(this.gameMap)); int roll = dice.rollDice(player);
         * System.out.println("Lancio del dado: " + roll); player.moveForward(roll,
         * this.gameMap); // TODO moveForward è da fare GameMapSquare playerPosition =
         * this.gameMap.getPlayerPosition(player);
         * System.out.println("Nuova posizione: " + playerPosition); if
         * (playerPosition.isCoinsGameMapSquare()) {
         * playerPosition.receiveCoins(player); } else if
         * (playerPosition.isDamageGameMapSquare()) {
         * playerPosition.receiveDamage(player); } else if
         * (playerPosition.isPowerUpGameMapSquare()) { // TODO } else if
         * (playerPosition.isStarGameMapSquare()) { playerPosition.receiveStar(player);
         * }
         */
    }

    @SuppressWarnings("unchecked")
    private void startNewTurn() {
        this.players = (List<Player>) this.stageManager.getLastGameController().getGameResults();
        this.playersIterator = players.iterator();
        this.turnProgress = TurnProgress.SHOW_BANNER;
        this.playerTurnProgress = PlayerTurnProgress.SHOW_BANNER;
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
