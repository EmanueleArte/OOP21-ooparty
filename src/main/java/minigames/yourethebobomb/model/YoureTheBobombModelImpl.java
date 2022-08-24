package minigames.yourethebobomb.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import game.dice.model.DiceModel;
import game.player.Player;
import minigames.common.model.MinigameModelAbstr;

/**
 * Implementation of {@link YoureTheBobombModel} and extension of
 * {@link MinigameModelAbstr}.
 */
public class YoureTheBobombModelImpl extends MinigameModelAbstr implements YoureTheBobombModel {

    private static final int TOTAL_ROPES_NUMBER = 10;
    private static final int SCORE_FOR_EACH_ROPE_GUESSED = 1;

    private final List<Boolean> ropes;
    private Optional<Boolean> ropeChosen;
    private final List<Player> deadPlayer;

    /**
     * Builds a new {@link YoureTheBobombModelImpl}.
     *
     * @param players the players of the game.
     * @param dice    the dice controller.
     */
    public YoureTheBobombModelImpl(final List<Player> players, final DiceModel dice) {
        super(players, dice);
        this.ropes = this.initializeAllRopes();
        this.ropeChosen = Optional.empty();
        this.deadPlayer = new LinkedList<>();
        this.changeTurn();
        this.initializePlayersScores();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> getRopes() {
        return List.copyOf(this.ropes);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code true} if this the rope was a bomb, {@code false} otherwise.
     *
     * @throws IllegalStateException if the game is over.
     */
    public boolean runGame() {
        if (this.isOver()) {
            throw new IllegalStateException("The game is already over");
        }
        if (this.ropeChosen.isEmpty()) {
            return false;
        }
        if (!this.hasCurrPlayer()) {
            this.changeTurn();
        }
        final var ropeChosen = this.ropeChosen.get();
        this.ropeChosen = Optional.empty();
        this.ropes.remove(ropeChosen);
        this.setScore(this.getScore() + (ropeChosen ? 0 : SCORE_FOR_EACH_ROPE_GUESSED));
        if (ropeChosen) {
            this.deadPlayer.add(this.getCurrPlayer());
        }
        this.changeTurn();
        return ropeChosen;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRope(final Boolean rope) {
        this.ropeChosen = Optional.of(rope);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        final var end = this.deadPlayer.size() >= this.getPlayers().size() - 1;
        if (end) {
            this.setScore(this.getScore() + SCORE_FOR_EACH_ROPE_GUESSED);
            this.setGameResults();
        }
        return end;
    }

    private void changeTurn() {
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(
                    this.getPlayers().stream().filter(p -> !this.deadPlayer.contains(p)).collect(Collectors.toList()));
        }
        this.setCurrPlayer();
        this.ropeChosen = Optional.empty();
    }

    private List<Boolean> initializeAllRopes() {
        final var listRopes = IntStream.range(0, TOTAL_ROPES_NUMBER).boxed().map(i -> i < this.getPlayers().size() - 1)
                .collect(Collectors.toList());
        Collections.shuffle(listRopes);
        return listRopes;
    }

    private void initializePlayersScores() {
        this.getPlayers().stream().forEach(p -> this.scoreMapper(p, 0));
    }

}
