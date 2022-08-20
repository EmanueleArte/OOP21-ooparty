package minigames.memo.model;

import java.util.List;
import minigames.common.model.MinigameModel;

/**
 * This interface models the minigame {@code memo}'s model. This interface is a
 * specialization of {@link MinigameModel}.
 *
 * @param <S> the scenes of the stage
 */
public interface MemoModel<S> extends MinigameModel<S> {

    /**
     * This methods tells if the minigame has ended.
     *
     * @return {@code true} if this game has ended, {@code false} otherwise.
     */
    boolean isOver();

    /**
     * This method runs the routine after a card is chosen. If there is no current
     * player, this method sets one.
     * 
     * @param index the index of the chosen card.
     * @return {@code true} if this card has been chosen, {@code false} otherwise.
     */
    boolean pickCard(int index);

    /**
     * This method tells the active cards.
     *
     * @return a list containing the active cards.
     */
    List<Integer> getCards();

}
