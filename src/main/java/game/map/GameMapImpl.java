package game.map;

import java.util.List;

import game.map.factories.GameBoardFactory;
import game.map.factories.SimpleGameBoardFactory;
import game.player.Player;
import utils.enums.MapLayout;
import utils.exceptions.PlayerNotFoundException;

public class GameMapImpl implements GameMap {

    private List<GameMapSquare> squares;
    private final MapLayout layout;

    /**
     * Number of coins required to buy a star.
     */
    public static final int COINS_TO_BUY_STAR = 50;

    public GameMapImpl() {
        GameBoardFactory f = new SimpleGameBoardFactory();
        this.squares = f.createGameBoard();
        this.layout = MapLayout.DEFAULT;
    }

    public GameMapImpl(final List<GameMapSquare> squares) {
        this.squares = squares;
        this.layout = MapLayout.DEFAULT;
    }

    public GameMapImpl(final MapLayout layout) {
        GameBoardFactory f = new SimpleGameBoardFactory();
        this.squares = f.createGameBoard();
        this.layout = layout;
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
    public final void initializePlayers(final List<Player> players) {
        GameMapSquare firstSquare = this.getSquares().get(0);
        players.forEach(p -> {
            if (!this.isPlayerAlreadyInGameMap(p)) {
                firstSquare.addPlayer(p);
            }
        });
    }

    private boolean isPlayerAlreadyInGameMap(final Player p) {
        for (GameMapSquare b : this.squares) {
            if (b.getPlayers().stream().anyMatch(o -> o.equals(p))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public MapLayout getLayout() {
        return this.layout;
    }
}
