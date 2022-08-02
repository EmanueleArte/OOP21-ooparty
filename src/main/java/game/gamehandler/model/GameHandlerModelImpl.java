package game.gamehandler.model;

import java.util.Iterator;
import java.util.List;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.map.GameMap;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.player.Player;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private final StageManager<S> stageManager;
    private final DiceModel<Player> dice;
    private final GameMap gameMap;

    private final int turnsNumber;
    private int turn;
    private int turnProgress;
    /*
     * 0 = show banner 1 = hide banner 2 = player turns 3 = minigame 4 = leaderboard
     */
    private int playerTurnProgress;
    /*
     * 0 = show banner 1 = hide banner 2 = move
     */
    private Player currentPlayer;
    private final List<Player> players;
    private Iterator<Player> playersIterator;

    public GameHandlerModelImpl(final StageManager<S> s, final List<Player> players, final int turnsNumber,
            final GameMap gameMap) {
        this.stageManager = s;
        this.dice = new DiceModelImpl<>();
        this.turnsNumber = turnsNumber;
        this.turn = 0;
        this.players = players;
        this.gameMap = gameMap;
        this.startNewTurn();
    }

    @Override
    public int getTurnProgress() {
        return this.turnProgress;
    }

    @Override
    public int nextStep() {
        if (this.turnProgress == 5) {
            this.startNewTurn();
            if (this.turn == this.turnsNumber + 1) {
                this.endGame();
                return -1;
            }
        }
        if (this.turnProgress == 2) {
            if (!this.playersTurnsFinished()) {
                return this.getTurnProgress();
            }
            this.turnProgress++;
        }
        this.turnProgress++;
        return this.getTurnProgress() - 1;
    }

    @Override
    public int nextPlayerTurnStep() {
        if (this.playerTurnProgress == 3) {
            this.playerTurnProgress = 0;
        }
        if (this.playerTurnProgress == 0 && this.playersIterator.hasNext()) {
            this.currentPlayer = this.playersIterator.next();
        }
        this.playerTurnProgress++;
        return this.playerTurnProgress - 1;
    }

    private boolean playersTurnsFinished() {
        return !this.playersIterator.hasNext() && this.playerTurnProgress == 3;
    }

    @Override
    public void playTurn(final Player player) {
        System.out.println("Turno di " + player.getNickname() + " - posizione: " + player.getPosition(this.gameMap));
        int roll = dice.rollDice(player);
        System.out.println("Lancio del dado: " + roll);
        player.moveForward(roll, this.gameMap); // TODO moveForward è da fare
        GameMapSquare playerPosition = this.gameMap.getPlayerPosition(player);
        System.out.println("Nuova posizione: " + playerPosition);
        if (playerPosition.isCoinsGameMapSquare()) {
            playerPosition.receiveCoins(player);
        } else if (playerPosition.isDamageGameMapSquare()) {
            playerPosition.receiveDamage(player);
        } else if (playerPosition.isPowerUpGameMapSquare()) {
            // TODO
        } else if (playerPosition.isStarGameMapSquare()) {
            playerPosition.receiveStar(player);
        }
    }

    @Override
    public void startNewTurn() {
        this.playersIterator = players.iterator();
        this.turnProgress = 0;
        this.playerTurnProgress = 0;
        this.turn++;
    }

    @Override
    public void playMinigame() {
        System.out.println("Minigioco!");
    }

    @Override
    public void showLeaderboard() {
        System.out.println("Classifica");
    }

    @Override
    public List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public int getTurnNumber() {
        return this.turn;
    }

    @Override
    public String getCurrentPlayerName() {
        return this.currentPlayer.getNickname();
    }

    @Override
    public void endGame() {
        this.stageManager.popScene();
    }
}
