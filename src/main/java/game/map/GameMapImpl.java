package game.map;

import java.util.List;

import exceptions.PlayerNotFoundException;
import game.player.Player;

public class GameMapImpl implements GameMap {
    private List<GameMapSquare> squares;
    /**
     * Number of coins required to buy a star.
     */
    public static final int COINS_TO_BUY_STAR = 50;

    public GameMapImpl(final List<GameMapSquare> squares) {
        //TODO generare mappa (qua viene passata ma non penso funzionerà così, bisognerà fare un metodo qua dentro che la crea)
        this.squares = squares;
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
}
