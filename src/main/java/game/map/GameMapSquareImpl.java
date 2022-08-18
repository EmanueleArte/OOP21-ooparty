package game.map;

import java.util.HashSet;
import java.util.Set;

import game.player.Player;
import game.powerup.GenericPowerup;

/**
 * The implementation of a generic {@link GameMapSquare}.
 */
public class GameMapSquareImpl implements GameMapSquare {
    private Set<Player> players;

    /**
     * Maximum number of coins that can be found on a coin square.
     */
    public static final int MAX_COINS = 10;

    /**
     * Maximum number of damage that can be taken from a damage square.
     */
    public static final int MAX_DAMAGE = 50;

    public GameMapSquareImpl() {
        this.players = new HashSet<>();
    }

    /**
     *
     */
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
     * {@inheritDoc}
     */
    @Override
    public int getCoinsNumber() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveCoins(final Player p) {
        throw new UnsupportedOperationException("This is not a coins game map square");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveDamage(final Player p) {
        throw new UnsupportedOperationException("This is not a damage game map square");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receiveStar(final Player p) {
        throw new UnsupportedOperationException("This is not a star game map square");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receivePowerup(final Player p) {
        throw new UnsupportedOperationException("This is not a powerup game map square");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericPowerup getPowerup() {
        throw new UnsupportedOperationException("This is not a powerup game map square");
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
