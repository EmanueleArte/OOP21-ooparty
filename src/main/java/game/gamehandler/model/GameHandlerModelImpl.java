package game.gamehandler.model;

import java.util.List;

import game.dice.model.DiceModel;
import game.dice.model.DiceModelImpl;
import game.map.GameMap;
import game.map.GameMapSquare;
import game.map.GameMapSquareImpl;
import game.player.Player;
import utils.graphics.stagemanager.StageManager;

public class GameHandlerModelImpl<S> implements GameHandlerModel {

    private StageManager<S> stageManager;
    private final DiceModel<Player> dice;
    private final GameMap gameMap;

    private final int turnsNumber;
    private final List<Player> players;

    public GameHandlerModelImpl(final StageManager<S> s, final List<Player> players, final GameMap gameMap) {
        this.stageManager = s;
        this.dice = new DiceModelImpl<>();
        this.turnsNumber = 10;
        this.players = players;
        this.gameMap = gameMap;
    }

    @Override
    public void start() {
        this.gameMap.inizializePlayers(players);
        for (int turn = 1; turn <= turnsNumber; turn++) {
            System.out.println("Turno " + turn);
            players.forEach(p -> {
                playTurn(p);
            });
            playMinigame();
            showLeaderboard();
        }
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
}
