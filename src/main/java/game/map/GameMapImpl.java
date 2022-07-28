package game.map;

import java.util.List;

import game.player.Player;

public class GameMapImpl implements GameMap {
    private List<GameMapSquare> squares;
    /**
     * Number of coins to buy a star.
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
        //TODO dovrebbe lanciare un'eccezione?
        return this.squares.get(0);
    }
}
