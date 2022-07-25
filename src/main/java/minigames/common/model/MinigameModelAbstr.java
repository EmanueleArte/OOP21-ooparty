package minigames.common.model;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MinigameModel}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the {@link game.player.Player}
 */
public abstract class MinigameModelAbstr<S, U> implements MinigameModel<S, U> {

    private final List<U> players;
    private final ListIterator<U> player;
    private final StageManager<S> stageManager;
    private final Map<U, Integer> playersClassification;
    private U currPlayer;

    /**
     * Builds a new {@link MinigameModelAbstr}.
     * 
     * @param players the list of players
     * @param s       the {@link utils.graphics.stagemanager.StageManager}
     */
    public MinigameModelAbstr(final List<U> players, final StageManager<S> s) {
        this.players = players;
        this.player = this.players.listIterator();
        this.playersClassification = new LinkedHashMap<>();
        this.stageManager = s;
    }

    public MinigameModelAbstr(final List<U> players) {
        this(players, null);
    }

    @Override
    public final Map<U, Integer> getPlayersClassification() {
        return this.playersClassification;
    }

    @Override
    public final void setPlayersClassification(final Map<U, Integer> playersClassification) {
        this.playersClassification.clear();
        this.playersClassification.putAll(playersClassification);
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
    public final List<U> gameResults() {

        return this.sortPlayersByScore();
    }

    @Override
    public final void scoreMapper(final U player, final Integer score) {
        this.playersClassification.put(player, score);
    }

    @Override
    public final U getCurrPlayer() {
        return this.currPlayer;
    }

    /**
     * This method manages the draws at the end of the minigame.
     * 
     * @return a list of players ordered by their classification in the minigame and
     *         draws already managed
     */
    private List<U> playoff() {
        return null;
    }

    /**
     * This method orders the list of players by their score (higher to lower).
     * 
     * @return a list of players ordered by their score
     */
    private List<U> sortPlayersByScore() {
        return this.playersClassification.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new))
                .keySet().stream().collect(Collectors.toList());
    }

    /**
     * Getter for the actual player.
     * 
     * @return the actual {@link game.player.Player}
     */
    protected U getNextPlayer() {
        return this.player.next();
    }

    /**
     * This method controls if there is at least another {@link game.player.Player}.
     * 
     * @return true if there is at least another player, false otherwise
     */
    protected boolean hasNextPlayer() {
        return this.player.hasNext();
    }

    /**
     * This method starts a new turn if there is another player who has to play.
     */
    protected void nextTurn() {
        if (this.hasNextPlayer()) {
            this.runGame();
        }
    }

    /**
     * Setter for the current player.
     */
    protected void setCurrPlayer() {
        if (this.hasNextPlayer()) {
            this.currPlayer = this.getNextPlayer();
        }
    }

}
