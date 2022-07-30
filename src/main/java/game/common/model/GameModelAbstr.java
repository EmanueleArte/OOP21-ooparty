package game.common.model;

import java.util.List;
import java.util.ListIterator;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link GameModel}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public abstract class GameModelAbstr<S, U> implements GameModel<S, U> {

    private final List<U> players;
    private final StageManager<S> stageManager;
    private ListIterator<U> playerIterator;
    private U currPlayer;

    /**
     * Builds a new {@link GameModelAbstr}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public GameModelAbstr(final List<U> players, final StageManager<S> s) {
        this.players = players;
        this.setPlayerIterator(players);
        this.stageManager = s;
    }

    public GameModelAbstr(final List<U> players) {
        this(players, null);
    }

    @Override
    public final List<U> getPlayers() {
        return this.players;
    }

    @Override
    public final StageManager<S> getStageManager() {
        return this.stageManager;
    }

    @Override
    public abstract boolean runGame();

    @Override
    public final U getCurrPlayer() {
        return this.currPlayer;
    }

    /**
     * Getter for the next player.
     * 
     * @return the next player
     */
    protected U getNextPlayer() {
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
     * This method starts a new turn if there is another player who has to play.
     */
    protected abstract void nextTurn();

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
     */
    protected void setPlayerIterator(final List<U> players) {
        this.playerIterator = players.listIterator();
    }

}
