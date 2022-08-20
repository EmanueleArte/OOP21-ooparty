package minigames.memo.model;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    /**
     * The number of points gave to a player for each pair of cards guessed.
     */
    static final int SCORE_FOR_GUESSED_PAIR = 1;
    private final List<Integer> cards;
    private Optional<Integer> tempCard;

    /**
     * Builds a new {@link MemoModelImpl}.
     *
     * @param players the players of the game.
     * @param s
     */
    public MemoModelImpl(final List<Player> players, final StageManager<S> s) {
        super(players, s);
        this.cards = this.initialiseCards();
        this.changeTurn();
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
     * {@inheritDoc}
     */
    @Override
    public boolean pickCard(final int indexFirstCard) {
        if (this.isOver()) {
            return false;
        }
        if (!hasCurrPlayer()) {
            this.changeTurn();
        }
        final var tempCardValue = this.cards.get(indexFirstCard);
        if (this.tempCard.isEmpty()) {
            this.tempCard = Optional.of(tempCardValue);
            return true;
        }
        this.tempCard = Optional.empty();
        if (tempCardValue.equals(this.tempCard.get())) {
            this.cards.removeIf(i -> i.equals(tempCardValue));
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
    public Player getCurrPlayer() {
        Player player;
        try {
            player = super.getCurrPlayer();
        } catch (Exception e) {
            this.setPlayerIterator(getPlayers());
            player = super.getCurrPlayer();
        }
        return player;
    }

    private List<Integer> initialiseCards() {
        final List<Integer> temp = this.getCardsValues().flatMap(t -> Stream.of(t, t)).collect(Collectors.toList());
        Collections.shuffle(temp);
        return temp;
    }

    private Stream<Integer> getCardsValues() {
        return IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.getPlayers().size()).boxed();
    }

    private void changeTurn() {
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(this.getPlayers());
        }
        this.setCurrPlayer();
        this.tempCard = Optional.empty();
    }
}
