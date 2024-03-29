package minigames.memo.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import game.dice.model.DiceModel;
import game.player.Player;
import minigames.common.model.MinigameModelAbstr;

/**
 * Implementation of {@link MemoModel} and extension of
 * {@link MinigameModelAbstr}.
 */
public class MemoModelImpl extends MinigameModelAbstr implements MemoModel {

    private static final int NUMBER_OF_PAIRS_PER_PLAYER = 4;
    private static final int SCORE_FOR_GUESSED_PAIR = 1;

    private final List<Integer> cards;
    private Optional<Integer> firstCard;
    private Optional<Integer> secondCard;

    /**
     * Builds a new {@link MemoModelImpl}.
     *
     * @param players the players of the game.
     * @param dice    the dice controller.
     */
    public MemoModelImpl(final List<Player> players, final DiceModel dice) {
        super(players, dice);
        this.cards = this.initialiseCards();
        this.changeTurn();
        this.initializePlayersScores();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getCards() {
        return List.copyOf(this.cards);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@code true} if this turn scored a point, {@code false} otherwise.
     *
     * @throws IllegalStateException if the game is over.
     */
    @Override
    public boolean runGame() {
        if (this.isOver()) {
            throw new IllegalStateException("The game is already over");
        }
        if (!this.hasCurrPlayer()) {
            this.changeTurn();
        }
        if (!this.areBothCardsSelected()) {
            return false;
        }
        final var firstCard = this.firstCard.get();
        final var secondCard = this.secondCard.get();
        this.resetValues();
        if (!firstCard.equals(secondCard)) {
            this.changeTurn();
            return false;
        }
        if (this.cards.contains(firstCard) && this.cards.contains(secondCard)) {
            this.cards.removeIf(i -> i.equals(firstCard));
            this.setScore(this.getScore() + SCORE_FOR_GUESSED_PAIR);
            return true;
        }
        this.changeTurn();
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        final var end = this.cards.isEmpty();
        if (end) {
            this.setGameResults();
        }
        return end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(final int cardValue) {
        if (this.firstCard.isEmpty()) {
            this.firstCard = Optional.of(cardValue);
            return;
        }
        if (this.secondCard.isEmpty()) {
            this.secondCard = Optional.of(cardValue);
        }
    }

    private void resetValues() {
        this.firstCard = Optional.empty();
        this.secondCard = Optional.empty();
    }

    private boolean areBothCardsSelected() {
        return this.firstCard.isPresent() && this.secondCard.isPresent();
    }

    private void changeTurn() {
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(this.getPlayers());
        }
        this.setCurrPlayer();
        this.resetValues();
    }

    private List<Integer> initialiseCards() {
        final List<Integer> temp = this.getCardsValues().flatMap(t -> Stream.of(t, t)).collect(Collectors.toList());
        Collections.shuffle(temp);
        return temp;
    }

    private Stream<Integer> getCardsValues() {
        return IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.getPlayers().size()).boxed();
    }

    private void initializePlayersScores() {
        this.getPlayers().forEach(p -> this.scoreMapper(p, 0));
    }

}
