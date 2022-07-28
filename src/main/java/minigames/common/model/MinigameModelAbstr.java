package minigames.common.model;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import game.common.model.GameModelAbstr;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MinigameModel}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public abstract class MinigameModelAbstr<S, U> extends GameModelAbstr<S, U> implements MinigameModel<S, U> {

    private final Map<U, Integer> playersClassification;

    /**
     * Builds a new {@link MinigameModelAbstr}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public MinigameModelAbstr(final List<U> players, final StageManager<S> s) {
        super(players, s);
        this.playersClassification = new LinkedHashMap<>();
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
    public abstract boolean runGame();

    @Override
    public final List<U> gameResults() {

        return this.sortPlayersByScore();
    }

    @Override
    public final void scoreMapper(final U player, final Integer score) {
        this.playersClassification.put(player, score);
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

    @Override
    protected final void nextTurn() {
        if (this.hasNextPlayer()) {
            this.runGame();
        }
    }

}
