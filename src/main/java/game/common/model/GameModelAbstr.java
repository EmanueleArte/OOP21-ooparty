package game.common.model;

import java.util.List;
import java.util.ListIterator;

import game.player.Player;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link GameModel}.
 * 
 * @param <S> the scenes of the stage
 */
public abstract class GameModelAbstr<S> implements GameModel<S> {

    private final List<Player> players;
    private final StageManager<S> stageManager;
    private ListIterator<Player> playerIterator;
    private Player currPlayer;

    /**
     * Builds a new {@link GameModelAbstr}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public GameModelAbstr(final List<Player> players, final StageManager<S> s) {
        this.players = players;
        this.setPlayerIterator(players);
        this.stageManager = s;
    }

    /**
     * Builds a new {@link GameModelAbstr} with no {@link StageManager}.
     * 
     * @param players the list of players
     */
    public GameModelAbstr(final List<Player> players) {
        this(players, null);
    }

    @Override
    public final List<Player> getPlayers() {
        return this.players;
    }

    @Override
    public final StageManager<S> getStageManager() {
        return this.stageManager;
    }

    @Override
    public abstract boolean runGame();

    @Override
    public final Player getCurrPlayer() {
        return this.currPlayer;
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
     * Setter for the current player.
     */
    protected void setCurrPlayer() {
        if (this.hasNextPlayer()) {
            this.currPlayer = this.getNextPlayer();
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
