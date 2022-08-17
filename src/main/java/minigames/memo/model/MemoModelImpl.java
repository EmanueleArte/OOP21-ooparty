package minigames.memo.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import game.player.Player;
import minigames.common.model.MinigameModelAbstr;
import utils.graphics.controller.StageManager;

/**
 * Implementation of {@link MemoModel} and extension of
 * {@link MinigameModelAbstr}.
 * 
 * @param <S> the scenes of the stage
 */
public class MemoModelImpl<S> extends MinigameModelAbstr<S> implements MemoModel<S> {

    /**
     * The number of pair of cards to create for each player.
     */
    static final int NUMBER_OF_PAIRS_PER_PLAYER = 5;
    static final int SCORE_FOR_GUESSED_PAIR = 1;
    private final List<Integer> cards;

    /**
     * Builds a new {@link MemoModelImpl}.
     *
     * @param players the players of the game.
     * @param s
     */
    public MemoModelImpl(final List<Player> players, final StageManager<S> s) {
        super(players, s);
        this.cards = this.initialiseCards();
    }

    /**
     * This method return a copy of the card-list.
     *
     * @return a copy of the list of the remaining cards.
     */
    @Override
    public List<Integer> getCards() {
        return List.copyOf(this.cards);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean runGame() {
        return false;
    }

    /**
     * This method tells if the game is over.
     *
     * @return {@code true} if the game is over, {@code false} otherwise.
     */
    @Override
    public boolean isOver() {
        return this.cards.isEmpty();
    }

    /**
     * This method runs a turn of memo.
     *
     * @returns {@code true} if the 2 cards are a pair, {@code false} otherwise.
     *
     * @throws IllegalStateException if the game is over.
     * @throws IndexOutOfBoundsException if {@code indexFirstCard} or {@code indexSecondCard} are out of the list.
     * @throws IllegalArgumentException if {@code indexFirstCard} is equals to {@code indexSecondCard}.
     */
    @Override
    public boolean doNextTurn(final int indexFirstCard, final int indexSecondCard) throws RuntimeException {
        if (this.isOver()) {
            throw new IllegalStateException("Game is over");
        }
        if (indexFirstCard >= this.cards.size() || indexSecondCard >= this.cards.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (indexFirstCard == indexSecondCard) {
            throw new IllegalArgumentException("The same card has been choosen twice");
        }
        final var tempCardValue = this.cards.get(indexFirstCard);
        if (tempCardValue.equals(this.cards.get(indexSecondCard))) {
            this.cards.removeIf(i -> i.equals(tempCardValue));
            this.setScore(this.getScore() + SCORE_FOR_GUESSED_PAIR);
            return true;
        }
        this.changeTurn();
        return false;
    }

    private List<Integer> initialiseCards() {
        return this.getCardsValues().flatMap(t -> Stream.of(t, t)).unordered().collect(Collectors.toList());
    }

    private Stream<Integer> getCardsValues() {
        return IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.getPlayers().size()).boxed();
    }

    private void changeTurn() {
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(this.getPlayers());
        }
        this.setCurrPlayer();
    }
}
