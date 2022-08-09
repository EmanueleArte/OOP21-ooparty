package game.map;

import java.util.List;

import exceptions.PlayerNotFoundException;
import game.map.factories.GameBoardFactory;
import game.map.factories.SimpleGameBoardFactory;
import game.player.Player;

public class GameMapImpl implements GameMap {
    private List<GameMapSquare> squares;
    /**
     * Number of coins required to buy a star.
     */
    public static final int COINS_TO_BUY_STAR = 50;

    public GameMapImpl() {
        GameBoardFactory f = new SimpleGameBoardFactory();
        this.squares = f.createGameBoard(10);
    }

    @Override
    public final List<GameMapSquare> getSquares() {
        return List.copyOf(this.squares);
    }

    @Override
    public final GameMapSquare getPlayerPosition(final Player p) {
        for (GameMapSquare b : this.squares) {
            if (b.getPlayers().stream().anyMatch(o -> o.equals(p))) {
                return b;
            }
        }
        throw new PlayerNotFoundException("Player not found in the game map");
    }

    @Override
    public final void inizializePlayers(final List<Player> players) {
        GameMapSquare firstSquare = this.getSquares().get(0);
        players.forEach(p -> firstSquare.addPlayer(p));
    }
}
