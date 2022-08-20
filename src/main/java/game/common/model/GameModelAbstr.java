package game.common.model;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import game.player.Player;

/**
 * Implementation of {@link GameModel}.
 */
public abstract class GameModelAbstr implements GameModel {

    private final List<Player> players;
    private ListIterator<Player> playerIterator;
    private Optional<Player> currPlayer;

    /**
     * Builds a new {@link GameModelAbstr}.
     * 
     * @param players the list of players
     */
    public GameModelAbstr(final List<Player> players) {
        this.players = players;
        this.setPlayerIterator(players);
        this.currPlayer = Optional.empty();
    }

    @Override
    public final List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public abstract boolean runGame();

    @Override
    public final Player getCurrPlayer() {
        return this.currPlayer.get();
    }

    /**
     * Getter for the next player.
     * 
     * @return the next player
     */
    protected Player getNextPlayer() {
        return this.playerIterator.next();
    }

    /**
     * This method controls if there is at least another player.
     * 
     * @return true if there is at least another player, false otherwise
     */
    protected boolean hasNextPlayer() {
        return this.playerIterator.hasNext();
    }

    /**
     * This method controls if exists the current player.
     * 
     * @return true if there exists a current player, false otherwise
     */
    protected boolean hasCurrPlayer() {
        return this.currPlayer.isPresent();
    }

    /**
     * Setter for the current player.
     */
    protected void setCurrPlayer() {
        if (this.hasNextPlayer()) {
            this.currPlayer = Optional.ofNullable(this.getNextPlayer());
        }
    }

    /**
     * Setter for playerIterator.
     * 
     * @param players the list of players
     */
    protected void setPlayerIterator(final List<Player> players) {
        this.playerIterator = players.listIterator();
    }

}
