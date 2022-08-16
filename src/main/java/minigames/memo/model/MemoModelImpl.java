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
        return IntStream.range(0, NUMBER_OF_PAIRS_PER_PLAYER * this.getPlayers().size()).boxed()
                .flatMap(t -> IntStream.of(t, t).boxed()).unordered().collect(Collectors.toList());
    }

    @Override
    public final boolean runGame() {
        if (this.isOver()) {
            return true;
        }
        if (!this.hasNextPlayer()) {
            this.setPlayerIterator(this.getPlayers());
        }
        this.setCurrPlayer();

        return true;
    }

    @Override
    public final boolean isOver() {
        return this.cards.isEmpty();
    }

    @Override
    public final boolean chooseCards(final int indexFirstCard, final int indexSecondCard) {
        if (indexFirstCard == indexSecondCard) {
            return false;
        }
        if (this.cards.get(indexFirstCard) == this.cards.get(indexSecondCard)) {
            this.scoreMapper(this.getCurrPlayer(), this.getPlayersClassification().get(getCurrPlayer()) + 1);

        }
    }

    @Override
    public void changeTurn() {
        // TODO Auto-generated method stub

    }

}
