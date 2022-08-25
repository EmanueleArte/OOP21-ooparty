package game.map;

import java.util.HashSet;
import java.util.Set;

import game.player.Player;
import game.player.PlayerImpl;

/**
 * The implementation of a generic {@link GameMapSquare}.
 */
public class GameMapSquareImpl implements GameMapSquare {
    private Set<Player> players;

    /**
     * Maximum number of coins that can be found on a coin square.
     */
    public static final int MAX_COINS = 20;

    /**
     * Maximum number of damage that can be taken from a damage square.
     */
    public static final int MAX_DAMAGE = PlayerImpl.MAX_LIFE / 2;

    /**
     * Builder for {@link GameMapSquareImpl}.
     */
    public GameMapSquareImpl() {
        this.players = new HashSet<>();
    }

    @Override
    public final Set<Player> getPlayers() {
        return Set.copyOf(this.players);
    }

    @Override
    public final void addPlayer(final Player p) {
        this.players.add(p);
    }

    @Override
    public final void removePlayer(final Player p) {
        this.players.remove(p);
    }

    /**
     * This method doesn't do anything because this is not a special game square.
     */
    @Override
    public void makeSpecialAction(final Player p) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCoinsGameMapSquare() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isStarGameMapSquare() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isPowerUpGameMapSquare() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDamageGameMapSquare() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GameMapSquare []";
    }


}
