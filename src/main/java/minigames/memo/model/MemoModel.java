package minigames.memo.model;

import java.util.List;

import minigames.common.model.MinigameModel;

/**
 * This interface models the minigame {@code memo}'s model. This interface is a
 * specialization of {@link MinigameModel}.
 */
public interface MemoModel extends MinigameModel {

    /**
     * This methods tells if the minigame has ended.
     *
     * @return {@code true} if this game has ended, {@code false} otherwise.
     */
    boolean isOver();

    /**
     * This method tells the active cards.
     *
     * @return a list containing the active cards.
     */
    List<Integer> getCards();

    /**
     * This method sets the value of the next card to be chosen.
     */
    void setValue(int cardValue);

}
