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
import utils.graphics.stagemanager.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private final StageManager<S> stageManager;
    private final DiceController dice;
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
        this.turnsNumber = turnsNumber;
        this.turn = 1;
        this.players = players;
        this.gameMap = gameMap;
        this.turnProgress = -1;
        this.playerTurnProgress = -1;
        this.playersIterator = players.iterator();
        this.currentPlayer = Optional.empty();
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
        this.playerTurnProgress++;
        if (this.playerTurnProgress > PlayerTurnProgress.END_OF_TURN.getProgress()) {
            this.playerTurnProgress = PlayerTurnProgress.SHOW_BANNER.getProgress();
        }
        if (this.playerTurnProgress == PlayerTurnProgress.SHOW_BANNER.getProgress()) {
            this.currentPlayer = Optional.of(this.playersIterator.next());
        }
        if (this.playerTurnProgress == PlayerTurnProgress.MOVE_PLAYER.getProgress()) {
            System.out.println(this.dice.getResult());
        }
        if (this.playerTurnProgress == PlayerTurnProgress.ROLL_DICE.getProgress()) {
            this.dice.start(this.currentPlayer.get());
        }
        return this.playerTurnProgress;
    }

    private boolean playersTurnsFinished() {
        return !(this.playersIterator.hasNext())
                && (this.playerTurnProgress == PlayerTurnProgress.END_OF_TURN.getProgress());
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
        this.turnProgress = 0;
        this.playerTurnProgress = -1;
        this.turn++;
    }

    @Override
    public final void playMinigame() {
        final MinigameController wrw = new WhoRisksWinsControllerImpl(this.stageManager, this.getPlayers());
        wrw.startGame();
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
}
