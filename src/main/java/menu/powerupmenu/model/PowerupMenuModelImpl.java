package menu.powerupmenu.model;

import java.util.List;
import java.util.Optional;

import game.player.Player;

/**
 * Implementation of the {@link PowerupMenuModel} interface.
 */
public class PowerupMenuModelImpl implements PowerupMenuModel {
    private final List<Player> players;
    private Optional<Player> currentPlayer;

    /**
     * Constructor for this class.
     * 
     * @param players the {@link List} of players in the game
     */
    public PowerupMenuModelImpl(final List<Player> players) {
        this.players = players;
    }

    @Override
    public final List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public final void setCurrentPlayer(final Player currentPlayer) {
        this.currentPlayer = Optional.of(currentPlayer);
    }

    @Override
    public final Optional<Player> getCurrentPlayer() {
        return this.currentPlayer;
    }
}
