package minigames.common.model;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import game.common.model.GameModelAbstr;
import game.dice.controller.DiceController;
import game.dice.controller.DiceControllerImpl;
import game.player.Player;
import utils.graphics.stagemanager.StageManager;

/**
 * Implementation of {@link MinigameModel}.
 * 
 * @param <S> the scenes of the stage
 * @param <U> the players
 */
public abstract class MinigameModelAbstr<S, U> extends GameModelAbstr<S, U> implements MinigameModel<S, U> {

    private final Map<U, Integer> playersClassification;
    private final DiceController dice;
    private int score;

    /**
     * Builds a new {@link MinigameModelAbstr}.
     * 
     * @param players the list of players
     * @param s       the {@link StageManager}
     */
    public MinigameModelAbstr(final List<U> players, final StageManager<S> s) {
        super(players, s);
        this.playersClassification = new LinkedHashMap<>();
        this.dice = new DiceControllerImpl(s, true);
    }

    /**
     * Builds a new {@link MinigameModelAbstr} with no {@link StageManager}.
     * 
     * @param players the list of players
     */
    public MinigameModelAbstr(final List<U> players) {
        this(players, null);
    }

    @Override
    public final Map<U, Integer> getPlayersClassification() {
        return this.playersClassification;
    }

    @Override
    public abstract boolean runGame();

    @Override
    public final List<U> gameResults() {
        return this.playoff(this.groupPlayersByScore());
    }

    @Override
    public final void scoreMapper(final U player, final Integer score) {
        this.playersClassification.put(player, score);
    }

    @Override
    public final int getScore() {
        return this.score;
    }

    /**
     * This method manages the draws at the end of the minigame.
     * 
     * @param scoreGroups the players grouped by score
     * @return a list of players ordered by their classification in the minigame and
     *         draws already managed
     */
    private List<U> playoff(final Map<Integer, List<U>> scoreGroups) {
        scoreGroups.entrySet().forEach(element -> {
            List<U> players = element.getValue();
            if (players.size() > 1) {
                final Map<U, Integer> sorted = new LinkedHashMap<>();
                players.forEach(player -> {
                    if (this.getStageManager().getGui().getMainStage().isPresent()) {
                        this.dice.start((Player) player);
                    } else {
                        this.dice.rollDice();
                    }
                    sorted.put(player, this.dice.getResult());
                });
                players = sorted.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y,
                                LinkedHashMap::new))
                        .keySet().stream().collect(Collectors.toList());
                element.setValue(players);
            }
        });
        return scoreGroups.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }

    /**
     * This method makes groups of players with the same score (higher to lower).
     * 
     * @return a map having a score as key and a list of players as value
     */
    private Map<Integer, List<U>> groupPlayersByScore() {
        return this.playersClassification.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.groupingBy(Map.Entry::getValue, LinkedHashMap::new,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
    }

    @Override
    protected final void nextTurn() {
        if (this.hasNextPlayer()) {
            this.runGame();
        }
    }

    /**
     * Setter for score.
     * 
     * @param score the score of the player
     */
    protected void setScore(final int score) {
        this.score = score;
    }

}
