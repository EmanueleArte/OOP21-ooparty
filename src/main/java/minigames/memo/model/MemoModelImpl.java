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

    static final int NUMBER_OF_PAIRS_PER_PLAYER = 5;
    private final List<Integer> cards;

    public MemoModelImpl(final List<Player> players, final StageManager<S> s) {
        super(players, s);
        this.cards = this.initialiseCards();
    }

    private List<Integer> initialiseCards() {
        return this.getCardsValues().flatMap(t -> Stream.of(t, t)).unordered().collect(Collectors.toList());
    }

    private Stream<Integer> getCardsValues() {
        return IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.getPlayers().size()).boxed();
    }

    public final int getCardValue(final int index) {
        return this.cards.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean runGame() {
        if (this.isOver()) {
            return true;
        }
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(this.getPlayers());
        }
        this.setCurrPlayer();

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return this.cards.isEmpty();
    }

    /**
     * 
     * @throws IndexOutOfBoundsException if {@code indexFirstCard} or {@code indexSecondCard} are out of the list.
     * @throws IllegalArgumentException if {@code indexFirstCard} is equals to {@code indexSecondCard}.
     */
    @Override
    public boolean chooseCards(final int indexFirstCard, final int indexSecondCard) throws RuntimeException {
        if (indexFirstCard >= this.cards.size() || indexSecondCard >= this.cards.size()) {
            throw new IndexOutOfBoundsException();
        }
        if (indexFirstCard == indexSecondCard) {
            throw new IllegalArgumentException();
        }
        return this.cards.get(indexFirstCard) == this.cards.get(indexSecondCard);
    }

    /**
     * 
     */
    @Override
    public void changeTurn() {
        // TODO Auto-generated method stub

    }

}
