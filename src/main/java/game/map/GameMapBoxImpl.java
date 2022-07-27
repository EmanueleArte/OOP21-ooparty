package game.map;

import java.util.HashSet;
import java.util.Set;

import game.player.Player;

public class GameMapBoxImpl implements GameMapBox {
    private Set<Player> players;

    /**
     * It's the maximum number of coins that can be found on a coin box.
     */
    public static final int MAX_COINS = 10;

    public GameMapBoxImpl() {
        this.players = new HashSet<>();
    }

    /**
     *
     */
    @Override
    public Set<Player> getPlayers() {
        return Set.copyOf(this.players);
    }

    /**
     * 
     */
    @Override
    public void addPlayer(final Player p) {
        this.players.add(p);
    }

    /**
     * 
     */
    @Override
    public void removePlayer(final Player p) {
        this.players.remove(p);
    }
}
