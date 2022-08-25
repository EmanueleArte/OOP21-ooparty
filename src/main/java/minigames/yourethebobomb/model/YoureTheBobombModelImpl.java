package minigames.yourethebobomb.model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import game.dice.model.DiceModel;
import game.player.Player;
import minigames.common.model.MinigameModelAbstr;

/**
 * Implementation of {@link YoureTheBobombModel} and extension of
 * {@link MinigameModelAbstr}.
 */
public class YoureTheBobombModelImpl extends MinigameModelAbstr implements YoureTheBobombModel {

    private static final int TOTAL_TILES_NUMBER = 4;
    private static final int SCORE_FOR_EACH_TILE_GUESSED = 1;

    private final Map<Integer, Optional<Set<Player>>> tiles;
    private final Set<Player> deadPlayer;

    /**
     * Builds a new {@link YoureTheBobombModelImpl}.
     *
     * @param players the players of the game.
     * @param dice    the dice controller.
     */
    public YoureTheBobombModelImpl(final List<Player> players, final DiceModel dice) {
        super(players, dice);
        this.tiles = this.initializeTiles();
        this.deadPlayer = new HashSet<>();
        this.setPlayersScore(p -> true, i -> 0);
        this.changeTurn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getTiles() {
        return List.copyOf(this.tiles.keySet());
    }

    /**
     * {@inheritDoc}
     */
    public boolean runGame() {
        if (this.isOver()) {
            return false;
        }
        this.eliminateTileAndPeopleOnIt(this.getRandomTile());
        this.setPlayersScore(p -> !this.deadPlayer.contains(p), i -> i + SCORE_FOR_EACH_TILE_GUESSED);
        return !this.isOver();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean chooseTile(final int tile) {
        if (this.tiles.containsKey(tile)) {
            this.tiles.put(tile,
                    Optional.of(Stream
                            .concat(this.tiles.get(tile).stream().flatMap(Set::stream), Stream.of(this.getCurrPlayer()))
                            .collect(Collectors.toSet())));
            this.changeTurn();
        }
        System.out.println(getCurrPlayer());
        return this.tiles.entrySet().stream().flatMap(e -> e.getValue().stream()).count() < this.getPlayers().size()
                - this.deadPlayer.size();
    }

    private boolean isOver() {
        final var end = this.tiles.size() <= 1 || (this.getPlayers().size() - this.deadPlayer.size() <= 1);
        if (end) {
            System.out.println(this.getPlayersClassification());
            this.setGameResults();
        }
        return end;
    }

    private int getRandomTile() {
        return this.tiles.keySet().stream().collect(Collectors.toList()).get(new Random().nextInt(this.tiles.size()));
    }

    private void eliminateTileAndPeopleOnIt(final int tile) {
        this.deadPlayer.addAll(this.tiles.get(tile).stream().flatMap(Set::stream).collect(Collectors.toList()));
        this.tiles.remove(tile);
        this.tiles.forEach((k, v) -> this.tiles.put(k, Optional.empty()));
    }

    private void changeTurn() {
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(
                    this.getPlayers().stream().filter(p -> !this.deadPlayer.contains(p)).collect(Collectors.toList()));
        }
        this.setCurrPlayer();
    }

    private Map<Integer, Optional<Set<Player>>> initializeTiles() {
        return IntStream.range(0, TOTAL_TILES_NUMBER).boxed()
                .collect(Collectors.toMap(Function.identity(), i -> Optional.empty()));
    }

    private void setPlayersScore(final Predicate<Player> predicate, final Function<Integer, Integer> function) {
        this.getPlayers().stream().filter(predicate::test)
                .forEach(p -> this.scoreMapper(p, function.apply(this.getPlayersClassification().getOrDefault(p, 0))));
    }

}
